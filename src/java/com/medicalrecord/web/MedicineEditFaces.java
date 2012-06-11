/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.Medicine;
import com.medicalrecord.service.MedicineService;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Retna P
 */
@ViewScoped
@ManagedBean
public class MedicineEditFaces {
    
    private Integer medicineId;
    
    @EJB
    private MedicineService medicineService;
    
    private Medicine medicine;
       
    @PostConstruct
    public void postConstruct() {
        if (this.medicine == null) this.medicine = new Medicine();
        
        Map<String, String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  this.medicineId = Integer.valueOf(params.get("id"));
          System.out.println("Medicine id is: " + this.medicineId);
          
          this.medicine = this.medicineService.get(medicineId);
    }
    
    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    
    public void updateMedicine() {
        System.out.println("merge medicine: " + medicine.getName());
        medicineService.merge(medicine);
    }
    
    public void addMedicine(){
        System.out.println(medicine.getName());
        medicineService.save(medicine);
    }
    
    public List<Medicine> getFindAll(){
        return medicineService.findAll();
    }
    
    public void editMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
