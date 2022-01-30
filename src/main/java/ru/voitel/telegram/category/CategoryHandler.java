package ru.voitel.telegram.category;

import org.springframework.stereotype.Component;

/**
 * Обработчик категорий пользователя
 */
@Component
public interface CategoryHandler {
    /**
     * Создание категории
     */
    void createCategory();

    /**
     * Получение категорий расходов пользователей
     * @param UserID id пользователя
     */
    String getUserCategories(Long UserID);
}
