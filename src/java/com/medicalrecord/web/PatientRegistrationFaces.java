package com.medicalrecord.web;

import com.medicalrecord.model.Patient;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * @author retna p
 */
@RequestScoped
@Named
public class PatientRegistrationFaces {
    
    private Patient patient;
    
    @PostConstruct
    public void postConstruct() {
        if (this.patient == null) this.patient = new Patient();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
}
