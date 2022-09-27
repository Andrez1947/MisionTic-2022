package com.udea.GestionFinanciera.Service;


import com.udea.GestionFinanciera.Dto.EmployeeDto;
import com.udea.GestionFinanciera.Dto.ProfileDto;
import com.udea.GestionFinanciera.Entity.Employee;
import com.udea.GestionFinanciera.Entity.Profile;
import com.udea.GestionFinanciera.Repository.EmployeeRepository;
import com.udea.GestionFinanciera.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeServiceI {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public String crearEmployee(EmployeeDto employeeDto) {
        Profile profile = new Profile();
        Employee employee = employeeDto.toEntity();
        profile.setImage(employeeDto.getNombreImagen());
        profile.setPhone(employeeDto.getTelefono());
        profile.setCreatedAt(new Date());
        employee.setProfile(profileRepository.save(profile));
        employee.setCreatedAt(new Date());
        employee.setName(employee.getName().toUpperCase());
        employeeRepository.save(employee);
        return "Employee creado exitosamente";
    }


    @Override
    public List<Employee> consultarEmployeeAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee consultarEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee consultarEmployeeeId(Long id) throws Exception {
        Optional<Employee> employeeBd = employeeRepository.findById(id);
        if (employeeBd.isPresent()) {
            return employeeBd.get();
        }
        throw new Exception("Employee NO existe");
    }

    @Override
    public String eliminarEmployeeById(Long id, Long idPerfil) {
        employeeRepository.deleteById(id);
        profileRepository.deleteById(idPerfil);
        return "Employee eliminado exitosamente";
    }

    @Override
    public Employee actualizarEmployeeByAttribute(Employee employee_update, Long id) throws Exception {
        Employee employeeBd = consultarEmployeeeId(id);
        if (employee_update.getName() != null && !employee_update.getName().equals("")) {
            employeeBd.setName(employee_update.getName());
        }
        if (employee_update.getEmail() != null && !employee_update.getEmail().equals("")) {
            employeeBd.setEmail(employee_update.getEmail());
        }
        if (employee_update.getCreatedAt() != null && !employee_update.getCreatedAt().equals("")) {
            employeeBd.setCreatedAt(employee_update.getCreatedAt());
        }
        if (employee_update.getUpdatedAt() != null && !employee_update.getUpdatedAt().equals("")) {
            employeeBd.setUpdatedAt(employee_update.getUpdatedAt());
        }
        return employeeRepository.save(employeeBd);
    }
}
