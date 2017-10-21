package noncom.just.fun.serviceImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import noncom.just.fun.dto.DepartmentDto;
import noncom.just.fun.model.Department;
import noncom.just.fun.model.Employee;
import noncom.just.fun.model.Order;
import noncom.just.fun.repository.DepartamentRepository;
import noncom.just.fun.service.DepartmentService;


@Service(value = "dprtmntSrv")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	@Qualifier(value = "dprtmntRepo")
	DepartamentRepository departmentRepo;

	
	@Override
	public DepartmentDto addDepartment(DepartmentDto departmentDto) {
		
		Department department = new Department();
		department.setName(departmentDto.getName());
		
		department = departmentRepo.saveAndFlush(department); //< added  department
		departmentDto.setId(department.getId());              //< set id to DTO from added department
		
		return departmentDto;
	}
	
	
	@Override
	public DepartmentDto getById(long id) {
		
		DepartmentDto departmentDto = null;
		
		Department department = departmentRepo.findOne(id);		
		if (department != null) {                              //< if not NULL than map entity to DTO and return it
			
			long departmentId = department.getId();
			String departmentName = department.getName();
			Set<Employee> departmentEmployees = department.getEmployees();
			Set<Order> departmentOrders = department.getOrders();
			
			departmentDto = new DepartmentDto(departmentId, departmentName, departmentEmployees, departmentOrders);
		}
		
		return departmentDto;
	}
	
	@Override
	public DepartmentDto updateDepartment(DepartmentDto departmentDto, long id) {
		
		Department department = new Department(id, departmentDto.getName()); //< from DTO to entity		
		department = departmentRepo.saveAndFlush(department);
		
		return departmentDto;
	}
	
	@Override
	public void delete(long id) {
		departmentRepo.delete(id);
	}	
	
	@Override
	public List<DepartmentDto> getAllDepartments() {
		
		List<DepartmentDto> departmentsDto = null;
		
		List<Department> departments = departmentRepo.findAll();		
		if (departments != null) {
			departmentsDto = departments.stream()
					                    .map(dprtmnt -> new DepartmentDto(dprtmnt.getId(), 
					                        		                      dprtmnt.getName(), 
					                        		                      dprtmnt.getEmployees(), 
					                        		                      dprtmnt.getOrders()))
					                    .collect(Collectors.toList());
		}
		
		return departmentsDto;
	}
}
