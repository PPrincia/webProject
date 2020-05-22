/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.project.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Princia Pascale
 */
@Entity
public class Location {
    
    @Id
    private int locId;
    private String province;
    private String district;
    private String sector;

    
    @OneToMany(mappedBy="location")
    private List<Hospital> hospitals;

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
    

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

  
   

    
    
    public Location(String province, String district, String sector) {
        this.province = province;
        this.district = district;
        this.sector = sector;
    }

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" + "locId=" + locId + '}';
    }

   
  
    
    
    
}
