package com.tutorials.springTutorial.controller;

import com.tutorials.springTutorial.service.WelcomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/adminApis")
public class WelcomeController {

    private WelcomeService welcomeService;

    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    //http:localhost:4040/demo
    @GetMapping("/")
    public String defaultWelcome() {
        return welcomeService.welcomeMessage();
    }

    //http:localhost:4040/demo/welcome?firstName=abc&address=xyz
    @GetMapping(path = "/welcome")
    public String welcome(@RequestParam(name = "firstName", defaultValue = "") String name, @RequestParam String address) {
        return "Welcome User " + name + " with address " + address;
    }

    //http:localhost:4040/demo/admin
    @RequestMapping(value = "/admin", method = GET)
    public ResponseEntity<Map<String, String>> details() {
        return ResponseEntity.ok().body(Map.of("user", "details", "address", "India", "learnerMessage", "admin"));
    }


}
