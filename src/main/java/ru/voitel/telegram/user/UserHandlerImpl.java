package ru.voitel.telegram.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.voitel.telegram.db.model.User;
import ru.voitel.telegram.db.service.UserService;

@Component
public class UserHandlerImpl implements UserHandler {

    private final UserService userService;

    @Autowired
    public UserHandlerImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * Проверка пользователя на наличие его в таблице User
     * @param user модель пользователя Telegram
     * @return возвращает true - если есть пользователь, false - если нету
     */
    @Override
    public boolean checkUser(org.telegram.telegrambots.meta.api.objects.User user) {
        User userDB = userService.getUser(user.getId());
        if (userDB == null) {
           System.out.println("Пользователь с chatId=" + user.getId() + "не найден");
           return false;
        }
        return true;
    }

    /**
     * Добавление пользователя в базу
     *
     * @param user Модель пользователя
     */
    @Override
    public void addUser(org.telegram.telegrambots.meta.api.objects.User user) {
        User userDB = new User();
        userDB.setIdUser(user.getId());
        userDB.setName(user.getUserName());
        userService.createUser(userDB);
    }
}
