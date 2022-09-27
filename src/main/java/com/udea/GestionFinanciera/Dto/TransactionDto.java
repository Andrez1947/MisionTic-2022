package com.udea.GestionFinanciera.Dto;

import com.udea.GestionFinanciera.Entity.Employee;
import com.udea.GestionFinanciera.Entity.Enterprise;
import com.udea.GestionFinanciera.Entity.Transaction;

import java.util.Date;

public class TransactionDto {

    private Long id;
    private String concept;
    private float amount;
    private Long employeeFk;
    private Long enterpriseFk;
    private String nombreEnterpriseFk;

    public Transaction toEntity(){
        Transaction transaction = new Transaction();
        transaction.setId(this.id);
        transaction.setConcept(this.concept);
        transaction.setAmount(this.amount);
        if (this.enterpriseFk != null){
            Enterprise enterprise = new Enterprise();
            enterprise.setId(this.enterpriseFk);
            transaction.setEnterprise(enterprise);
        }
        /*
        if (this.employeeFk != null){
            Employee employee = new Employee();
            employee.setId(this.employeeFk);
            transaction.setEmployee(employee);
        }
        */
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

    public Long getEmployeeFk() {
        return employeeFk;
    }

    public void setEmployeeFk(Long employeeFk) {
        this.employeeFk = employeeFk;
    }

    public Long getEnterpriseFk() {
        return enterpriseFk;
    }

    public void setEnterpriseFk(Long enterpriseFk) {
        this.enterpriseFk = enterpriseFk;
    }

    public String getNombreEnterpriseFk() {
        return nombreEnterpriseFk;
    }

    public void setNombreEnterpriseFk(String nombreEnterpriseFk) {
        this.nombreEnterpriseFk = nombreEnterpriseFk;
    }
}

