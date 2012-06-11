/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.service;

import com.medicalrecord.model.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Retna P
 */
@Stateless
public class RoleService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Role> findAll() {
        return this.entityManager.
                createQuery("select r from Role r", Role.class).
                getResultList();
    }
    
    public Role get(int id) {
        return this.entityManager.find(Role.class, id);
    }
    
    public void save(Role toSave) {
        this.entityManager.persist(toSave);
    }
    
    public Role merge(Role toMerge) {
        return this.entityManager.merge(toMerge);
    }
    
    public void delete(Role toDelete) {
        this.entityManager.remove(this.entityManager.merge(toDelete));
    }
}
