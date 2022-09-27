package com.udea.GestionFinanciera.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udea.GestionFinanciera.Dto.TransactionDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String concept;

    @Column
    private float amount;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Enterprise enterprise;

    public Transaction() {
    }

    public Transaction(Long id, String concept, float amount, Date createdAt, Date updatedAt, Employee employee, Enterprise enterprise) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.employee = employee;
        this.enterprise = enterprise;
    }

    public TransactionDto toDto(){
        TransactionDto transaction = new TransactionDto();
        transaction.setId(this.id);
        transaction.setConcept(this.concept);
        transaction.setAmount(this.amount);
        if (enterprise != null) {
            transaction.setEnterpriseFk(this.getEnterprise().getId());
            transaction.setNombreEnterpriseFk(this.getEnterprise().getName());
        }
        //transaction.setEmployeeFk(this.employee.getId());
        return transaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", employee=" + employee +
                ", enterprise=" + enterprise +
                '}';
    }
}

