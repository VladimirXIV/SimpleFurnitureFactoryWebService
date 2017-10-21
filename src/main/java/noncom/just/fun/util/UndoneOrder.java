package noncom.just.fun.util;

import noncom.just.fun.model.Department;
import noncom.just.fun.model.Employee;
import noncom.just.fun.model.Order;

public class UndoneOrder {
	
	Order order;
	Employee employee;
	Department department;
	
	public UndoneOrder(Order order, Department department) {
		super();
		this.order = order;
		this.department = department;
	}
	
	public UndoneOrder(Order order, Employee employee) {
		super();
		this.order = order;
		this.employee = employee;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
