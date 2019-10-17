package net.data.processor.simple;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.data.model.MyBook;

public class JsonSimpleDataProcessor implements SimpleDataProcessor {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String write(MyBook myBook) {
        try {
            return mapper.writeValueAsString(myBook);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MyBook read(byte[] data) {
        try {
            return mapper.readValue(new String(data), MyBook.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
