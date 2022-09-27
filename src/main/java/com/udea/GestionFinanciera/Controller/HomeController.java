package com.udea.GestionFinanciera.Controller;

import com.udea.GestionFinanciera.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/index","/home"})
    public String index() {

        return "/views/home";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUsuario",new User());
        return "/views/login";
    }

    @GetMapping({"/"})
    public String welcome() {

        return "/views/welcome";
    }


}
