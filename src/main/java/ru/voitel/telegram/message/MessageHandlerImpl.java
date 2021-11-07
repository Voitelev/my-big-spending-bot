package ru.voitel.telegram.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.voitel.telegram.user.UserHandler;

import java.util.ArrayList;

@Component
public class MessageHandlerImpl implements MessageHandler {

    @Autowired
    private UserHandler userHandler;


    public SendMessage processingMessage(Message message) {
        Long chatID = message.getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID.toString());
        if (!userHandler.checkUser(chatID)) {
            sendMessage.setChatId(chatID.toString());
            sendMessage.setText("Привет! Тебя нету в базе. Введи свое имя");
        } else {
            sendMessage.setChatId(chatID.toString());
            sendMessage.setText("Привет! Запишем твои расходы");
        }
        System.out.println("chat id " + chatID + " " + message.getText());
        return sendMessage;
    }

    private void installingKeyboard() {

    }
}

