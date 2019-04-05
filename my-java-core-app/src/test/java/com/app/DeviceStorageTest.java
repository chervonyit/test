package com.app;

import com.app.homework.Device;
import com.app.homework.DeviceArrayStorage;
import com.app.homework.devices.Laptop;
import com.app.homework.devices.Phone;
import com.app.homework.exceptions.DeviceArrayEmptyException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeviceStorageTest {

    DeviceArrayStorage deviceArrayStorage;

    @BeforeMethod
    public void testSetup(){
        Device phone = new Phone();
        Device laptop = new Laptop();
        deviceArrayStorage = new DeviceArrayStorage();
    }

    @Test
    public void addItemTest(){
        int initSize = deviceArrayStorage.size();
        Device phone = new Phone();
        deviceArrayStorage.add(phone);

        Assert.assertEquals(initSize, deviceArrayStorage.size() - 1);
    }

    @Test
    public void removeItemTest() throws DeviceArrayEmptyException {
        Device laptop = new Laptop();
        deviceArrayStorage.add(laptop);
        int initSize = deviceArrayStorage.size();
        deviceArrayStorage.remove(0);

        Assert.assertEquals(initSize - 1, deviceArrayStorage.size());
    }

    @Test
    public void setTest(){
        Device laptop = new Laptop();
        DeviceArrayStorage deviceArrayStorage = new DeviceArrayStorage();
        deviceArrayStorage.add(laptop);

        Device phone = new Phone();
        int phoneID = phone.getId();
        deviceArrayStorage.set(0, phone);
        Assert.assertEquals(phoneID, deviceArrayStorage.get(0).getId());
    }

    @Test
    public void isEmptyTest(){
        Device laptop = new Laptop();
        DeviceArrayStorage deviceArrayStorage = new DeviceArrayStorage();

        Assert.assertTrue(deviceArrayStorage.isEmpty());
        deviceArrayStorage.add(laptop);
        Assert.assertFalse(deviceArrayStorage.isEmpty());
    }
}
