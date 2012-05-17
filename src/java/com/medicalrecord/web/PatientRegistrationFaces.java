package com.medicalrecord.web;

import com.medicalrecord.model.Patient;
import com.medicalrecord.service.PatientService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author retna p
 */
@RequestScoped
@Named
public class PatientRegistrationFaces {
    
    @EJB
    private PatientService patientService;
    
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
    
    public void addPatient(){
        System.out.println(patient.getBirthDate()+patient.getName());
       patientService.save(patient);
    }
}
