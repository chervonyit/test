package com.app.homework.devices;

import com.app.homework.Device;

public class Laptop extends Device {

    private int screenSize;

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    /**
     *
     * @param o Object to compare with
     * @return true if object equals by model and screen size
     */
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null){
            return false;
        }
        if(o.getClass() == this.getClass()){
            Laptop comparedLaptop = (Laptop) o;
            if(comparedLaptop.getModel().equalsIgnoreCase(this.getModel())){
                return comparedLaptop.getScreenSize() == this.getScreenSize();
            }
        }
        return false;
    }
}
