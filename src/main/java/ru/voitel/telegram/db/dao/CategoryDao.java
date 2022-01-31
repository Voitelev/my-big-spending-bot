package ru.voitel.telegram.db.dao;

import ru.voitel.telegram.db.model.Category;
import java.util.List;


/**
 *  DAO для категорий клиента
 */
public interface CategoryDao {

    /**
     * Получение списка категорий
     * @param userID id пользователя
     * @return список категорий
     */
    public List<Category> getUserCategories (Integer userID);
}
