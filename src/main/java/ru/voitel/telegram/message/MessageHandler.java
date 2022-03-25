package ru.voitel.telegram.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageHandler {
    /**
     * Обработка сообщения
     *
     * @param message входящее сообщение
     * @return ответ на сообщение
     */
    SendMessage processingMessage(Message message);
}
