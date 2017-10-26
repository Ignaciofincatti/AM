/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Jugadores;

/**
 *
 * @author ignacio
 */
public class jugadorDao {
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<Jugadores> vreExiste(Jugadores j){
         List<Jugadores> ListJug;
        try {
            String Hql = "From Jugadores WHERE jugadorDni="+ j.getJugadorDni() +"";
            Query q = session.createQuery(Hql);
            ListJug=q.list();
        } catch (Exception e) {
            throw e;
        }finally{
            
        }
        return ListJug;
    }
    
    
    
    
    
}
