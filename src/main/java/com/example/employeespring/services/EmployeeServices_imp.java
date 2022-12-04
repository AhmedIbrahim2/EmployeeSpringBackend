package com.example.employeespring.services;

import com.example.employeespring.model.Employee;
import com.example.employeespring.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices_imp implements EmployeeServices{


    @Autowired
    EmployeeRepository employeeRepository ;
    @Override
    public Employee create(final Employee employee) {
        return  employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getall(){
        return employeeRepository.findAll();
    }


    @Override
    public Optional <Employee> getallbyid(Long id){
      return employeeRepository.findById(id);

    }

    @Override
    public Employee update(Long id ,Employee employee) {
        Employee Existing_emp = employeeRepository.getById(id);
        BeanUtils.copyProperties(employee , Existing_emp ,"id");
        return employeeRepository.save(Existing_emp);

    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
