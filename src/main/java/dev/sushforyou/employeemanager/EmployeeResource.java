package dev.sushforyou.employeemanager;

import dev.sushforyou.employeemanager.model.Employee;
import dev.sushforyou.employeemanager.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
        Employee employees = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee) {
        Employee newEmployees = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployees, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee) {
        Employee updateEmployees = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployees, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
