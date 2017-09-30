package com.kj.service;

import com.kj.entity.User;

import java.util.List;

/**
 * Created by wyh on 2017/9/30.
 */
public interface UserService {
    public boolean addUser(User user);

    public boolean login(User user);

    public List getAllUser();

    public User getUserById(int id);

    public boolean updateUser(User user);

    public boolean deleteUser(int id);
}
