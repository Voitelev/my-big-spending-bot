package ru.voitel.telegram.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.voitel.telegram.db.model.User;
import ru.voitel.telegram.db.service.UserService;

@Component
public class UserHandlerImpl implements UserHandler {

    private UserService userService;

    @Autowired
    public UserHandlerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean checkUser(Long chatId) {
        User user = userService.getUser(chatId);
        if (user == null) {
           System.out.println("Пользователь с chatId=" + chatId + "не найден");
           return false;
        }
        System.out.println("Пользователь найден " + user.name + " " + user.chatId);
        return true;
    }
}
