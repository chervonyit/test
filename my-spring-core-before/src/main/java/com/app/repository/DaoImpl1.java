package com.app.repository;

import com.app.domain.User;

import java.util.ArrayList;
import java.util.List;

public class DaoImpl1 implements Dao {
    private List<User> users = new ArrayList();

    public void save(User user) {
        users.add(user);
    }

    public List<User> readAll() {
        return users;
    }
}
