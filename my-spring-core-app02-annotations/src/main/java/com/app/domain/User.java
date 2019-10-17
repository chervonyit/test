package com.app.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy(value = false)
@Scope(value="prototype")
public class User {

    private String name;
    private int age;

    @PostConstruct
    public void init(){
        System.out.println("User.created.@PostConstruct ");
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
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @PreDestroy
    public void destroy(){
        System.out.println("User.created.@PreConstruct ");
    }
}
