package com.udea.GestionFinanciera.Controller;

import com.udea.GestionFinanciera.Dto.EmployeeDto;
import com.udea.GestionFinanciera.Dto.EnterpriseDto;
import com.udea.GestionFinanciera.Dto.ProfileDto;
import com.udea.GestionFinanciera.Dto.RolDto;
import com.udea.GestionFinanciera.Entity.Employee;
import com.udea.GestionFinanciera.Enums.ROLES;
import com.udea.GestionFinanciera.Service.EmployeeServiceI;
import com.udea.GestionFinanciera.Service.EnterpriseServiceI;
import com.udea.GestionFinanciera.Service.ProfileServiceI;
import com.udea.GestionFinanciera.Service.RolServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/views/employee")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT})
public class EmployeeController {

    @Autowired
    private EmployeeServiceI employeeServiceI;

    @Autowired
    private ProfileServiceI profileServiceI;

    @Autowired
    private EnterpriseServiceI enterpriseServiceI;

    @Autowired
    private RolServiceI rolesServiceI;

    @GetMapping("/listarEmployee")
    public String listarEmployees(Model model) {

        List<EmployeeDto> listadoEmployees = employeeServiceI.consultarEmployeeAll()
                .stream().map(Employee::toDto)
                .collect(Collectors.toList());

        model.addAttribute("titulo", "Listado de Employees");
        model.addAttribute("lstEmployees", listadoEmployees);

        return "/views/employee/listar";
    }

    @GetMapping("/create/{id}")
    public String crear(Model model, @PathVariable("id") Long idEmployee) {

        EmployeeDto employeeDto = null;

        if (idEmployee > 0) {
            employeeDto = employeeServiceI.consultarEmployeeById(idEmployee).toDto();
            model.addAttribute("titulo", "Formulario: Editar Employee");

        } else {
            employeeDto = new EmployeeDto();
            model.addAttribute("titulo", "Formulario: Nuevo Employee");
        }

        List<EnterpriseDto> listaEnterprise = enterpriseServiceI.consultarEnterpriseEmp();
        List<RolDto> listarRoles = rolesServiceI.consultarRolesAll();

        model.addAttribute("employee", employeeDto);
        model.addAttribute("listaEnterprise", listaEnterprise);
        model.addAttribute("listaRoles", listarRoles);
        return "/views/employee/frmCrear";
    }

    @PostMapping("/save")
    public String creaEmployee(@ModelAttribute EmployeeDto employeeDto, BindingResult result,
                               Model model, RedirectAttributes attribute) {

        List<EnterpriseDto> listaEnterprise = enterpriseServiceI.consultarEnterpriseEmp();
        List<RolDto> listarRoles = rolesServiceI.consultarRolesAll();

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo Employee");
            model.addAttribute("employee", employeeDto);
            model.addAttribute("listaEnterprise", listaEnterprise);
            model.addAttribute("listaRoles", listarRoles);
            System.out.println("Existieron errores en el formulario");
            return "/views/employee/frmCrear";
        }

        employeeServiceI.crearEmployee(employeeDto);
        System.out.println("Employee Guardado con exito!");
        attribute.addFlashAttribute("success", "Employee Guardado con exito!");
        return "redirect:/views/employee/listarEmployee";
    }

    @GetMapping("/delete/{id}/{idProfile}")
    public String eliminar(@PathVariable("id") Long idEmployee, @PathVariable("idProfile") Long idProfile,
                           RedirectAttributes attribute) {

        EmployeeDto employeeDto = null;
        ProfileDto profileDto = null;

        if (idEmployee > 0 && idProfile > 0) {
            employeeDto = employeeServiceI.consultarEmployeeById(idEmployee).toDto();
            profileDto = profileServiceI.consultarProfileById(idProfile).toDto();

            if (employeeDto == null || profileDto == null) {
                System.out.println("Error: Error con el ID del Employee");
                attribute.addFlashAttribute("error", "ATENCION: El ID del Employee no exixte!");
                return "redirect:/views/employee/listarEmployee";
            }
        } else {
            System.out.println("Error: El ID del Employee no existe");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Employee!");
            return "redirect:/views/employee/listarEmployee";
        }
        employeeServiceI.eliminarEmployeeById(idEmployee, idProfile);
        System.out.println("Registro Eliminado con Exito!");
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
        return "redirect:/views/employee/listarEmployee";
    }
}
