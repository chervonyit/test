package com.app.homework.mains;

import com.app.homework.Device;
import com.app.homework.DeviceArrayStorage;
import com.app.homework.enums.DeviceTypes;
import com.app.homework.exceptions.DeviceArrayEmptyException;
import com.app.homework.factory.DeviceFactory;

public class DeviceArraysMain {

    public static void main(String[] args) {

        // create devices using DeviceFactory
        DeviceFactory factory = new DeviceFactory();

        Device phone = factory.createDevice(DeviceTypes.PHONE);
        phone.setModel("iPhone");
        Device laptop = factory.createDevice(DeviceTypes.LAPTOP);
        laptop.setModel("lenovoT470s");
        Device tv = factory.createDevice(DeviceTypes.TV);
        tv.setModel("samsung S100");

        // Adding devices to the DeviceArrayStorage
        DeviceArrayStorage deviceArrayStorage = new DeviceArrayStorage();
        deviceArrayStorage.add(phone);
        deviceArrayStorage.add(laptop);
        deviceArrayStorage.add(tv);

        DeviceArrayStorage deviceArray1 = new DeviceArrayStorage();
        deviceArray1.add(phone);
        deviceArray1.add(laptop);
        deviceArray1.add(tv);

        //System.out.println(deviceArray1.compareArrays(deviceArrayStorage.getDevicesStorage()));

        // catch exception that potentially can be thrown in remove method
        try {
            deviceArrayStorage.remove(0);
        } catch (DeviceArrayEmptyException e) {
            e.printStackTrace();
        }

        // looping through the deviceArrayStorage and print model of each device
        for(Device d : deviceArrayStorage.getDevicesStorage()){
            if(d != null){
                System.out.println(d.getModel());
            }
        }
    }
}
