/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.Doctor;
import com.medicalrecord.service.DoctorService;
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
public class DoctorEditFaces {
    
    private Integer doctorId;
    
    @EJB
    private DoctorService doctorService;
    
    private Doctor doctor;

    @PostConstruct
    public void postConstruct() {
        if (this.doctor == null) this.doctor = new Doctor();
        
        Map<String, String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  this.doctorId = Integer.valueOf(params.get("id"));
          System.out.println("Doctor id is: " + this.doctorId);
          
          this.doctor = this.doctorService.get(doctorId);
    }
    
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public void updateRole() {
        System.out.println("merge doctor: " + doctor.getName());
        doctorService.merge(doctor);
    }
    
    public void addDoctor(){
        System.out.println(doctor.getName());
        doctorService.save(doctor);
    }
    
    public List<Doctor> getFindAll(){
        return doctorService.findAll();
    }
    
    public void editDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
