package noncom.just.fun.dto;

import org.joda.time.LocalDate;
import noncom.just.fun.model.Department;
import noncom.just.fun.model.Employee;

public class OrderDto {

    private long id;

    private String name;

    private LocalDate date;

    private LocalDate  finalDate;

    private boolean isReady;

    private Employee employee;

    private Department department;
    

	public OrderDto() {
		
	}	
	
	public OrderDto(long id, String name, LocalDate date, LocalDate finalDate, boolean isReady, Employee employee,
			Department department) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.finalDate = finalDate;
		this.isReady = isReady;
		this.employee = employee;
		this.department = department;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
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
	

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", name=" + name + ", date=" + date + ", finalDate=" + finalDate + ", isReady="
				+ isReady + "]";
	}
}
