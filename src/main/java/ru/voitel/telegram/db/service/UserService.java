package ru.voitel.telegram.db.service;

import ru.voitel.telegram.db.model.User;

public interface UserService {

    void update(User user);

    User getUser(Integer chatId);

    void createUser(User user);
}
