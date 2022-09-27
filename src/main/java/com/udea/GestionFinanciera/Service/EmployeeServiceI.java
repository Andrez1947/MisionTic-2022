package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Dto.EmployeeDto;
import com.udea.GestionFinanciera.Dto.ProfileDto;
import com.udea.GestionFinanciera.Entity.Employee;

import java.util.List;

public interface EmployeeServiceI {

    public String crearEmployee(EmployeeDto employeeDto);
    public List<Employee> consultarEmployeeAll();
    public Employee consultarEmployeeById(Long id);
    public Employee consultarEmployeeeId(Long id) throws Exception;
    public String eliminarEmployeeById(Long id, Long idPerfil);
    public Employee actualizarEmployeeByAttribute(Employee employee_update, Long id) throws Exception;

}
