package noncom.just.fun.serviceImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noncom.just.fun.dto.DepartmentDto;
import noncom.just.fun.dto.EmployeeDto;
import noncom.just.fun.model.Department;
import noncom.just.fun.model.Employee;
import noncom.just.fun.model.Order;
import noncom.just.fun.repository.EmployeeRepository;
import noncom.just.fun.service.EmployeeService;

@Service(value="emplSrv")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;	

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		
		Employee employee = new Employee();
		employee.setFirstName(employeeDto.getFirstName());
		employee.setMiddleName(employeeDto.getMiddleName());
		employee.setLastName(employeeDto.getLastName());      
		
		employee = employeeRepository.saveAndFlush(employee); //< added employee
		employeeDto.setId(employee.getId());                  //< set Id to DTO from added employee		
		
		return employeeDto;
	}
	
	@Override
	public EmployeeDto getById(long id) {
		
		EmployeeDto employeeDto = null;
		
		Employee employee = employeeRepository.findOne(id);		
		if (employee != null) {                              //< if not NULL than map entity to DTO and return it
			
			long employeeId = employee.getId();
			String fName = employee.getFirstName();
			String mName = employee.getMiddleName();
			String lName = employee.getLastName();
            Department dprtmnt = employee.getDepartment();
            Set<Order> orders = employee.getOrders();
			
			employeeDto = new EmployeeDto(employeeId, fName, mName, lName, dprtmnt, orders);
		}
		
		return employeeDto;		
	}
	
	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, long employeeId) {
		
		// from DTO to employee
		Employee employee = new Employee(employeeId,
				                         employeeDto.getFirstName(), 
				                         employeeDto.getMiddleName(), 
				                         employeeDto.getMiddleName());
		
		employee = employeeRepository.saveAndFlush(employee);
		
		return employeeDto;
	}

	@Override
	public void delete(long id) {
		employeeRepository.delete(id);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List<EmployeeDto> emplyeeDto = null;
		
		List<Employee> employees = employeeRepository.findAll();		
		if (employees != null) {
			emplyeeDto = employees.stream()
					              .map(empl -> new EmployeeDto(empl.getId(), 
					            		                       empl.getFirstName(),
					            		                       empl.getMiddleName(),
					            		                       empl.getLastName(),
					            		                       empl.getDepartment(),
					            		                       empl.getOrders()))
					              .collect(Collectors.toList());
		}
		
		return emplyeeDto;
	}
}
