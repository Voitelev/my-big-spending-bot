package ru.voitel.telegram.state;

/**
 * Состояние пользователя
 */
public enum StateEnum {
    CATEGORY("Категория", 1),
    SENDING("Расходы", 2);

    private String description;
    private Integer code;

    StateEnum(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCode() {
        return code;
    }

    public static StateEnum getEnumByCode(Integer code) {
        for (StateEnum entry : StateEnum.values()) {
            if (entry.getCode().equals(code)) {
                return entry;
            }
        }

        throw new IllegalArgumentException("Передано некорректное значение: " + code);
    }
}
