/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.service;

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
public class PatientService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Patient> findAll() {
        return this.entityManager.
                createQuery("from Patient", Patient.class).
                getResultList();
    }
}
