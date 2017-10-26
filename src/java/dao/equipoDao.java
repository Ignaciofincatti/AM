/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Categorias;
import pojos.Equipos;




/**
 *
 * @author ignacio
 */
public class equipoDao {
    
    
    
    public List<Equipos> verExiste(Equipos eq){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Equipos> list=null;
         try {
            String Hql = "From Equipos WHERE equipoNombre LIKE '"+eq.getEquipoNombre()+"%'";
            session.beginTransaction().setTimeout(1);
            Query q = session.createQuery(Hql);
            list=q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }finally{
           
        }
        return list;
    }
    
    public List<Categorias> categorias(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Categorias> list=null;
         try {
            String Hql = "From Categorias";
            Query q = session.createQuery(Hql);
            list=q.list();
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    

}
