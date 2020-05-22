/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.project.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Princia Pascale
 */
@Entity
public class Hospital {
    
    @Id
    private String name;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name="loc_Id", nullable=false)
    private Location location;

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public Hospital(String name, String username, String password, Location location) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.location = location;
       
    }

    public Hospital() {
    }
    
    
}
