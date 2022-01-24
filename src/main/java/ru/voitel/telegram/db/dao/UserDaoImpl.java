package ru.voitel.telegram.db.dao;

import com.sun.xml.bind.v2.TODO;
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

    /**
     * Создание пользователя в БД
     * @param user данные пользователя
     */
    @Override
    public void create(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit(); ;
        session.close();
    }

    @Override
    public void update(User user) {

    }

    //TODO метод уродский переписать.
    @Override
    public User getUser(Integer idUser) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User where iduser = :idUser", User.class);
        query.setParameter("idUser", idUser);
        User user = null;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            e.getStackTrace();
        }
        session.close();
        return user;
    }
}
