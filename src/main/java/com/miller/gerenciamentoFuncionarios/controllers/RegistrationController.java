package com.miller.gerenciamentoFuncionarios.controllers;

import java.io.UnsupportedEncodingException;

import javax.validation.Valid;

import com.miller.gerenciamentoFuncionarios.appuser.AppUser;
import com.miller.gerenciamentoFuncionarios.services.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    
    @Autowired
    private AppUserService userService;

    @GetMapping("/registration")
    public String registration(@ModelAttribute AppUser appUser, Model model) {
        model.addAttribute("appUser", new AppUser());
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String save(@Valid @ModelAttribute("appUser") AppUser appUser, BindingResult result)
            throws UnsupportedEncodingException{

        if (result.hasErrors()) {

            return "/registrationForm";
        }

        userService.register(appUser);
        return "/registration_success";

    }

 
}