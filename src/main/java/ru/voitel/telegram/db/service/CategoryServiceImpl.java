package ru.voitel.telegram.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.voitel.telegram.db.dao.CategoryDao;
import ru.voitel.telegram.db.model.Category;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * Получение категории пользователя по его id
     *
     * @param userID id пользователя
     * @return список категорий пользователей
     */
    @Override
    public List<Category> getUserCategories(Long userID) {
        return categoryDao.getUserCategories(userID);
    }
}
