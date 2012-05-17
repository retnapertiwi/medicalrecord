
package com.medicalrecord.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Retna P
 */
public class Patient implements Serializable {
    
    private String name;
    private String gender;
    private Date birthDate;
    private String address;
    private String phone;
    private List<Diagnose> diagnoses;
    
    public Patient() {
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

    public List<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }
    
    public Patient addDiagnose(Diagnose diagnose) {
        if (this.diagnoses == null)
            this.diagnoses = new ArrayList<Diagnose>();
        
        diagnose.setPatient(this);
        this.diagnoses.add(diagnose);
        
        return this;
    }
}
