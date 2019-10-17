package com.app.repository;

import com.app.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoImpl2 implements Dao {

    public void save(User user) {

    }

    public List<User> readAll() {
        return new ArrayList<User>();
    }
}
