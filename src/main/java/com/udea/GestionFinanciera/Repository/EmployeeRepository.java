package com.udea.GestionFinanciera.Repository;

import com.udea.GestionFinanciera.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
