package com.udea.GestionFinanciera.Controller;

import com.udea.GestionFinanciera.Dto.EmployeeDto;
import com.udea.GestionFinanciera.Dto.EnterpriseDto;
import com.udea.GestionFinanciera.Dto.TransactionDto;
import com.udea.GestionFinanciera.Entity.Employee;
import com.udea.GestionFinanciera.Entity.Enterprise;
import com.udea.GestionFinanciera.Entity.Transaction;
import com.udea.GestionFinanciera.Service.EnterpriseServiceI;
import com.udea.GestionFinanciera.Service.TransactionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/views/transaction")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT})
public class TransactionController {

    @Autowired
    private TransactionServiceI transactionServiceI;

    @Autowired
    private EnterpriseServiceI enterpriseServiceI;

    @GetMapping("/listarTransaction")
    public String listarTransaction(Model model) {

        List<TransactionDto> listadoTransaction = transactionServiceI.consultarTransactionAll()
                .stream().map(Transaction::toDto)
                .collect(Collectors.toList());

        model.addAttribute("titulo", "Listado de Transaction");
        model.addAttribute("lstTransaction", listadoTransaction);

        return "/views/transaction/listar";
    }

    @GetMapping("/create/{id}")
    public String crear(Model model, @PathVariable("id") Long idTransaction) {

        TransactionDto transactionDto = null;

        if (idTransaction > 0){
            transactionDto = transactionServiceI.consultarTransactionById(idTransaction).toDto();
            model.addAttribute("titulo", "Formulario: Editar Transaction");
        } else {
            transactionDto = new TransactionDto();
            model.addAttribute("titulo", "Formulario: Nueva Transaction");
        }
        List<EnterpriseDto> listaEnterprise = enterpriseServiceI.consultarEnterpriseEmp();

        model.addAttribute("titulo", "Formulario: Nueva Transaction");
        model.addAttribute("transaction", transactionDto);
        model.addAttribute("listaEnterprise", listaEnterprise);

        return "/views/transaction/frmCrear";
    }

    @PostMapping("/save")
    public String crearTransaction(@ModelAttribute TransactionDto transactionDto, BindingResult result,
                                   Model model, RedirectAttributes attribute) {

        List<EnterpriseDto> listaEnterprise = enterpriseServiceI.consultarEnterpriseEmp();

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nueva Transaction");
            model.addAttribute("transaction", transactionDto);
            model.addAttribute("listaEnterprise", listaEnterprise);
            System.out.println("Existieron errores en el formulario");
            return "/views/transaction/frmCrear";
        }

        transactionServiceI.crearTransaction(transactionDto);
        System.out.println("Transaction Guardada con exito!");
        attribute.addFlashAttribute("success", "Transaction Creada con exito!");
        return "redirect:/views/transaction/listarTransaction";
    }

    @GetMapping("/delete/{id}")
    public String eliminarTransaction(@PathVariable("id") Long idTransaction, RedirectAttributes attribute) {

        TransactionDto transactionDto = null;

        if (idTransaction > 0) {
            transactionDto = transactionServiceI.consultarTransactionById(idTransaction).toDto();

            if (transactionDto == null) {
                System.out.println("Error: ATENCION: El ID de la Transaction no exixte!");
                attribute.addFlashAttribute("error", "ATENCION: El ID de la Transaction no exixte!");
                return "redirect:/views/transaction/listarTransaction";
            }
        } else {
            System.out.println("Error: ATENCION: Error con el ID de la Transaction!");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID de la Transaction!");
            return "redirect:/views/transaction/listarTransaction";
        }

        transactionServiceI.eliminarTransactionById(idTransaction);
        System.out.println("Registro Eliminado con Exito!");
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
        return "redirect:/views/transaction/listarTransaction";
    }

}
