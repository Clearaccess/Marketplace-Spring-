package com.marketplace.spring.dao;

import com.marketplace.spring.models.User;

import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 1/17/2017.
 */
public interface UserDAO {

    long insert(User user);
    void update(User user);
    void delete(User user);
    User getById(long id);
    User getByLogin(String login);
    ArrayList<User> getAll();
}
