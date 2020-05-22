/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.project.persistance;

import java.util.List;
import web.project.domain.Location;
import web.project.domain.NewHibernateUtil;

/**
 *
 * @author armel
 */
public class LocationDao extends DaoClass<Location> {
       
    public List<Location> getAllLoc(){
      return NewHibernateUtil.getSession().createQuery("from Location").list();
    }
    
}
