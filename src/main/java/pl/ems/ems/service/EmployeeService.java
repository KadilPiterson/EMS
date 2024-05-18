package pl.ems.ems.service;

import pl.ems.ems.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    Employee getEmployeeByUsername(String username);
    Employee getEmployeeByEmail(String email);
    List<Employee> getAllEmployees();
}
