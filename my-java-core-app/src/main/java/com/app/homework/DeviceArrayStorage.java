package com.app.homework;

import com.app.homework.exceptions.DeviceArrayEmptyException;
import com.app.homework.interfaces.IStorage;

import java.util.Arrays;

/**
 * DeviceArrayStorage class for handling devices in array. Array data structure is used.
 */
public class DeviceArrayStorage implements IStorage {

    private Device[] devicesStorage;
    private int n;
    private int capacity;

    public DeviceArrayStorage(int capacity) {
        this.capacity = capacity;
        devicesStorage = new Device[capacity];
    }

    public DeviceArrayStorage() {
        this(10);
    }


    @Override
    public void add(Device device) {
        if (n + 1 > devicesStorage.length) {
            devicesStorage = Arrays.copyOf(devicesStorage, devicesStorage.length + capacity);
        }
        devicesStorage[n] = device;
        n++;
    }

    @Override
    public Device get(int index) {
        return devicesStorage[index];
    }

    @Override
    public Device set(int index, Device item) {
        Device oldValue = devicesStorage[index];
        devicesStorage[index] = item;
        return oldValue;
    }

    @Override
    public void remove(int index) throws DeviceArrayEmptyException {
        for (int i = index; i < n - 1; i++) {
            devicesStorage[i] = devicesStorage[i + 1];
        }
        devicesStorage[n - 1] = null;
        n--;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void clear() {
        devicesStorage = new Device[devicesStorage.length];
        n = 0;
    }
}
