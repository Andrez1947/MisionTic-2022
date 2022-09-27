package com.udea.GestionFinanciera.Repository;

import com.udea.GestionFinanciera.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
