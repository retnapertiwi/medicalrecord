/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.service;

import com.medicalrecord.model.Doctor;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Retna P
 */
@Stateless
public class DoctorService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Doctor> findAll() {
        return this.entityManager.
                createQuery("from Doctor", Doctor.class).
                getResultList();
    }
    
    public Doctor get(Long id) {
        return this.entityManager.find(Doctor.class, id);
    }
    
    public void save(Doctor toSave) {
        this.entityManager.persist(toSave);
    }
    
    public Doctor merge(Doctor toMerge) {
        return this.entityManager.merge(toMerge);
    }
    
    public void delete(Doctor toDelete) {
        this.entityManager.remove(toDelete);
    }
}
