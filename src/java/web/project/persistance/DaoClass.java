/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.project.persistance;

import web.project.domain.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;
import web.project.domain.Hospital;
import web.project.domain.Location;

/**
 *
 * @author Princia Pascale
 * @param <X>
 */
public class DaoClass <X>{
    
    public void create(X x){
        Session ss  = NewHibernateUtil.getSession();
        ss.beginTransaction();
        ss.save(x);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void update(X x){
        Session ss  = NewHibernateUtil.getSession();
        ss.beginTransaction();
        ss.update(x);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void delete(X x){
        Session ss  = NewHibernateUtil.getSession();
        ss.beginTransaction();
        ss.delete(x);
        ss.getTransaction().commit();
        ss.close();
    }
    
  
    public X find(Class<X> type, String id){
        Session s= NewHibernateUtil.getSessionFactory().openSession();
        X obj = (X) s.get(type, id);
        return obj;
    }
    
  
    /*public Hospital findByHospitalId(String hpId) {
        Session ss = NewHibernateUtil.getSession();
        Hospital hp = (Hospital) ss.get(Hospital.class, hpId);
        ss.close();
        return hp;
    */
    
    public List<X> getAll(Class<X> type){
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        return s.createCriteria(type).list();
    }
  
     /*public List<Hospital> findAll() {
        Session ss = NewHibernateUtil.getSession();
        List<Hospital> hpList = ss.createQuery("from Hospital a").list();
        ss.close();
        return hpList;
    }*/
}
