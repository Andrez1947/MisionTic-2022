package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Dto.EnterpriseDto;
import com.udea.GestionFinanciera.Entity.Enterprise;

import java.util.List;

public interface EnterpriseServiceI {


    public List<Enterprise> consultarTodasEnterprises();
    public List<EnterpriseDto> consultarEnterpriseAll();
    public List<EnterpriseDto> consultarEnterpriseEmp();
    public String crearEnterprise(EnterpriseDto enterpriseDto);
    public Enterprise consultarEnterpriseById(Long id);
    public Enterprise consultarEnterpriseId(Long id) throws Exception;
    public String eliminarEnterpriseById(Long id);
    public Enterprise actualizarEnterpriseByAttribute(Enterprise enterprise_update, Long id) throws Exception;
}
