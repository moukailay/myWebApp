/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author trainer
 */
public class Principale {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        System.out.println("Etat session " + session.isOpen());
        Transaction tx = null;
        try {
            Client monClient = new Client();
            monClient.setNom("razor");
            tx = session.beginTransaction();
            session.save(monClient);
            tx.commit();
        }
        catch(Exception ex) {
            tx.rollback();
            throw ex;
        }
        finally {
            session.close();
        }
         System.out.println("Etat session " + session.isOpen());
    }
}
