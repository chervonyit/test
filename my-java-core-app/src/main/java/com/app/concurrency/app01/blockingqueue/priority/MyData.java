package com.app.concurrency.app01.blockingqueue.priority;

public class MyData implements Comparable<MyData> {
     private String name;
     private int age;

    public MyData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(MyData other) {
        if(other==null){
            return 1;
        }
        if(other.age!=age){
            return age-other.age;
        }
        if(other.name!=null &&name!=null){
            return name.compareTo(other.name);
        }
        if(other.name==null &&name==null){
            return 0;
        }
        if(other.name!=null && name==null){
            return -1;
        }
        if(other.name==null && name!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
