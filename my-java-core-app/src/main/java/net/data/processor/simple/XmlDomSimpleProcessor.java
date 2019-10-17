package net.data.processor.simple;

import net.data.model.MyBook;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class XmlDomSimpleProcessor implements  SimpleDataProcessor {

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
     //   String str=new String(data);
     //   System.out.println(str);
        MyBook myBook = new MyBook();
        try(ByteArrayInputStream in = new ByteArrayInputStream(data)){
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(in);
           // System.out.println(document.getFirstChild());
            Node node = document.getFirstChild();
            NodeList list = node.getChildNodes();
            for(int i=0;i<list.getLength();i++){
                Node tmp = list.item(i);
                String text=tmp.getTextContent().trim();
                if(!text.isEmpty()){
                    if(myBook.getTitle()==null){
                        myBook.setTitle(text);
                    }else{
                        myBook.setPageAmount(Integer.parseInt(text));
                    }
                }
                System.out.println(text);

            }

            /*Node node = document.getFirstChild();
            NodeList list = node.getChildNodes();
            for(int i=0;i<list.getLength();i++){
                Node child = list.item(i);
                System.out.println(child);
            }*/

            return myBook;
        } catch(Exception e){
            throw  new RuntimeException(e);
        }

    }
}

