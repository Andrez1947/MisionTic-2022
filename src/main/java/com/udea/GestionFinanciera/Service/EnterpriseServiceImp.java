package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Dto.EnterpriseDto;
import com.udea.GestionFinanciera.Entity.Enterprise;
import com.udea.GestionFinanciera.Repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnterpriseServiceImp implements EnterpriseServiceI {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public String crearEnterprise(EnterpriseDto enterpriseDto) {
        Enterprise enterprise = enterpriseDto.toEntity();
        enterprise.setCreatedAt(new Date());
        enterpriseRepository.save(enterprise);
        return "Enterprise creada exitosamente";
    }

    @Override
    public List<EnterpriseDto> consultarEnterpriseEmp() {
        return enterpriseRepository.findAll().stream().map(Enterprise :: toDtoAll).collect(Collectors.toList());

    }

    @Override
    public List<Enterprise> consultarTodasEnterprises() {
        return enterpriseRepository.findAll();
    }

    @Override
    public List<EnterpriseDto> consultarEnterpriseAll() {
        return enterpriseRepository.findAll().stream().map(Enterprise :: toDto).collect(Collectors.toList());
    }

    @Override
    public Enterprise consultarEnterpriseById(Long id) {
        return enterpriseRepository.findById(id).get();
    }

    @Override
    public Enterprise consultarEnterpriseId(Long id) throws Exception {
        Optional<Enterprise> enterpriseBd =enterpriseRepository.findById(id);
        if (enterpriseBd.isPresent()){
            return enterpriseBd.get();
        }
        throw new Exception("Enterprise NO existe");
    }

    @Override
    public String eliminarEnterpriseById(Long id) {
        enterpriseRepository.deleteById(id);
        return "Enterprise eliminada exitosamente";
    }

    @Override
    public Enterprise actualizarEnterpriseByAttribute(Enterprise enterprise_update, Long id) throws Exception {
        Enterprise enterpriseBd = consultarEnterpriseId(id);
        if (enterprise_update.getName() != null && !enterprise_update.getName().equals("")){
            enterpriseBd.setName(enterprise_update.getName());
        }
        if (enterprise_update.getDocument() != null && !enterprise_update.getDocument().equals("")){
            enterpriseBd.setDocument(enterprise_update.getDocument());
        }
        if (enterprise_update.getAddress() != null && !enterprise_update.getAddress().equals("")){
            enterpriseBd.setAddress(enterprise_update.getAddress());
        }
        if (enterprise_update.getPhone() != null && !enterprise_update.getPhone().equals("")){
            enterpriseBd.setPhone(enterprise_update.getPhone());
        }
        if (enterprise_update.getCreatedAt() != null && !enterprise_update.getCreatedAt().equals("")){
            enterpriseBd.setCreatedAt(enterprise_update.getCreatedAt());
        }
        if (enterprise_update.getUpdatedAt() != null && !enterprise_update.getUpdatedAt().equals("")){
            enterpriseBd.setUpdatedAt(enterprise_update.getUpdatedAt());
        }
        return enterpriseRepository.save(enterpriseBd);
    }
}
