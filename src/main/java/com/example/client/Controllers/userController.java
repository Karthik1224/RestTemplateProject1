package com.example.client.Controllers;


import com.example.client.Modals.Employee;
import com.example.client.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class userController {

    @Autowired
    private userService user_service;


    @GetMapping("/fetchEmployees")
    public List<Employee> fetchEmployees()
    {
        return user_service.fetchEmployees();
    }


    @PostMapping("/registerEmployee")
    public String registerEmployee(@RequestBody Employee obj)
    {
        return user_service.registerEmployee(obj);
    }
}
