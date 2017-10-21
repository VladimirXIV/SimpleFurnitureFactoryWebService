package noncom.just.fun.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import noncom.just.fun.jsonview.JsonViews;
import noncom.just.fun.model.Employee;
import noncom.just.fun.model.Order;

public class DepartmentDto {
	
	private long id;
	
	@JsonView(JsonViews.DepartmentDtoInfo.class)
	private String name;
	
	private Set<Employee> employees;
	
	private Set<Order> orders;
	
	
	public DepartmentDto(long id, String name, Set<Employee> employees, Set<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
		this.orders = orders;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "DepartmentDto [id=" + id + ", name=" + name + ", employees=" + employees + ", orders=" + orders + "]";
	}
}
