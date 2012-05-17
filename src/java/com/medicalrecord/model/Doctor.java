/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.model;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Retna P
 */
@Entity
public class Doctor implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="doctor_id")
    private int id;
    
    @Column (name="name")
    private String name;
    
    @Column (name="address")
    private String address;
    
    @Column (name="phone")
    private String phone;
    
    @OneToMany(mappedBy="doctor")
    private List<MedicalRecord> medicalRecords;

    public Doctor() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
