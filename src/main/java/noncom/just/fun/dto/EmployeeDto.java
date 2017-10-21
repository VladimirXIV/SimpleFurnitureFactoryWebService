package noncom.just.fun.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import noncom.just.fun.jsonview.JsonViews;
import noncom.just.fun.model.Department;
import noncom.just.fun.model.Order;

public class EmployeeDto {
	
    private long id;
    
    @JsonView(JsonViews.EmployeeDtoInfo.class)
    private String firstName;
    
    @JsonView(JsonViews.EmployeeDtoInfo.class)
    private String middleName;
    
    @JsonView(JsonViews.EmployeeDtoInfo.class)
    private String lastName;
    
    private Department department;
    
    private Set<Order> orders;
	
    
    public EmployeeDto() {
		
	}

	public EmployeeDto(long id, String firstName, String middleName, String lastName, Department department,
			Set<Order> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.department = department;
		this.orders = orders;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + "]";
	}	
}
