/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.Doctor;
import com.medicalrecord.service.DoctorService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Retna P
 */
@RequestScoped
@Named
public class DoctorFaces {
    @EJB
    private DoctorService doctorService;
    
    private Doctor doctor;

    @PostConstruct
    public void postConstruct() {
        if (this.doctor == null) this.doctor = new Doctor();
    }
    
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public void addDoctor(){
        System.out.println(doctor.getName());
        doctorService.save(doctor);
    }
}
