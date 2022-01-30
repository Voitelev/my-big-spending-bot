package ru.voitel.telegram.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.voitel.telegram.db.model.Category;
import ru.voitel.telegram.db.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryHandlerImpl implements CategoryHandler{

    private final CategoryService categoryService;

    @Autowired
    public CategoryHandlerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Создание категории
     */
    @Override
    public void createCategory() {

    }

    /**
     * Получение категорий  по id пользователя
     * @param userID id пользователя
     * @return все категории пользователя в одной строке
     */
    @Override
    public String getUserCategories(Long userID) {
        return parsingCategoryForOutputUser(categoryService.getUserCategories(userID));
    }

    /**
     * Парсинг категорий пользователя в список
     * @return список категорий
     */
    private String parsingCategoryForOutputUser(List<Category> categories) {
       return categories.stream().map(Category::getNameCategory).collect(Collectors.joining(" "));
    }
}
