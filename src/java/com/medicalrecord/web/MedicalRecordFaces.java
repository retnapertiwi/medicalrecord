/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.Doctor;
import com.medicalrecord.model.MedicalRecord;
import com.medicalrecord.model.Medicine;
import com.medicalrecord.model.Patient;
import com.medicalrecord.service.DoctorService;
import com.medicalrecord.service.MedicalRecordService;
import com.medicalrecord.service.MedicineService;
import com.medicalrecord.service.PatientService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Retna P
 */
@ManagedBean
@RequestScoped
public class MedicalRecordFaces {

    @EJB
    private MedicalRecordService medicalRecordService;
    
    @EJB
    private PatientService patientService;
    
    @EJB
    private DoctorService doctorService;
    
    @EJB
    private MedicineService medicineService;
    
    private MedicalRecord medicalRecord;
    private Patient patient;
    private List<Patient> patients;
    private Doctor doctor;
    private List<Doctor> doctors;
    private List<Medicine> medicines;
    private List<String> medicineIds;
    private List<MedicalRecord> medicalRecords;
    
    @PostConstruct
    public void postConstruct() {
        if (this.medicalRecord == null) this.medicalRecord = new MedicalRecord();
        if (this.patient == null) this.patient = new Patient();
        if (this.doctor == null) this.doctor = new Doctor();
        if (this.medicineIds == null) this.medicineIds = new ArrayList<String>();
        if (this.medicalRecords == null) this.medicalRecords = new ArrayList<MedicalRecord>();
    }
    
    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public MedicineService getMedicineService() {
        return medicineService;
    }

    public void setMedicineService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }
    
    public void addMedicalRecord(){
        System.out.println(">>> " + this.doctor.getId() + " - " + this.patient.getId() + " - " + this.medicineIds);
        this.medicalRecord.setDate(new Date());
        this.medicalRecordService.save(
                this.medicalRecord, 
                this.doctor.getId(),
                this.patient.getId(),
                this.medicineIds);
    }

    public List<String> getMedicineIds() {
        return medicineIds;
    }

    public void setMedicineIds(List<String> medicineIds) {
        this.medicineIds = medicineIds;
    }
    
      public List<Patient> getPatients() {
        this.patients = patientService.findAll();
        return this.patients;
    }
    
     public List<Doctor> getDoctors(){ 
        this.doctors = doctorService.findAll();
        return this.doctors;
    }

    public List<Medicine> getMedicines() {
        this.medicines = medicineService.findAll();
        return this.medicines;
    }
    
    public List<MedicalRecord> getMedicalRecords() {
        this.medicalRecords = this.medicalRecordService.findAll();
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
