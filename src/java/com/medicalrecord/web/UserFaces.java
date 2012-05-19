/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.User;
import com.medicalrecord.service.UserService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Retna P
 */
@Named(value = "userFaces")
@RequestScoped
public class UserFaces {
    @EJB
    private UserService userService;
    
    private User user;
    
    @PostConstruct
    public void postConstruct() {
        if (this.user == null) this.user = new User();
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void addUser(){
        System.out.println(user.getUsername());
        userService.save(user);
    }
}
