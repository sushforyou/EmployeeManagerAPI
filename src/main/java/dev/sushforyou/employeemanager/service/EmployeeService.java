package dev.sushforyou.employeemanager.service;

import dev.sushforyou.employeemanager.exception.UserNotFoundException;
import dev.sushforyou.employeemanager.model.Employee;
import dev.sushforyou.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
    public Employee updateEmployee (Employee employee) {
        return  employeeRepo.save(employee);
    }
    public void deleteEmployee (Long id) {
          employeeRepo.deleteEmployeById(id);
    }

    public  Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).
                orElseThrow(()-> new UserNotFoundException(
                "User by id"+id+" was not found"));
    }
}
