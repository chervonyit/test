package net.data.processor.simple;

import net.data.model.MyBook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class XmlJaxbSimpleProcessor implements SimpleDataProcessor {

    @Override
    public String write(MyBook myBook) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
            JAXBContext ctx = JAXBContext.newInstance(MyBook.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.marshal(myBook, out);
            return new String(out.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
        }

    }

    @Override
    public MyBook read(byte[] data) {
        try(ByteArrayInputStream in = new ByteArrayInputStream(data)){
            JAXBContext ctx = JAXBContext.newInstance(MyBook.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            return (MyBook) unmarshaller.unmarshal(in);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

    }
}
