package ru.voitel.telegram.db.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.voitel.telegram.db.HibernateSessionFactoryUtil;
import ru.voitel.telegram.db.model.Category;

import java.util.List;

@Repository
public class CategoryDaoIml implements CategoryDao {

    @Override
    public List<Category> getUserCategories(Integer userID) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Category> query = session.createQuery("from Category where iduser = :idUser", Category.class)
                .setParameter("idUser", userID);
        return query.list();
    }
}
