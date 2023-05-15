package org.hotelmanagementsystem.controller;


import org.apache.log4j.Logger;
import org.hotelmanagementsystem.dto.UserInfoDTO;
import org.hotelmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "/login")
public class LoginPageController {

    private static Logger logger = Logger.getLogger(LoginPageController.class);
    private static final String MESSAGE = "message";

    @Autowired
    private UserService userService;

    @GetMapping
    public String home() {
        logger.info("Enter into Home Page");
        return "/Login/index";
    }

    @GetMapping("/userLogin")
    public String userLogin() {
        logger.info("Enter into Login Page");
        return "/Login/userLogin";
    }

    @GetMapping("/adminLogin")
    public String adminLogin() {
        return "/Login/adminLogin";
    }

    @GetMapping("/common")
    public String common(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/user";
        }
        return "redirect:/admin";
    }

    @PostMapping("/userlogin/error")
    public String userLoginError(Model model) {
        model.addAttribute(MESSAGE, "Invalid username and password");
        return "/Login/userLogin";
    }

    @GetMapping("/forgotAdmin")
    public String adminForgotPage() {
        return "/Login/forgotAdmin";
    }

    @GetMapping("/forgot")
    public String forgot() {
        return "/Login/forgot";
    }

    @GetMapping("/newUser")
    public String newUser() {
        return "/Login/newuser";
    }


    @GetMapping("/password")
    public String newPassword() {
        return "/Login/newpassword";
    }

    @PostMapping (value = "/forgot_validate", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String forgotValidate(UserInfoDTO userInfo, HttpServletRequest request) {
        String result = userService.checkUser(userInfo.getEmail(), userInfo.getKeyword());
        HttpSession session = request.getSession();
        if (result != null) {
            session.setAttribute("user", userInfo.getEmail());
            return "redirect:/login/password";
        }
        session.setAttribute("error_message", "Invalid Email and Keyword");
        return "redirect:/login/forgot";
    }

    @PostMapping(value = "/process_register", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String register(UserInfoDTO userInfo, Model model) {
        userInfo.setRole("USER");
        String result = userService.storeUser(userInfo);
        model.addAttribute("notification", "open");
        if (result != null) {
            model.addAttribute("option", "Valid");
            model.addAttribute(MESSAGE, "User details are successfully registered");
        } else {
            model.addAttribute("option", "Invalid");
            model.addAttribute(MESSAGE, "User account already exists");
        }
        return "/Login/newuser";
    }

    @PostMapping(value = "/process_password", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void forgotPassword(UserInfoDTO userInfo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        String email = session.getAttribute("user").toString();
        String result = userService.setPassword(email, userInfo.getPassword());
        if (result != null) {
            session.setAttribute(MESSAGE, "Password has been changed");
        }
        response.sendRedirect("/login/forgot");
    }

}
