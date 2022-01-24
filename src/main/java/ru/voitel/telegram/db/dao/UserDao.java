package ru.voitel.telegram.db.dao;

import ru.voitel.telegram.db.model.User;

/**
 * Интерфейс с методами работы с пользователями в БД
 */
public interface UserDao {

    /**
     * Создание пользователя в БД
     * @param user данные пользователя
     */
    void create(User user);

    /**
     * Получение пользователя по его userID
     * @param userID id пользователя.
     * @return возвращает пользователя.
     */
    User getUser(Integer userID);

    void update(User user);
}
