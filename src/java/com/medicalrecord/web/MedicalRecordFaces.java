/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.MedicalRecord;
import com.medicalrecord.service.MedicalRecordService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Retna P
 */
@Named(value = "medicalRecordFaces")
@RequestScoped
public class MedicalRecordFaces {

    @EJB
    private MedicalRecordService medicalRecordService;
    
    private MedicalRecord medicalRecord;
    
    @PostConstruct
    public void postConstruct() {
        if (this.medicalRecord == null) this.medicalRecord = new MedicalRecord();
    }
    
    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
    
    public void addMedicalRecord(){
        System.out.println(medicalRecord.getPatient()+medicalRecord.getDiagnose()+medicalRecord.getDoctor());
        medicalRecordService.save(medicalRecord);
    }
}
