package com.spark.progrankdatabase.controller;

import com.spark.progrankdatabase.entity.User;
import com.spark.progrankdatabase.service.UserService;
import jakarta.persistence.ColumnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@EnableMethodSecurity
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAll()
    {
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user)
    {
         return  this.userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable int id)
    {
        return this.userService.deleteUser(id);
    }



}
