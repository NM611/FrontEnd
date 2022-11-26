package sn.isi.controller;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import sn.isi.model.Employe;
import sn.isi.service.EmployeService;

import javax.servlet.http.HttpServletRequest;

@Data
@Controller
public class EmployeeController {

    @Autowired
    public EmployeService employeService;

    @GetMapping("/")
    public String liste(Model model){
        Iterable<Employe> listEmployee = employeService.getEmployes();
        model.addAttribute("employes", listEmployee);
        return "liste";
    }



    @GetMapping("/createEmploye")
    public String createEmployee(Model model) {
        Employe e = new Employe();
        model.addAttribute("employe", e);
        return "formNewEmploye";
    }

    @PostMapping("/saveEmploye")
    public ModelAndView saveEmploye(@ModelAttribute Employe employe) {
        if(employe.getId() != 0) {
            // Employee from update form has the password field not filled,
            // so we fill it with the current password.
            Employe current = employeService.getEmploye(employe.getId());
            // employe.setPassword(current.getPassword());
        }
        employeService.saveEmploye(employe);
        return new ModelAndView("redirect:/");
    }
}
