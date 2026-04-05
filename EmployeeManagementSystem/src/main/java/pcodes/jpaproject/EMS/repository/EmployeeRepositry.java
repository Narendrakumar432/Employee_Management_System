package pcodes.jpaproject.EMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pcodes.jpaproject.EMS.entity.Employee;

public interface EmployeeRepositry extends JpaRepository<Employee, Long>{
	  List<Employee> findByDepartment(String department);
}
