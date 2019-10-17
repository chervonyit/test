package net.data.processor.simple;

import net.data.model.MyBook;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XmlSaxSimpleDataProcessor implements SimpleDataProcessor {

    @Override
    public String write(MyBook myBook) {
        try (InputStream in = getClass().getResourceAsStream("/xml_template.xml")) {
            byte[] data = new byte[in.available()];
            in.read(data);
            String template = new String(data);
            return String.format(template, myBook.getTitle(), myBook.getPageAmount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MyBook read(byte[] data) {
        final MyBook myBook = new MyBook();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try (ByteArrayInputStream in = new ByteArrayInputStream(data)){
            SAXParser parser = factory.newSAXParser();
            parser.parse(in, new DefaultHandler(){

                private String currentTag;


                @Override
                public void startDocument() throws SAXException {
                    System.out.println("startDocument()");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("<"+qName);
                    currentTag=qName;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String value = new String(ch,start,length);
                    value = value.trim();
                    if(!value.isEmpty()){
                        if("title".equals(currentTag)){
                            myBook.setTitle(value);
                        }
                        if("pageamount".equals(currentTag)){
                            myBook.setPageAmount(Integer.parseInt(value));
                        }
                    }

                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("</"+qName);
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("endDocument()");
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return myBook;
    }
}
