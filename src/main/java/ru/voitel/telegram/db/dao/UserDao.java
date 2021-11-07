package ru.voitel.telegram.db.dao;

import ru.voitel.telegram.db.model.User;


public interface UserDao {

    void create(User user);

    void update(User user);

    User getUser(Long chatId);
}
