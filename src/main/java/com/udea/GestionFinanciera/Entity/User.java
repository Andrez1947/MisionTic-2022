package com.udea.GestionFinanciera.Entity;


import com.udea.GestionFinanciera.Enums.ROLES;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    @Column
    private String Password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = ROLES.class, fetch = FetchType.EAGER)
    private List<ROLES> rol;

    public User() {
    }

    public User(String username, String password,List<ROLES> rol ) {
        this.username = username;
        this.Password = password;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<ROLES> getRol() {
        return rol;
    }

    public void setRol(List<ROLES> rol) {
        this.rol = rol;
    }
}
