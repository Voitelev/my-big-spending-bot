package ru.voitel.telegram.db.service;

import ru.voitel.telegram.db.model.User;

public interface UserService {

    void create(User user);

    void update(User user);

    User getUser(Long chatId);
}
