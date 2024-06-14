package com.alessor.app.ws.io.entities;

import com.alessor.app.ws.ui.models.Lease;
import com.alessor.app.ws.ui.models.TenancyTypes;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name="Tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Uid")
    private UserEntity user;

    @Column(name="JobTitle")
    private String jobTitle;

    @Column(name="JobDescription")
    private String jobDescription;

    @Column(nullable=false, name="TenantType")
    private TenancyTypes tenantType;

    @Column(name="Employeer")
    private String employeer;

    @Column(name="EmploymentLength")
    private Float employmentLength;

    @Column(nullable=false, name="HasMissingPayments")
    private Boolean hasMissedPayments;

    @Column(nullable=false, name="IsMovedIn")
    private Boolean isMovedIn;

    @Column(nullable=false, name="LeaseSigned")
    private Boolean leaseSigned;

    @Column(nullable=false, name="NumberOfPeopleOnOccupancy")
    private int numberOfPeopleOnOccupancy;

    @Column(nullable=false, name="TenancyLengthMonths")
    private Float tenancyLengthMonths;

//    @Column(nullable=false, name="LeaseAgreement")
//    private Lease leaseAgreement;
    // TODO figure out how jpa handles foreign keys do i have to do this leaseAgreement obj and joinTable or just leaseId
    @Column(name="LeaseId")
    private int LeaseId;

    @Column(name="LeaseAgreement")
    @OneToOne
    @JoinTable(name="tenantLeases", joinColumns=@JoinColumn(name="userId", referencedColumnName="id"),
         inverseJoinColumns=@JoinColumn(name="leaseId", referencedColumnName="id"))
    private Lease leaseAgreement;

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

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return this.jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public TenancyTypes getTenantType() {
        return this.tenantType;
    }

    public void setTenantType(TenancyTypes tenantType) {
        this.tenantType = tenantType;
    }

    public String getEmployeer() {
        return this.employeer;
    }

    public void setEmployeer(String employeer) {
        this.employeer = employeer;
    }

    public Float getEmploymentLength() {
        return this.employmentLength;
    }

    public void setEmploymentLength(Float employmentLength) {
        this.employmentLength = employmentLength;
    }

    public Boolean getHasMissedPayments() {
        return this.hasMissedPayments;
    }

    public void setHasMissedPayments(Boolean hasMissedPayments) {
        this.hasMissedPayments = hasMissedPayments;
    }

    public Boolean getIsMovedIn() {
        return this.isMovedIn;
    }

    public void setIsMovedIn(Boolean isMovedIn) {
        this.isMovedIn = isMovedIn;
    }

    public Boolean getLeaseSigned() {
        return this.leaseSigned;
    }

    public void setLeaseSigned(Boolean leaseSigned) {
        this.leaseSigned = leaseSigned;
    }

    public int getNumberOfPeopleOnOccupancy() {
        return this.numberOfPeopleOnOccupancy;
    }

    public void setNumberOfPeopleOnOccupancy(int numberOfPeopleOnOccupancy) {
        this.numberOfPeopleOnOccupancy = numberOfPeopleOnOccupancy;
    }

    public Float getTenancyLengthMonths() {
        return this.tenancyLengthMonths;
    }

    public void setTenancyLengthMonths(Float tenancyLength) {
        this.tenancyLengthMonths = tenancyLength;
    }

    public Lease getLeaseAgreement() {
        return this.leaseAgreement;
    }

    public void setLeaseAgreement(Lease leaseAgreement) {
        this.leaseAgreement = leaseAgreement;
    }

    public int getLeaseId() {
        return this.LeaseId;
    }

    public void setLeaseId(int leaseId) {
        this.LeaseId = leaseId;
    }
}
