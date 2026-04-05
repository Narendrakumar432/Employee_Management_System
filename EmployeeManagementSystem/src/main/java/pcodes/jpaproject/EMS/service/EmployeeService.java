package pcodes.jpaproject.EMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcodes.jpaproject.EMS.entity.Employee;
import pcodes.jpaproject.EMS.model.EmployeeAddRequest;
import pcodes.jpaproject.EMS.model.EmployeeAddResponse;
import pcodes.jpaproject.EMS.repository.EmployeeRepositry;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepositry repository;
public EmployeeAddResponse addEmployee(EmployeeAddRequest request)
{
	Employee employee = new Employee();
	employee.setName(request.getName());
	employee.setDepartment(request.getDepartment());
	employee.setSalary(request.getSalary());
	
	Employee storedEmployee = repository.save(employee);
	return new EmployeeAddResponse(storedEmployee.getId(), storedEmployee.getName());
	
}
public List<Employee> getAllEmployee()
{
	return repository.findAll();
}
public EmployeeAddResponse getEmployee(Long id, Object other)
{
	if(id == null)
	{
		return null;
	}
	Employee dbemployee = repository.findById(id).orElse(null );
	return dbemployee !=null? new EmployeeAddResponse(dbemployee.getId(), dbemployee.getName()) : null;
}
public List<Employee> getAllEmployeesOfDepartment(String department) {
	// TODO Auto-generated method stub
	return repository.findByDepartment(department);
}
public Employee updateEmployee(EmployeeAddRequest request, Long id) {
	if(id == null || request == null) return null;
	
	Employee dbEmployee = repository.findById(id).orElseThrow(()->new IllegalArgumentException("No Employee found"));
	if( request.getName() !=null) dbEmployee.setName(request.getName());
	if( request.getDepartment() !=null) dbEmployee.setDepartment(request.getDepartment());
	if( request.getSalary() !=null) dbEmployee.setSalary(request.getSalary());
	
	return repository.save(dbEmployee);
}
public void removeEmployee(Long id) {
	// TODO Auto-generated method stub
	repository.deleteById(id);
}
public void removeAllEmployees() {
	// TODO Auto-generated method stub
	repository.deleteAll();
}
}
