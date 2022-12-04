package com.example.employeespring.services;

import com.example.employeespring.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeServices {

   Employee create(final Employee employee);
   List<Employee> getall();
   Optional<Employee> getallbyid(Long id);


   Employee update(Long id ,final Employee employee);

   public void delete (Long id);
}
