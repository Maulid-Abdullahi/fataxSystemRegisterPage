package register;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class RegisterDao {
    public void saveRegisterBean(RegisterBean registerbean) {
        Transaction transaction = null;
        try (Session session = DBConnection.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(registerbean);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

