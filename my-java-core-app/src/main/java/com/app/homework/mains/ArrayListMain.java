package com.app.homework.mains;

import com.app.homework.Device;
import com.app.homework.devices.Laptop;
import com.app.homework.devices.Phone;
import com.app.homework.devices.Tv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListMain {

    public static void main(String[] args) {
        List<Device> list = new ArrayList<>();

        list.add(new Phone());
        list.add(new Laptop());
        list.add(new Tv());

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Device d = (Device)iterator.next();
            System.out.println(d.getModel());
        }

    }
}
