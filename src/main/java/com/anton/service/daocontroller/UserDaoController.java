package com.anton.service.daocontroller;

import com.anton.service.dao.userdao.UserDao;
import com.anton.service.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class UserDaoController {

    private final UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUser(String mail, String password) {
        return userDao.getUser(mail, password);
    }
}
