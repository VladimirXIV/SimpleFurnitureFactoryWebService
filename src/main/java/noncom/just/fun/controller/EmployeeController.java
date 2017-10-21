package noncom.just.fun.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import noncom.just.fun.dto.EmployeeDto;
import noncom.just.fun.jsonview.JsonViews;
import noncom.just.fun.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier(value = "emplSrv")
	EmployeeService employeeService;

	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
		
		logger.info("EmployeeController.addEmployee");
		
		if (employeeDto == null) {
			return new ResponseEntity<EmployeeDto>(HttpStatus.NOT_FOUND);
		}
		
		employeeDto = employeeService.addEmployee(employeeDto);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Department created  - ", String.valueOf(employeeDto.getId()));
		
		return new ResponseEntity<EmployeeDto>(employeeDto, httpHeaders, HttpStatus.CREATED);
	}
	
	@JsonView(JsonViews.EmployeeDtoInfo.class)
	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {
		
        logger.info("EmployeeController.getEmployeeById   id = {}", id);
		
        EmployeeDto demployeeDto = employeeService.getById(id);
		if (demployeeDto == null) {
			return new ResponseEntity<EmployeeDto>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<EmployeeDto>(demployeeDto, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id,
			                                          @RequestBody EmployeeDto employeeDto) {
        
		logger.info("EmployeeController.updateEmployee");
		
		if (employeeDto == null) {
			return new ResponseEntity<EmployeeDto>(HttpStatus.BAD_REQUEST);
		}
		
		EmployeeDto isExist = employeeService.getById(id);
		if (isExist == null) {
			return new ResponseEntity<EmployeeDto>(HttpStatus.NOT_FOUND);
		}
		
		employeeDto = employeeService.updateEmployee(employeeDto, id);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Employee updated  - ", String.valueOf(employeeDto));
		
		return new ResponseEntity<EmployeeDto>(employeeDto, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") long id) {

		logger.info("EmployeeController.deleteEmployeeById   id = {}", id);
		
		employeeService.delete(id);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Employee deleted - ", String.valueOf(id));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@JsonView(JsonViews.EmployeeDtoInfo.class)
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public  ResponseEntity<List<EmployeeDto>> getAllEmplyees() {

		logger.info("EmployeeController.getAllEmplyees");
		
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		
		if (employees == null) {
			return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Number Of Records Found", String.valueOf(employees.size()));
		
		return new ResponseEntity<List<EmployeeDto>>(employees, httpHeaders, HttpStatus.OK);
	}
}
