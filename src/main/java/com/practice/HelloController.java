package com.practice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class HelloController {
    @GetMapping("/hi")
    public String sayHi(){
        return "Hi";    
    }
}

