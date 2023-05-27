package com.anaschenkov.start.controllers;

import com.anaschenkov.start.domain.entity.User;
import com.anaschenkov.start.domain.repo.UserRepo;
import com.anaschenkov.start.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userFromDB = userRepo.findByUsername( user.getUsername() );
        if (userFromDB != null){
            model.addAttribute( "message", "Пользователь уже существует!" );
            return "registration";
        }
        user.setActive( true );
        user.setRoles( Collections.singleton( Role.USER ) );
        userRepo.save( user );
        return "redirect:/login";
    }
}
