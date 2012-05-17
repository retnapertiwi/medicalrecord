/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.model;

import java.io.Serializable;
import java.util.List;
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
public class Medicine implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="medicine_id")
    private int id;
    
    @Column (name="name", nullable=false)
    private String name;
    
    @Column (name="description")
    private String description;
    
    @OneToMany(mappedBy="medicine")
    private List<MedicineRecord> medicineRecords;
   
    public Medicine() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MedicineRecord> getMedicineRecords() {
        return medicineRecords;
    }

    public void setMedicineRecords(List<MedicineRecord> medicineRecords) {
        this.medicineRecords = medicineRecords;
    }

 
    
}
