package noncom.just.fun.service;

import java.util.List;

import noncom.just.fun.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto addDepartment(DepartmentDto departmentDto);                    // Create
	DepartmentDto getById(long id);                                              // Retrieve
	DepartmentDto updateDepartment(DepartmentDto departmentDto, long dprtmntId); // Update
    void delete(long id);                                                        // Delete --- ?
    
    List<DepartmentDto> getAllDepartments();                                     // Retrieve all
    
}