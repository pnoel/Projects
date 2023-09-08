package org.pxdev.controller;

import org.pxdev.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private IUserService userService;

    @GetMapping( "/users" )
    public String index() {
        return userService.getAllUser();
    }
}