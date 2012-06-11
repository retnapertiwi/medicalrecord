package com.medicalrecord.service;

import com.medicalrecord.model.Patient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Retna P
 */
@Stateless
public class PatientService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Patient> findAll() {
        return this.entityManager.
                createQuery("select p from Patient p", Patient.class).
                getResultList();
    }
    
    public Patient get(int id) {
        return this.entityManager.find(Patient.class, id);
    }
    
    public void save(Patient toSave) {
        this.entityManager.persist(toSave);
    }
    
    public Patient merge(Patient toMerge) {
        return this.entityManager.merge(toMerge);
    }
}
