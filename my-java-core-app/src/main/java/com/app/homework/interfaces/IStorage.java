package com.app.homework.interfaces;

import com.app.homework.Device;
import com.app.homework.exceptions.DeviceArrayEmptyException;

public interface IStorage {

    void add(Device device);
    void remove(int index);
    Device set(int index, Device item);
    Device get(int index);
    int size();
    boolean isEmpty();
    void clear();
}
