/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.service;

import com.medicalrecord.model.Doctor;
import com.medicalrecord.model.MedicalRecord;
import com.medicalrecord.model.Medicine;
import com.medicalrecord.model.Patient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Retna P
 */
@Stateless
public class MedicalRecordService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<MedicalRecord> findAll() {
        return this.entityManager.
                createQuery("select mr from MedicalRecord mr", MedicalRecord.class).
                getResultList();
    }
    
    public MedicalRecord get(Long id) {
        return this.entityManager.find(MedicalRecord.class, id);
    }
    
    public void save(MedicalRecord toSave, Integer doctorId, Integer patientId, List<String> medicineIds) {
        Doctor doctor = this.entityManager.getReference(Doctor.class, doctorId);
        Patient patient = this.entityManager.getReference(Patient.class, patientId);
        toSave.setDoctor(doctor);
        toSave.setPatient(patient);
        
        try {
        for (String medicineId : medicineIds) {
            Integer id = Integer.valueOf(medicineId);
            Medicine medicine = this.entityManager.getReference(Medicine.class, id);
            toSave.addNewMedicine(medicine);
        } 
        } catch (ClassCastException e) {
            System.err.println(">>> Classcast ex: " + e);
        }
        
        this.entityManager.persist(toSave);
    }
    
    public MedicalRecord merge(MedicalRecord toMerge) {
        return this.entityManager.merge(toMerge);
    }
    
    public void delete(MedicalRecord toDelete) {
        this.entityManager.remove(toDelete);
    }
    

}
