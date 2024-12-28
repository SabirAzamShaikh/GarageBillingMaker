package com.Garage.GarageBillingMaker.service;

import com.Garage.GarageBillingMaker.Entity.Employee;
import com.Garage.GarageBillingMaker.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    private EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo)
    {
        this.repo = repo;
    }

    public Employee saveEmployee(Employee employee)
    {
        return repo.save(employee);
    }

    public List<Employee> FetchAllEmployee()
    {
        return repo.findAll();
    }

    public boolean DeleteEmployee(int id)
    {
        if(repo.existsById(id))
        {
            repo.deleteById(id);
            return true;
        }
            return false;

    }

}
