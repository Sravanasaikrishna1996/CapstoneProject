package com.gfg.employeaap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Handle the error and return a custom error page
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}

