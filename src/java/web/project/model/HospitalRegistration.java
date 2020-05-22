/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.project.model;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import web.project.domain.Hospital;
import web.project.domain.Location;
import web.project.persistance.DaoClass;
import web.project.persistance.LocationDao;

/**
 *
 * @author Princia Pascale
 */
@ManagedBean(name = "hospreg" )
public class HospitalRegistration {
    
    private Hospital hosp = new Hospital();
    private DaoClass dao = new DaoClass();
    private String action = "register";
    private int locId;
    private List<Location> locations=new ArrayList<>();
    
    public String registerHospital(){
        try {
           Location loc=new Location();
           loc.setLocId(locId);
           hosp.setLocation(loc);
            dao.create(hosp);
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

    public List<Location> getLocations() {
        return new LocationDao().getAllLoc();
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }
    

 
   
    
}
