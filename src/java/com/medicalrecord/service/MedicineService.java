/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.service;

import com.medicalrecord.model.Medicine;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Retna P
 */
@Stateless
public class MedicineService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Medicine> findAll() {
        return this.entityManager.
                createQuery("from Medicine", Medicine.class).
                getResultList();
    }
    
    public Medicine get(Long id) {
        return this.entityManager.find(Medicine.class, id);
    }
    
    public void save(Medicine toSave) {
        this.entityManager.persist(toSave);
    }
    
    public Medicine merge(Medicine toMerge) {
        return this.entityManager.merge(toMerge);
    }
    
    public void delete(Medicine toDelete) {
        this.entityManager.remove(toDelete);
    }
}
