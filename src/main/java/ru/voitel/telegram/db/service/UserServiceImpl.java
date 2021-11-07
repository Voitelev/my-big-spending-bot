package ru.voitel.telegram.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.voitel.telegram.db.dao.UserDao;
import ru.voitel.telegram.db.model.User;

import javax.transaction.Transactional;

@Component
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    @Transactional
    public User getUser(Long chatId) {
        return userDao.getUser(chatId);
    }
}
