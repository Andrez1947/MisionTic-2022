package com.udea.GestionFinanciera.Repository;

import com.udea.GestionFinanciera.Entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
