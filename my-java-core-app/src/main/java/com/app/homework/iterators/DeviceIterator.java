package com.app.homework.iterators;

import com.app.homework.Device;

import java.util.ArrayList;
import java.util.Iterator;

public class DeviceIterator<String> implements Iterator<Device> {

    private ArrayList<?> devices;
    private int position;

    public DeviceIterator(Device device){
      //  this.devices = device.getDevices();
    }

    @Override
    public boolean hasNext() {
        if(position < devices.size()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Device next() {
        Device d = (Device)devices.get(position);
        position++;
        return d;
    }

    @Override
    public void remove() {
        devices.remove(position);
    }
}
