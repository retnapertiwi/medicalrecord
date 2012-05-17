/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Retna P
 */
@Entity
public class MedicineRecord implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="medicinerecord_id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name="medicalrecord_id", nullable=false)
    private MedicalRecord medicalrecord;
    
    @ManyToOne
    @JoinColumn(name="medicine_id", nullable=false)
    private Medicine medicine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicalRecord getMedicalrecord() {
        return medicalrecord;
    }

    public void setMedicalrecord(MedicalRecord medicalrecord) {
        this.medicalrecord = medicalrecord;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    
    
    
}
