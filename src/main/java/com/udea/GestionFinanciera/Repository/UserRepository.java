package com.udea.GestionFinanciera.Repository;

import com.udea.GestionFinanciera.Entity.Employee;
import com.udea.GestionFinanciera.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
