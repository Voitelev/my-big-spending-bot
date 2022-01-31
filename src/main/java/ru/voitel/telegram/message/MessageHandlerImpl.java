package ru.voitel.telegram.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.voitel.telegram.category.CategoryHandler;
import ru.voitel.telegram.db.model.User;
import ru.voitel.telegram.state.StateEnum;
import ru.voitel.telegram.user.UserHandler;

import java.util.ArrayList;

@Component
public class MessageHandlerImpl implements MessageHandler {

    private final UserHandler userHandler;
    private final CategoryHandler categoryHandler;

    private final String USER_HAVE_NO_CATEGORIES = "У вас нету категорий";

    @Autowired
    public MessageHandlerImpl(UserHandler userHandler, CategoryHandler categoryHandler) {
        this.userHandler = userHandler;
        this.categoryHandler = categoryHandler;
    }

    public SendMessage processingMessage(Message message) {
        Long chatID = message.getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID.toString());
        User user = userHandler.getUser(message.getFrom().getId());
        initializationKeyboardForStateStart(sendMessage);
        if (user == null) {    //проверяем если у нас такой пользователь
            sendMessage.setChatId(chatID.toString());
            userHandler.addUser(message.getFrom());
            sendMessage.setText("Привет! " + message.getChat().getFirstName() + " мы тебя записали. Зайди в меню");
            return initializationKeyboardForStateStart(sendMessage);
        } else {
            if (message.getText().equals(StateEnum.CATEGORY.getDescription())) {
                String categories = categoryHandler.getUserCategories(message.getFrom().getId());
                if( categories.isEmpty()) {
                    sendMessage.setText(USER_HAVE_NO_CATEGORIES);
                }
                sendMessage.setChatId(chatID.toString());
                return initializationKeyboardForStateCategory(sendMessage);
            }
        }

        System.out.println("chat id " + chatID + " " + message.getText());
        sendMessage.setText("1");
        return sendMessage;
    }

    private SendMessage initializationKeyboardForStateStart(SendMessage message) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(StateEnum.CATEGORY.getDescription());
        keyboardFirstRow.add(StateEnum.SENDING.getDescription());
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(replyKeyboardMarkup);
        return message;
    }

    private SendMessage initializationKeyboardForStateCategory(SendMessage message) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(StateEnum.ADD_CATEGORY.getDescription());
        keyboardFirstRow.add(StateEnum.DELETE_CATEGORY.getDescription());
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(replyKeyboardMarkup);
        return message;
    }
}

