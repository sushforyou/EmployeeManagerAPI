package dev.sushforyou.employeemanager.repo;

import dev.sushforyou.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{
    void deleteEmployeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
