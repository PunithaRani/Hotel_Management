package org.hotelmanagementsystem.controller;


import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

    private static Logger logger = Logger.getLogger(CustomErrorController.class);

    @GetMapping("/error")
    public String error() {
        logger.info("ACCESS DENIED");
        return "Login/accessdenied";
    }
}
