package com.app.repository;

import com.app.domain.User;

import java.util.List;

public interface Dao {

    public void save(User user);

    public List<User> readAll();

}
