package com.app.homework.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class WildCardMain {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1));
        animals.add(new Animal(2));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1));
        dogs.add(new Dog(2));

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());

        get(animals);
        get(dogs);
        set(animals);
        set(dogs);
        //set(cats);
    }

    /*
        Object
        Animal
        Dog, Cat, Rabbit, ...
     */

    // PECS

    public static void get(List<? extends Animal> animals){
        for (Animal a : animals){
            a.eat();
        }
    }

    public static void set(List<? super Dog> animals){
        System.out.println(animals.toString());
    }
}
