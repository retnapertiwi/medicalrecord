/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.service;

import com.medicalrecord.model.Role;
import com.medicalrecord.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Retna P
 */
@Stateless
public class UserService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<User> findAll() {
        return this.entityManager.
                createQuery("select u from User u", User.class).
                getResultList();
    }
    
    public User get(int id) {
        return this.entityManager.find(User.class, id);
    }
    
    public void save(User toSave, int roleId) {
        Role role = this.entityManager.getReference(Role.class, roleId);
        toSave.setRole(role);
        this.entityManager.persist(toSave);
    }
    
    public User merge(User toMerge) {
        return this.entityManager.merge(toMerge);
    }
    
    public void delete(User toDelete) {
        this.entityManager.remove(this.entityManager.merge(toDelete));
    }
}
