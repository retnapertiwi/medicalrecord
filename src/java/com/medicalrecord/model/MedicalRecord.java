package com.medicalrecord.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 * @author retna p
 */
@Entity
public class MedicalRecord implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name="medicalrecord_id")
    private int id;
    
    @Column (name="diagnose", nullable=false)
    private String diagnose;
    
    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name="doctor_id", nullable=false)
    private Doctor doctor;
    
    @OneToMany(mappedBy="medicalrecord", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<MedicineRecord> medicinerecords;
    
    @Column (name="date_medrec", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    @Transient
    private transient String readableMedicine = "";

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<MedicineRecord> getMedicinerecords() {
        return medicinerecords;
    }

    public void setMedicinerecords(List<MedicineRecord> medicinerecords) {
        this.medicinerecords = medicinerecords;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReadableMedicine() {
        for (MedicineRecord mr : this.medicinerecords) {
            this.readableMedicine = this.readableMedicine + mr.getMedicine().getName() + " ";
        }
        return readableMedicine;
    }

    public void addNewMedicine(Medicine m) {
        MedicineRecord mr = new MedicineRecord();
        mr.setMedicalrecord(this);
        mr.setMedicine(m);
        
        if (this.medicinerecords == null) {
            this.medicinerecords = new ArrayList<MedicineRecord>();
        }
        this.medicinerecords.add(mr);
    }
}
