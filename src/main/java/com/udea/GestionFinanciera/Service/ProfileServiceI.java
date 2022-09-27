package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Dto.ProfileDto;
import com.udea.GestionFinanciera.Entity.Profile;

public interface ProfileServiceI {

    public Profile crearProfile(ProfileDto profileDto);

    public Profile consultarProfileById(Long id);
}
