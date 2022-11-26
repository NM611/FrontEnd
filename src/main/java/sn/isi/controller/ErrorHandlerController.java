package sn.isi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandlerController extends Error {

    @GetMapping("/error")
    public String customError() {
        return "The link you followed may be broken, or the page may have been removed.";
    }

    public String getErrorPath() {
        return "/error";
    }
}
