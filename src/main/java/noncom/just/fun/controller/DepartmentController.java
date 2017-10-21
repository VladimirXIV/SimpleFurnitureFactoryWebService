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

import noncom.just.fun.dto.DepartmentDto;
import noncom.just.fun.jsonview.JsonViews;
import noncom.just.fun.service.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier(value = "dprtmntSrv")
	DepartmentService departmentService;	
	
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
		
		logger.info("DepartmentController.addDepartment");
		
		if (departmentDto == null) {
			return new ResponseEntity<DepartmentDto>(HttpStatus.NOT_FOUND);
		}
		
		departmentDto = departmentService.addDepartment(departmentDto);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Department created  - ", String.valueOf(departmentDto.getId()));
		
		return new ResponseEntity<DepartmentDto>(departmentDto, httpHeaders, HttpStatus.CREATED);		
	}
	
	@JsonView(JsonViews.DepartmentDtoInfo.class)
	@RequestMapping(value = "/getDepartment/{id}", method = RequestMethod.GET)
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable long id) {
		
		logger.info("DepartmentController.getDepartmentById   id = {}", id);
		
		DepartmentDto departmentDto = departmentService.getById(id);
		if (departmentDto == null) {
			return new ResponseEntity<DepartmentDto>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateDepartment/{id}", method = RequestMethod.POST)
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable long id, 
			                                              @RequestBody DepartmentDto departmentDto) {
		
		logger.info("DepartmentController.updateDepartment");
		
		if (departmentDto == null) {
			return new ResponseEntity<DepartmentDto>(HttpStatus.BAD_REQUEST);
		}
		
		DepartmentDto isExist = departmentService.getById(id); 
		if (isExist == null) {
			return new ResponseEntity<DepartmentDto>(HttpStatus.NOT_FOUND);
		}
		
		departmentDto = departmentService.updateDepartment(departmentDto, id);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Department updated  - ", String.valueOf(departmentDto));
		
		return new ResponseEntity<DepartmentDto>(departmentDto, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteDepartment/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDepartmentById(@PathVariable("id") long id) {
		
		logger.info("DepartmentController.deleteDepartmentById   id = {}", id);
		
		departmentService.delete(id);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Department deleted - ", String.valueOf(id));
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@JsonView(JsonViews.DepartmentDtoInfo.class)
	@RequestMapping(value = "/getAllDepartments", method = RequestMethod.GET)
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {		
		
		logger.info("DepartmentController.getAllDepartments");
		
		List<DepartmentDto> departments = departmentService.getAllDepartments();
		
		if (departments == null) {
			return new ResponseEntity<List<DepartmentDto>>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Number Of Records Found", String.valueOf(departments.size()));
		
		return new ResponseEntity<List<DepartmentDto>>(departments, httpHeaders, HttpStatus.OK);
	}
	
}
