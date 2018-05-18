package com.ts.controllers;

import javax.annotation.security.PermitAll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    @PermitAll
    public String root() {
        return "login";
    }
    @GetMapping("/login")
    @PermitAll
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    @PermitAll
    public String accessDenied() {
        return "/error/access-denied";
    }

}
