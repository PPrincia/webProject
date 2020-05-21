/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.project.model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import web.project.domain.Hospital;
import web.project.persistance.DaoClass;

/**
 *
 * @author Princia Pascale
 */
public class login {
    
    private String username;
    private String password;

    public String signin(){
 
        try {
            Hospital hosp = (Hospital) new DaoClass().find(Hospital.class, username);
            if(hosp != null && hosp.getPassword().equals(password))
            {
                HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
                       .getExternalContext().getSession(true);
                session.setAttribute("authenticatedUser", hosp);
                return "Warm welcome";
            }else{
                FacesMessage msg = new FacesMessage("Invalid username or password");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "loginForm";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage msg = new FacesMessage("Invalid username or password");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "loginForm";
        }
        
    }
    
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
