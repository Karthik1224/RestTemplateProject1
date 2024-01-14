package com.example.client.Services;


import com.example.client.Modals.Employee;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class userService{



    @Autowired
    private RestTemplate restTemplate;

    public List<Employee> fetchEmployees()
    {
        ArrayList list=restTemplate.getForObject("http://localhost:8080/employee/getAllEmployees", ArrayList.class);
        return list;
    }


    public String registerEmployee(Employee obj)
    {
        HttpEntity<Employee> request = new HttpEntity<>(obj);
        ResponseEntity<Employee> response =  restTemplate.postForEntity("http://localhost:8080/employee/addEmployee",request, Employee.class);
        return "added successfully";
    }

}
