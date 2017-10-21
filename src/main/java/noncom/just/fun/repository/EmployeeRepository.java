package noncom.just.fun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import noncom.just.fun.model.Employee;

/* Using the JPQL */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = "")
	Employee findById(long id);
	
	@Query(value = "select emp from Employee emp where emp.lastName = :lastName")
	Employee findByLastName(@Param("lastName")  String lastName);
	
	@Query(value = "select emp from Employee emp")
	List<Employee> getAllEmployees();

}
