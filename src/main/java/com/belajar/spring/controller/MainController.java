package com.belajar.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String home() {
        return "index";
    }
}
