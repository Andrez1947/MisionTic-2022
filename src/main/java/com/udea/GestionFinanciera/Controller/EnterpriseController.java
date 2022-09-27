package com.udea.GestionFinanciera.Controller;

import com.udea.GestionFinanciera.Dto.EmployeeDto;
import com.udea.GestionFinanciera.Dto.EnterpriseDto;
import com.udea.GestionFinanciera.Entity.Employee;
import com.udea.GestionFinanciera.Entity.Enterprise;
import com.udea.GestionFinanciera.Service.EnterpriseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/views/enterprise")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class EnterpriseController {

    @Autowired
    private EnterpriseServiceI enterpriseServiceI;

    @GetMapping("/listarEnterprise")
    public String listarEnterprises(Model model){

        List<EnterpriseDto> listadoEnterprises = enterpriseServiceI.consultarTodasEnterprises()
                .stream().map(Enterprise::toDto)
                .collect(Collectors.toList());

        model.addAttribute("titulo", "Listado de Empresas");
        model.addAttribute("enterprises", listadoEnterprises);
        return "/views/enterprise/listar";
    }

    @GetMapping("/create/{id}")
    public String crear(Model model, @PathVariable("id") Long idEnterprise){

        EnterpriseDto enterpriseDto = null;

        if (idEnterprise > 0){
            enterpriseDto = enterpriseServiceI.consultarEnterpriseById(idEnterprise).toDto();
            model.addAttribute("titulo", "Formulario: Editar Enterprise");
        } else {
            enterpriseDto = new EnterpriseDto();
            model.addAttribute("titulo", "Formulario: Nueva Enterprise");
        }
        model.addAttribute("enterprise", enterpriseDto);
        return "/views/enterprise/frmCrear";
    }

    @PostMapping("/save")
    public String crearEnterprise(@Valid @ModelAttribute EnterpriseDto enterpriseDto, BindingResult result,
                                  Model model, RedirectAttributes attribute) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nueva Enterprise");
            model.addAttribute("enterprise", enterpriseDto);
            System.out.println("Existieron errores en el formulario");
            return "/views/enterprise/frmCrear";
        }

        enterpriseServiceI.crearEnterprise(enterpriseDto);
        System.out.println("Enterprise Guardada con exito!");
        attribute.addFlashAttribute("success", "Enterprise Guardada con exito!");
        return "redirect:/views/enterprise/listarEnterprise";
    }

    @GetMapping("/delete/{id}")
    public String eliminarEnterprise(@PathVariable("id") Long idEnterprise, RedirectAttributes attribute) {

        EnterpriseDto enterpriseDto = null;

        if (idEnterprise > 0) {
            enterpriseDto = enterpriseServiceI.consultarEnterpriseById(idEnterprise).toDto();

            if (enterpriseDto == null) {
                System.out.println("Error: ATENCION: El ID del Employee no exixte!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del Employee no exixte!");
                return "redirect:/views/enterprise/listarEnterprise";
            }
        } else {
            System.out.println("Error: ATENCION: Error con el ID del Employee!");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Employee!");
            return "redirect:/views/enterprise/listarEnterprise";
        }

        enterpriseServiceI.eliminarEnterpriseById(idEnterprise);
        System.out.println("Registro Eliminado con Exito!");
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
        return "redirect:/views/enterprise/listarEnterprise";
    }

}
