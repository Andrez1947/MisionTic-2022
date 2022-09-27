package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Dto.RolDto;
import com.udea.GestionFinanciera.Entity.Rol;
import com.udea.GestionFinanciera.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesServiceImp implements RolServiceI {

    @Autowired
    private RolRepository rolesRepository;

    @Override
    public List<RolDto> consultarRolesAll() {
        return rolesRepository.findAll().stream().map(Rol:: toDto).collect(Collectors.toList());
    }
}
