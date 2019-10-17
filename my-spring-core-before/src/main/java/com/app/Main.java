package com.app;

import com.app.domain.User;
import com.app.repository.Dao;
import com.app.repository.DaoImpl1;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        Dao dao = new DaoImpl1();
        userService.setDao(dao);

        userService.createUser("UserA", 1);


        List<User> users = userService.findAll();
        for(User u: users){
            System.out.println(u);
        }


    }
}
