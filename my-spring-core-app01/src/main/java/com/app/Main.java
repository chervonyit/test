package com.app;

import com.app.domain.User;
import com.app.repository.Dao;
import com.app.repository.DaoImpl1;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");
        System.out.println("-------------Context created--------------------");
        //UserService userService = (UserService) ctx.getBean("userService");
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.createUser("A", 1);
        List<User> users = userService.findAll();
        for(User u: users){
            System.out.println(u);
        }
        //ctx.close();

        System.out.println("-------------------------------");
        User userA = ctx.getBean("userA", User.class);
        User userA1 = ctx.getBean("userA", User.class);
        System.out.println(userA.hashCode());
        System.out.println(userA1.hashCode());

        System.out.println("-------------------------------");
        User userB = ctx.getBean("userB", User.class);
        User userB1 = ctx.getBean("userB", User.class);
        System.out.println(userB.hashCode());
        System.out.println(userB1.hashCode());



        //User userB = new User();

    }
}
