/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.Role;
import com.medicalrecord.model.User;
import com.medicalrecord.service.RoleService;
import com.medicalrecord.service.UserService;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Retna P
 */
@ViewScoped
@ManagedBean
public class UserEditFaces implements Serializable{
    
    private Integer userId;
    
    @EJB
    private UserService userService;
    
    @EJB
    private RoleService roleService;
    
    private User user;
    private Role role;
    private List<Role> roles;
    
    @PostConstruct
    public void postConstruct() {
        if (this.user == null) this.user = new User();
        if (this.role == null) this.role = new Role();
        
        Map<String, String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            this.userId = Integer.valueOf(params.get("id"));
            System.out.println("User id is: " + this.userId);

            this.user = this.userService.get(userId);
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public void updateUser(){
        System.out.println("merge user: " + user.getUsername());
        userService.merge(user);
    }
    
    public List<Role> getRoles(){ 
        this.roles = roleService.findAll();
        return this.roles;
    }
    
    public List<User> getFindAll(){
        return userService.findAll();
    }
    
    public void editUser(User user) {
        this.user = user;
    }
}
