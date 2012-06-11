/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.Role;
import com.medicalrecord.service.RoleService;
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
public class RoleEditFaces {
    
    private Integer roleId;
    
    @EJB
    private RoleService roleService;
    
    private Role role;
    
    @PostConstruct
    public void postConstruct() {
        if (this.role == null) this.role = new Role();
        
        Map<String, String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  this.roleId = Integer.valueOf(params.get("id"));
          System.out.println("Role id is: " + this.roleId);
          
          this.role = this.roleService.get(roleId);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public void updateRole() {
        System.out.println("merge role: " + role.getName());
        roleService.merge(role);
    }
    
    public List<Role> getFindAll(){
        return roleService.findAll();
    }
    
    public void editRole(Role role) {
        this.role = role;
    }
}
