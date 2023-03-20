package com.vetrix.network_API.message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class testController {

    @GetMapping
    public String test(){
        return "BONJOUR";
    }
}
