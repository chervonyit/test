package com.app.homework;

import com.app.homework.exceptions.DeviceNotFoundException;
import com.app.homework.iterators.DeviceIterator;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Device extends Product {

    private String model;
    private final String manufacturer;
    private ArrayList<Device> devices = new ArrayList<Device>();

    // initialize constant in init block
    {
        manufacturer = "Electronics Incorporation";
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return String.format("Device: id: %s, weight:%s, height:%s", getId(), getHeight(), getWeight());
    }

    public void readDeviceFromDB() throws DeviceNotFoundException{
                    String connectionString = "";
            // some login to connect to DB and read device
            if(connectionString.equals("")){
                throw new DeviceNotFoundException("");
            }

    }

    /**
     *
     * @param o Object to compare with
     * @return true if object are equals by id
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() == this.getClass()) {
            Device device = (Device) o;
            if (device.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return int value of the hashCode based on model hashCode and product ID
     */
    @Override
    public int hashCode() {
        int hash = 0;
        if (model != null) {
            hash += model.hashCode() + getId();
        }
        return hash;
    }
}
