package com.pack.aeroporto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AereoController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}