package com.example.aprilproject.Objects;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    double valueOfDeposit;
    LocalDate dateOfDeposit;
    private int createdByUserID;
    String methodDeposit;

    public Deposit() {
    }

    public Deposit(double valueOfDeposit, LocalDate dateOfDeposit, int createdByUserID, String methodDeposit) {
        this.valueOfDeposit = valueOfDeposit;
        this.dateOfDeposit = dateOfDeposit;
        this.createdByUserID = createdByUserID;
        this.methodDeposit = methodDeposit;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", valueOfDeposit=" + valueOfDeposit +
                ", dateOfDeposit=" + dateOfDeposit +
                ", createdByUserID=" + createdByUserID +
                ", methodDeposit='" + methodDeposit + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public double getValueOfDeposit() {
        return valueOfDeposit;
    }

    public void setValueOfDeposit(double valueOfDeposit) {
        this.valueOfDeposit = valueOfDeposit;
    }

    public LocalDate getDateOfDeposit() {
        return dateOfDeposit;
    }

    public void setDateOfDeposit(LocalDate dateOdDeposit) {
        this.dateOfDeposit = dateOdDeposit;
    }

    public int getCreatedByUserID() {
        return createdByUserID;
    }

    public void setCreatedByUserID(int createdByUserID) {
        this.createdByUserID = createdByUserID;
    }

    public String getMethodDeposit() {
        return methodDeposit;
    }

    public void setMethodDeposit(String methodDeposit) {
        this.methodDeposit = methodDeposit;
    }
}
