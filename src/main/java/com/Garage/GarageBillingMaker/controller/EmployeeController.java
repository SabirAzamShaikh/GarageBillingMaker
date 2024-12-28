package com.Garage.GarageBillingMaker.controller;

import com.Garage.GarageBillingMaker.Entity.Employee;
import com.Garage.GarageBillingMaker.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return service.saveEmployee(employee);
    }

    @GetMapping("/fetch")
    public List<Employee> FetchEmployee()
    {
        return service.FetchAllEmployee();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteEmployee(@PathVariable int id)
    {
        if(service.DeleteEmployee(id))
        {
            return ResponseEntity.ok("Employee Deleted Succesfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with Id "+id+" Not Found");
    }

}
