/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.project.model;


import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import web.project.domain.Hospital;
import web.project.domain.Location;
import web.project.persistance.DaoClass;

/**
 *
 * @author Princia Pascale
 */
@ManagedBean(name = "hospreg" )
public class HospitalRegistration {
    
    private Hospital hosp = new Hospital();
    private Location loc = new Location();
    private DaoClass dao = new DaoClass();
    private String action = "register";

    
    public String registerHospital(){
        try {
            dao.create(hosp);
            dao.create(loc);
            FacesMessage msg = new FacesMessage("Thank you for registering " +hosp.getName() + "located at " +hosp.getLocation().getProvince());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "loginForm";
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage msg = new FacesMessage("failed to register " +hosp.getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);           
            return "hospRegistrationForm";
        }
       
        
    }
    
    public String deleteHospital(Hospital hosp){
        this.hosp = hosp;
        this.action = "delete";
        return "hospListForm";
    }
    
    public String updateHospital(Hospital hosp){
        this.hosp = hosp;
        this.action = "update";
        return "hospListForm";
    }
    
    
    public Hospital getHosp() {
        return hosp;
    }

   

    public DaoClass getDao() {
        return dao;
    }

    public void setDao(DaoClass dao) {
        this.dao = dao;
    }

    public String getAction() {
        return action;
    }

    public Location getLoc() {
        return loc;
    }

   
    
}
