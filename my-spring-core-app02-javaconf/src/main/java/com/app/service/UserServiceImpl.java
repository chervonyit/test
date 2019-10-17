package com.app.service;

import com.app.domain.User;
import com.app.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceImpl implements UserService {
    private Dao dao;
    private String someValue;

    public void createUser(String name, int age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        dao.save(user);
    }

    public List<User> findAll() {
        return dao.readAll();
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
