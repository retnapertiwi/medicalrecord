
package com.medicalrecord.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * @author Retna P
 */
@Entity
public class Patient implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="patient_id")
    private int id;
    
    @Column (name="name", nullable=false)
    private String name;
    
    @Column (name="gender", nullable=false)
    private String gender;
    
    @Column (name="birthDate", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    
    @Column (name="address")
    private String address;
    
    @Column (name="phone")
    private String phone;
    
    @OneToMany(mappedBy="patient")
    private List<MedicalRecord> medicalRecords;
    
    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

}
