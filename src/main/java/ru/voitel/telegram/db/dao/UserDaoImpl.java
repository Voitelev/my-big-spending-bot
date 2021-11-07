package ru.voitel.telegram.db.dao;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import ru.voitel.telegram.db.HibernateSessionFactoryUtil;
import ru.voitel.telegram.db.model.User;

import javax.persistence.NoResultException;

@Component
public class UserDaoImpl implements UserDao {

    @Override
    public void create(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getUser(Long chatId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User where chatId = :chatId", User.class);
        query.setParameter("chatId", chatId);
        User user = null;

        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            e.getStackTrace();
        }

        return user;
    }
}
