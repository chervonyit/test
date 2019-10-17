package net.data.processor.simple;

import net.data.model.MyBook;

public interface SimpleDataProcessor {

    public String write(MyBook myBook);

    public MyBook read(byte[] data);
}
