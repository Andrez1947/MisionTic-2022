package com.udea.GestionFinanciera.Dto;

import com.udea.GestionFinanciera.Entity.Rol;
public class RolDto {

    private Long id;
    private String rol;

    public Rol toEntity(){
        Rol roles = new Rol();
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
}
