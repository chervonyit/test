package net.data.main.xml;

import net.data.model.MyBook;
import net.data.processor.simple.SimpleDataProcessor;
import net.data.processor.simple.XmlDomSimpleProcessor;
import net.data.processor.simple.XmlJaxbSimpleProcessor;

public class XmlDomSimpleProcessorMain {

    public static void main(String[] args) {
        MyBook myBook = new MyBook(100,"Book1");
        SimpleDataProcessor simpleDataProcessor = new XmlDomSimpleProcessor();
        String xml=simpleDataProcessor.write(myBook);
        System.out.println(xml);
        System.out.println("---------------------");
        MyBook result=simpleDataProcessor.read(xml.getBytes());
        System.out.println(result);
    }
}
