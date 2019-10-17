package net.data.main.json;

import net.data.model.MyBook;
import net.data.processor.simple.JsonSimpleDataProcessor;
import net.data.processor.simple.SimpleDataProcessor;
import net.data.processor.simple.XmlDomSimpleProcessor;

public class JsonSimpleDataProcessorMain {

    public static void main(String[] args) {
        MyBook myBook = new MyBook(100,"Book1");
        SimpleDataProcessor simpleDataProcessor = new JsonSimpleDataProcessor();
        String json=simpleDataProcessor.write(myBook);
        System.out.println(json);
        System.out.println("---------------------");
        MyBook result=simpleDataProcessor.read(json.getBytes());
        System.out.println(result);
    }

}
