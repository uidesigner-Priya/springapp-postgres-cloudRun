
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @GetMapping
    public String info() {
        return "Hello Nisha";
    }
    @GetMapping("/about")
    public String about(){
        return "cloud run is executing";
    }
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping
    public Employee registerEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

}





