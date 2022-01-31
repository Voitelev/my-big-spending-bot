package ru.voitel.telegram.db.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.voitel.telegram.db.HibernateSessionFactoryUtil;
import ru.voitel.telegram.db.model.Category;

import java.util.List;

@Repository
public class CategoryDaoIml implements CategoryDao {

    @Override
    public List<Category> getUserCategories(Integer userID) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Category>) session.createQuery("from Category where idUser = :idUser")
                .setParameter("idUser", userID).list();
    }
}
