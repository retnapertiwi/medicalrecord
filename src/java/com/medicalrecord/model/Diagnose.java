package com.medicalrecord.model;

/**
 * @author retna p
 */
public class Diagnose {
   
    private String diagnose;
    private Patient patient;

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
