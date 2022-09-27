package com.udea.GestionFinanciera.Dto;

import com.udea.GestionFinanciera.Entity.Employee;
import com.udea.GestionFinanciera.Entity.Enterprise;
import com.udea.GestionFinanciera.Entity.Profile;
import com.udea.GestionFinanciera.Entity.Rol;
import com.udea.GestionFinanciera.Enums.ROLES;

import java.util.Date;

public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private Long enterpriseFk;
    private Long profileFk;
    private Long rolesFk;
    private String nombreEnterpriseFk;
    private String nombreRolFk;
    private String nombreImagen;
    private String telefono;

    public Employee toEntity(){
        Employee employee = new Employee();
        employee.setId(this.id);
        employee.setName(this.name);
        employee.setEmail(this.email);
        if (this.enterpriseFk != null){
            Enterprise enterprise = new Enterprise();
            enterprise.setId(this.enterpriseFk);
            employee.setEnterprise(enterprise);
        }
        if (rolesFk != null){
            Rol roles = new Rol();
            roles.setId(this.rolesFk);
            employee.setRoles(roles);
        }
        if (profileFk != null){
            Profile profile = new Profile();
            profile.setId(this.profileFk);
            profile.setUpdatedAt(new Date());
            employee.setProfile(profile);
        }
        return employee;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEnterpriseFk() {
        return enterpriseFk;
    }

    public void setEnterpriseFk(Long enterpriseFk) {
        this.enterpriseFk = enterpriseFk;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreEnterpriseFk() {
        return nombreEnterpriseFk;
    }

    public void setNombreEnterpriseFk(String nombreEnterpriseFk) {
        this.nombreEnterpriseFk = nombreEnterpriseFk;
    }

    public Long getProfileFk() {
        return profileFk;
    }

    public void setProfileFk(Long profileFk) {
        this.profileFk = profileFk;
    }

    public Long getRolesFk() {
        return rolesFk;
    }

    public void setRolesFk(Long rolesFk) {
        this.rolesFk = rolesFk;
    }

    public String getNombreRolFk() {
        return nombreRolFk;
    }

    public void setNombreRolFk(String nombreRolFk) {
        this.nombreRolFk = nombreRolFk;
    }
}
