
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/employees")
@CrossOrigin("https://springapp-postgres-cloudrun-484004643828.europe-west1.run.app/")
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





