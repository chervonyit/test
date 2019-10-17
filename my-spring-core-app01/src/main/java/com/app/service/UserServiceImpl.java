package com.app.service;

import com.app.domain.User;
import com.app.repository.Dao;

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

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }
}
