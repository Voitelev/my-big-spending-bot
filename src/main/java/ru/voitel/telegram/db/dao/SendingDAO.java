package ru.voitel.telegram.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import ru.voitel.telegram.db.HibernateSessionFactoryUtil;
import ru.voitel.telegram.db.model.Sending;

@Component
public class SendingDAO {

    public void save(Sending sending) {
        System.out.println("!!!!!! " );
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sending);
        transaction.commit();
        session.close();
    }

}
