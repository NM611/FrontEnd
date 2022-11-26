package sn.isi.controller;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sn.isi.model.Profil;
import sn.isi.model.User;
import sn.isi.service.ProfilService;
import sn.isi.service.UserService;

@Data
@Controller
public class UserController {

    @Autowired
    public ProfilService profilService;

    @Autowired
    private UserService userService;

    @GetMapping("/RegisterUser")
    public ModelAndView RegisterUser(@RequestParam("x") String x, Model model){


        if(x.equals("Client")){
            model.addAttribute("user",new User());
            return new ModelAndView("redirect:/register?y=client");
        }
        if(x.equals("Entreprise")){
            return new ModelAndView("redirect:/registerEntre?z=entreprise");
        }
        return new ModelAndView("redirect:/");

    }


    @GetMapping("/ChoixProfil")
    public String ChoixProfil(Model model){

        Profil  p = new Profil();

        return "ChoixProfil";
    }

    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("user", new User());

        return "register";
    }

    @GetMapping("/registerEntre")
    public String registerEntre(Model model){

        model.addAttribute("user",new User());
        return "registerEntre";
    }

    @GetMapping("/test")
    public String test(Model model){

        model.addAttribute("user",new User());
        return "test";
    }

    @PostMapping("/SaveUserClient")
    public ModelAndView SaveUserClient(@ModelAttribute User user, RedirectAttributes redirectAttributes){
        Profil p= profilService.getObjProfil("client");

        if(p!=null){
            System.out.println("profil ok");
        }else{
            System.out.println("profil bad");
        }

        user.setProfil(p);
        user.setEtat(false);
        User us=userService.saveClient(user);

        if(us!=null){

            redirectAttributes.addFlashAttribute("success","Utilisateur enregistre!!!");
            return new ModelAndView("redirect:/register");
            //System.out.println("ok");
        }else{

            return new ModelAndView("redirect:/ChoixProfil");
        }




    }

    @PostMapping("/SaveUserEntreprise")
    public ModelAndView SaveUserEntreprise(Model model){
        User u1 = new User();

        return new ModelAndView("redirect:/registerEntre");
    }





}
