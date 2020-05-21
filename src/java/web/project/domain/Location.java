/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.project.domain;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Princia Pascale
 */
@Entity
@ManagedBean(name = "loc")
public class Location {
    
    @Id
    private String province;
    private String district;
    private String sector;

    
    @OneToMany(mappedBy="location")
    private List<Hospital> hospital = new ArrayList<>();

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

    public List<Hospital> getHospital() {
        return hospital;
    }

    public void setHospital(List<Hospital> hospital) {
        this.hospital = hospital;
    }

   

    
    
    public Location(String province, String district, String sector) {
        this.province = province;
        this.district = district;
        this.sector = sector;
    }

    public Location() {
    }
    
    
}
