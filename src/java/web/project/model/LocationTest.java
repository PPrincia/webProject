/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.project.model;

import web.project.domain.Hospital;
import web.project.domain.Location;
import web.project.persistance.DaoClass;
import web.project.persistance.NewHibernateUtil;

/**
 *
 * @author Princia Pascale
 */
public class LocationTest {
    
    public static void main(String[] args) {
        
        Location loc = new Location();
        DaoClass dao = new DaoClass();
        Hospital hos = new Hospital();
        loc.setProvince("Kigali");
        loc.setDistrict("Gasabo");
        loc.setSector("remera");
       
        dao.create(loc);
    }
}
