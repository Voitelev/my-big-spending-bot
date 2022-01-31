package ru.voitel.telegram.user;

import org.telegram.telegrambots.meta.api.objects.User;

public interface UserHandler {

    /**
     * Получение информации о пользователе из БД
     * @param idUser id пользователя
     * @return  пользователь
     */
    ru.voitel.telegram.db.model.User getUser(Integer idUser);

    /**
     * Проверка пользователя на наличие его в таблице User
     * @param user модель пользователя Telegram
     * @return возвращает true - если есть пользователь, false - если нету
     */
    boolean checkUser(User user);

    /**
     * Добавление пользователя в базу
     * @param user Модель пользователя
     */
    void addUser(User user);

}
