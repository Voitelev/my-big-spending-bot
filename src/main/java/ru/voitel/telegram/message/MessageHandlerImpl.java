package ru.voitel.telegram.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.voitel.telegram.category.CategoryHandler;
import ru.voitel.telegram.user.UserHandler;

@Component
public class MessageHandlerImpl implements MessageHandler {

    private final UserHandler userHandler;
    private final CategoryHandler categoryHandler;

    @Autowired
    public MessageHandlerImpl(UserHandler userHandler, CategoryHandler categoryHandler) {
        this.userHandler = userHandler;
        this.categoryHandler = categoryHandler;
    }

    public SendMessage processingMessage(Message message) {
        Long chatID = message.getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID.toString());
        if (userHandler.checkUser(message.getFrom())) {//проверяем если у нас такой пользователь
            sendMessage.setChatId(chatID.toString());
            sendMessage.setText("Привет! Запишем твои расходы");
        } else {
            userHandler.addUser(message.getFrom());
            sendMessage.setChatId(chatID.toString());
            sendMessage.setText("Привет! Тебя нету в базе. Введи свое имя");
        }
        System.out.println("chat id " + chatID + " " + message.getText());
        return sendMessage;
    }

    private void installingKeyboard() {

    }
}

