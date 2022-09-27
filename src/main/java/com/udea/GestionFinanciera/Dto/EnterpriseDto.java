package com.udea.GestionFinanciera.Dto;

import com.udea.GestionFinanciera.Entity.Enterprise;

import java.util.Date;

public class EnterpriseDto {

    private Long id;
    private String name;
    private String document;
    private String phone;
    private String address;

    public Enterprise toEntity(){
        Enterprise enterprise = new Enterprise();
        enterprise.setId(this.id);
        enterprise.setName(this.name);
        enterprise.setDocument(this.document);
        enterprise.setPhone(this.phone);
        enterprise.setAddress(this.address);
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

}

