package ru.voitel.telegram.message;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

@Component
public class Keyboard {
    private ArrayList<KeyboardRow> keyboard = new ArrayList<>();
    private KeyboardRow keyboard1Row = new KeyboardRow();
    private KeyboardRow keyboard2Row = new KeyboardRow();

    public void installingKeyboard( ReplyKeyboardMarkup replyKeyboardMarkup) {
        keyboard1Row.add(NameKeyboards.ADDCATEGORY.getAction());
        keyboard2Row.add(NameKeyboards.ADDSENDING.getAction());
        keyboard.add(keyboard1Row);
        keyboard.add(keyboard1Row);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

}
