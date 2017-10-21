package noncom.just.fun.service;

import java.util.List;

import noncom.just.fun.dto.EmployeeDto;


public interface EmployeeService {
	
	EmployeeDto addEmployee(EmployeeDto employeeDto);                            // Create
	EmployeeDto getById(long id);                                                // Retrieve
	EmployeeDto updateEmployee(EmployeeDto employee, long employeeId);           // Update
    void delete(long id);                                                        // Delete
     
    List<EmployeeDto> getAllEmployees();                                         // Retrieve all
}
