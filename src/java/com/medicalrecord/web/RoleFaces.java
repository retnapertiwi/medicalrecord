/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.Role;
import com.medicalrecord.service.RoleService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Retna P
 */
@RequestScoped
@Named
public class RoleFaces {
    @EJB
    private RoleService roleService;
    
    private Role role;
    
    @PostConstruct
    public void postConstruct() {
        if (this.role == null) this.role = new Role();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public void addRole(){
        System.out.println(role.getName());
        roleService.save(role);
        role = new Role();
    }
    
    public void deleteRole(Role role){
        this.roleService.delete(role);
    }
    
    public List<Role> getFindAll(){
        return roleService.findAll();
    }
    
    public void editRole(Role role) {
        this.role = role;
    }
}
