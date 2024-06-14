package com.alessor.app.ws.io.entities;

import com.alessor.app.ws.ui.models.EmployeeType;
import com.alessor.app.ws.ui.models.PaySchedule;
import jakarta.persistence.*;

public class Worker {

    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;

    @OneToOne
    @JoinColumn(name="Uid")
    private UserEntity user;

    @Column(name="EmployeeType")
    private EmployeeType employeeType;

    @Column(name="PaySchedule")
    private PaySchedule paySchedule;

    @Column(name="PayRate")
    private Double payRate;

    @Column(name="TenureYears")
    private Double tenureYears;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getEmployeeType() {
        return String.valueOf(this.employeeType);
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = EmployeeType.valueOf(employeeType);
    }

    public String getPaySchedule() {
        return String.valueOf(this.paySchedule);
    }

    public void setPaySchedule(PaySchedule paySchedule) {
        this.paySchedule = paySchedule;
    }

    public void setPaySchedule(String paySchedule) {
        this.paySchedule = PaySchedule.valueOf(paySchedule);
    }

    public Double getPayRate() {
        return this.payRate;
    }

    public void setPayRate(Double payRate) {
        this.payRate = payRate;
    }

    public Double getTenureYears() {
        return this.tenureYears;
    }

    public void setTenureYears(Double tenureYears) {
        this.tenureYears = tenureYears;
    }
}
