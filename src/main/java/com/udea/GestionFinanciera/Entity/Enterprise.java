package com.udea.GestionFinanciera.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udea.GestionFinanciera.Dto.EnterpriseDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String document;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employees;

    @OneToMany(mappedBy = "enterprise")
    private List<Transaction> transactions;

    public Enterprise() {
    }

    public Enterprise(Long id, String name, String document, String phone, String address, Date createdAt, Date updatedAt, List<Employee> employees, List<Transaction> transactions) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.employees = employees;
        this.transactions = transactions;
    }

    public EnterpriseDto toDto(){
        EnterpriseDto enterprise = new EnterpriseDto();
        enterprise.setId(this.id);
        enterprise.setName(this.name);
        enterprise.setDocument(this.document);
        enterprise.setPhone(this.phone);
        enterprise.setAddress(this.address);
        return enterprise;
    }

    public EnterpriseDto toDtoAll(){
        EnterpriseDto enterprise = new EnterpriseDto();
        enterprise.setId(this.id);
        enterprise.setName(this.name);
        return enterprise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", employees=" + employees +
                ", transactions=" + transactions +
                '}';
    }
}