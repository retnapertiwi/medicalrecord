package com.medicalrecord.web;

import com.medicalrecord.model.User;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 * Please note that glassfish (at least on this version) is very ugly. They not 
 * support @{@link Named} annotation if used in backing bean. So if you annotated
 * this class without give this {@link ManagedBean} annotation, the 
 * {@link LoginFaces#user} properties will return null no matter the bean scope 
 * defined.
 * 
 * @author retna p
 */
@ManagedBean
public class LoginFaces {
    
    private User user;
    
    @PostConstruct
    public void postConstruct() {
        if (user == null) user = new User();
    }
    
    public void onClickedButtonLogin() {
        System.out.println("Logged in with username: "
                + user.getUsername() + " and password: " 
                + user.getPassword());
        
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
