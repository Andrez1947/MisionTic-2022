package com.udea.GestionFinanciera.Entity;

import com.udea.GestionFinanciera.Dto.EmployeeDto;
import com.udea.GestionFinanciera.Enums.ROLES;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    /*@Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Enum_RoleName role;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = ROLES.class, fetch = FetchType.EAGER)
    private List<ROLES> roles;

     */

    @OneToOne
    private Profile profile;

    @OneToMany(mappedBy = "employee")
    private List<Transaction> transactions;

    @ManyToOne
    private Rol roles;

    @ManyToOne
    private Enterprise enterprise;

    public Employee() {
    }

    public Employee(Long id, String name, String email, Date createdAt, Date updatedAt, Profile profile, List<Transaction> transactions, Rol roles, Enterprise enterprise) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.profile = profile;
        this.transactions = transactions;
        this.roles = roles;
        this.enterprise = enterprise;
    }

    public EmployeeDto toDto() {
        EmployeeDto employee = new EmployeeDto();
        employee.setId(this.id);
        employee.setName(this.name);
        employee.setEmail(this.email);
        if (enterprise != null) {
            employee.setEnterpriseFk(this.getEnterprise().getId());
            employee.setNombreEnterpriseFk(this.getEnterprise().getName());
        }
        if (roles != null){
            employee.setRolesFk(this.getRoles().getId());
            employee.setNombreRolFk(this.getRoles().getRol());
        }
        if (profile != null) {
            employee.setProfileFk(this.profile.getId());
            employee.setNombreImagen(this.profile.getImage());
            employee.setTelefono(this.profile.getPhone());
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Rol getRoles() {
        return roles;
    }

    public void setRoles(Rol roles) {
        this.roles = roles;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", profile=" + profile +
                ", transactions=" + transactions +
                ", roles=" + roles +
                ", enterprise=" + enterprise +
                '}';
    }
}
