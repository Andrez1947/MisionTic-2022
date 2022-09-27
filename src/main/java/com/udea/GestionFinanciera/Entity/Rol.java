package com.udea.GestionFinanciera.Entity;

import com.udea.GestionFinanciera.Dto.RolDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String rol;

    @OneToMany(mappedBy = "roles")
    private List<Employee> employees;

    public Rol() {
    }

    public Rol(Long id, String rol, List<Employee> employees) {
        this.id = id;
        this.rol = rol;
        this.employees = employees;
    }

    public RolDto toDto(){
        RolDto roles = new RolDto();
        roles.setId(this.id);
        roles.setRol(this.rol);
        return roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                ", employees=" + employees +
                '}';
    }
}
