package org.example.controllers;

import org.example.dto.UserDto;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public List<UserDto> getUsers(@RequestParam String username1, @RequestParam String username2, @RequestParam String email){
        return userService.findByNames(username1, username2, email);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto user){

        return userService.addUser(user);
    }
}
