package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Dto.ProfileDto;
import com.udea.GestionFinanciera.Entity.Profile;
import com.udea.GestionFinanciera.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImp implements ProfileServiceI {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile crearProfile(ProfileDto profileDto) {
        return profileRepository.save(profileDto.toEntity());
    }

    @Override
    public Profile consultarProfileById(Long id) {
        return profileRepository.findById(id).get();
    }
}
