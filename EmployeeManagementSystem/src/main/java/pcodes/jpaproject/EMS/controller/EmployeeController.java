package pcodes.jpaproject.EMS.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pcodes.jpaproject.EMS.entity.Employee;
import pcodes.jpaproject.EMS.model.EmployeeAddRequest;
import pcodes.jpaproject.EMS.model.EmployeeAddResponse;
import pcodes.jpaproject.EMS.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Check server
    @GetMapping("/check")
    public String check() {
        return "Server is running";
    }

    // Add employee
    @PostMapping("/add")
    public EmployeeAddResponse addEmployee(@RequestBody EmployeeAddRequest data) {
        return service.addEmployee(data);
    }

    // Get all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return service.getAllEmployee();
    }

    // Get by ID
    @GetMapping("/id/{id}")
    public EmployeeAddResponse getEmployeebyId(@PathVariable Long id) {
        return service.getEmployee(id, id);
    }

    // Get by Department
    @GetMapping("/dept/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return service.getAllEmployeesOfDepartment(department);
    }

    // Update employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody EmployeeAddRequest request, 
                                   @PathVariable Long id) {
        return service.updateEmployee(request, id);
    }

    // Delete by ID
    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteEmployee(@PathVariable Long id) {
        service.removeEmployee(id);
        return Map.of("status", "Employee has been deleted");
    }

    // Delete all
    @DeleteMapping("/delete/all")
    public Map<String, String> deleteAllEmployees() {
        service.removeAllEmployees();
        return Map.of("status", "All Employees has been deleted");
    }
}