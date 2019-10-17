package com.app.config;


import com.app.repository.Dao;
import com.app.repository.DaoImpl1;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Dao dao1(){
        System.out.println("dao1()");
        return new DaoImpl1();
    }

    @Bean
    public Dao dao2(){
        return new DaoImpl1();
    }

    @Bean
    public UserService userService(){
        Dao dao = dao1();
        Dao daoA = dao1();
        UserServiceImpl userService = new UserServiceImpl();
        userService.setDao(dao);
        return userService;
    }


}
