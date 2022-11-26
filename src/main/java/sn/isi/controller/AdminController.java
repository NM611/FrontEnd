package sn.isi.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Controller
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard(Model model){

        return "dashboard/index";
    }

}
