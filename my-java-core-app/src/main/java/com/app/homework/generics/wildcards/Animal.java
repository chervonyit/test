package com.app.homework.generics.wildcards;

public class Animal {

    private int id;

    public Animal(){

    }

    public Animal(int id){
        this.id = id;
    }

    public void eat(){
        System.out.println("Eating...");
    }

    @Override
    public String toString(){
        return String.valueOf(id);
    }
}
