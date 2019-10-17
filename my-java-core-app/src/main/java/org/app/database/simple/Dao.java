package org.app.database.simple;

import java.util.List;
import java.util.Map;

public interface Dao {

    public void create(MyItem myItem);

    public List<MyItem> read();

    public void update(MyItem currentMyItem, MyItem candidate);

    public void delete(MyItem myItem);

    public List<Map<String, Object>> meatInf();

}
