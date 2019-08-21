package com.anton.service.dao.userdao;

import com.anton.service.entity.User;

public interface UserDao {
    void addUser(User user);

    User getUser(String mail, String password);

}
