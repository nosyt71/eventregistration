package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/register")
public class RegistrationController {
    
    // TODO: Task 6
    @GetMapping(path="/2")
    public String register() {
        return "view1";
    }


    // TODO: Task 7
    @PostMapping(path="/registration")
    public String processRegistration() {
        return "view2";
    }

}
