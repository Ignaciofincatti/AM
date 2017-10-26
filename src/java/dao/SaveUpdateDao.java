/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import pojos.Equipos;

/**
 *
 * @author ignacio
 */
public class SaveUpdateDao {
     Session session = HibernateUtil.getSessionFactory().openSession();
     
     
     public int saveUpdate(Object ob ){
        
        int x=0;
        try {
            
            session.beginTransaction();
            session.saveOrUpdate(ob);
            session.getTransaction().commit();
            x=1;
        } catch (RuntimeException e) {
            session.beginTransaction().rollback();
            session.close();
            throw e;
            
        }
        return x;
    }
}
