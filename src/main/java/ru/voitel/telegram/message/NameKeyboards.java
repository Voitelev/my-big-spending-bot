package ru.voitel.telegram.message;

import java.util.Arrays;

public enum NameKeyboards {
    REGISTRATION("Регистрация"),
    ADDSENDING("Добавить операцию"),
    ADDCATEGORY("Добавить/Изменить операцию");

    private final String keyboard;

    NameKeyboards(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getAction() {
        return keyboard;
    }

    /**
     * Получение {@link Keyboard} по коду действия
     *
     * @param keyboard название меню
     * @return {@link Keyboard} или {@throws IllegalArgumentException}, если такой константы нет
     */
    public static NameKeyboards getByName(String keyboard) {
        return Arrays.stream(values())
                .filter(e -> e.getAction().equals(keyboard))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No constant with code " + keyboard + " found"));
    }
}
