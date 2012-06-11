package com.medicalrecord.web;

import com.medicalrecord.model.Patient;
import com.medicalrecord.service.PatientService;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author retna p
 */
@ViewScoped
@ManagedBean
public class PatientEditFaces {
    
    private Integer patientId;
    
    @EJB
    private PatientService patientService;
    
    private Patient patient;
    
    @PostConstruct
    public void postConstruct() {
        if (this.patient == null) this.patient = new Patient();
        
        Map<String, String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  this.patientId = Integer.valueOf(params.get("id"));
          System.out.println("Patient id is: " + this.patientId);
          
          this.patient = this.patientService.get(patientId);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public void updatePatient() {
        System.out.println("merge patient: " + patient.getName());
        patientService.merge(patient);
    }
    
    public void addPatient(){
        System.out.println(patient.getBirthDate()+patient.getName());
       patientService.save(patient);
    }
    
    public List<Patient> getFindAll(){
        return patientService.findAll();
    }
    
    public void editPatient(Patient patient) {
        this.patient = patient;
    }
}
