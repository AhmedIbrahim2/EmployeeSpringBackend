package com.example.employeespring.controller;


import com.example.employeespring.model.Employee;
import com.example.employeespring.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices ;

    @PostMapping("/create")
    public Employee create(@RequestBody final Employee employee){
        try {
            return employeeServices.create(employee);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/all")
    public List<Employee> getall(){
        try {
            return employeeServices.getall();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/{id}")
    public Optional<Employee> getallbyid(@PathVariable Long id){
        try {
            return employeeServices.getallbyid(id) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @RequestMapping(value = "delete/{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        try {
            employeeServices.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    @RequestMapping(value = "update/{id}" , method = RequestMethod.PUT)
    public Employee create(@PathVariable Long id ,@RequestBody Employee employee){

        try {
            return employeeServices.update(id ,employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
