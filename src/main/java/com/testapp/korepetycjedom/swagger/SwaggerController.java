package com.testapp.korepetycjedom.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//:8080/
@Controller
@RequestMapping("/")
public class SwaggerController {

    @GetMapping
    public String getSwaggerUI(){
        return "redirect:/swagger-ui.html";
    }
}
