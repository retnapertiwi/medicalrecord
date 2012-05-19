/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.service;

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
                createQuery("from User", User.class).
                getResultList();
    }
    
    public User get(Long id) {
        return this.entityManager.find(User.class, id);
    }
    
    public void save(User toSave) {
        this.entityManager.persist(toSave);
    }
    
    public User merge(User toMerge) {
        return this.entityManager.merge(toMerge);
    }
    
    public void delete(User toDelete) {
        this.entityManager.remove(toDelete);
    }
}
