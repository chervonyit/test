package com.app.repository;

import com.app.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoImpl1 implements Dao {
    private List<User> users = new ArrayList();

    /*public DaoImpl1(){
        System.out.println("DaoImpl1(). Constructor");
    }*/

    public void init(){
        System.out.println("DaoImpl1().init()");
    }


    public void save(User user) {
        users.add(user);
    }

    public List<User> readAll() {
        return users;
    }

    public void destroy(){
        System.out.println("DaoImpl1().destroy()");
    }
}
