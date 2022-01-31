package ru.voitel.telegram.db.service;

import ru.voitel.telegram.db.model.Category;

import java.util.List;

/**
 * Сервис по работе с категориями пользователей
 */
public interface CategoryService {


    /**
     * Получение категории пользователя по его id
     * @param userID id пользователя
     * @return список категорий пользователей
     */
    List<Category> getUserCategories (Integer userID);
}
