package com.app.service;

import com.app.domain.User;

import java.util.List;

public interface UserService {

    public void createUser(String name, int age);

    public List<User> findAll();
}
