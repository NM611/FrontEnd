package sn.isi.controller;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sn.isi.model.Employe;
import sn.isi.service.EmployeService;
import sn.isi.service.LoginService;

@Data
@Controller
public class LoginController {

    @Autowired
    public LoginService loginService;
    @Autowired
    public EmployeService employeService;

    @GetMapping("/login")
    public String login(Model model){
        Employe e = new Employe();
        model.addAttribute("employe", e);

        return "login";
    }

    @GetMapping("/inscription")
    public String inscription(Model model){
        Employe e = new Employe();
        model.addAttribute("employe", e);

        return "inscription";
    }



    @GetMapping("/accueil")
    public String accueil(Model model){

        return "client/index";
    }



    @GetMapping("/liste")
    public String liste(Model model, RedirectAttributes rediAttrs){
        Iterable<Employe> listEmployee = employeService.getEmployes();
        model.addAttribute("employes", listEmployee);
        rediAttrs.addFlashAttribute("success","Connexion reussie !!!");
        return "liste";
    }

    @PostMapping("/returnLogin")
    public ModelAndView returnLogin(@ModelAttribute Employe employe){


        Employe emp = loginService.getEmployeeLogin(employe);
        if (emp != null){
            return new ModelAndView("redirect:/liste");
        }else{

            return new ModelAndView("redirect:/login");
        }

    }

    @GetMapping("/login1")
    public String login1(Model model){

        return "login_1";
    }





}
