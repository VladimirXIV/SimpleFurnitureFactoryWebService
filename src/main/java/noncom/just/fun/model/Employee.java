package noncom.just.fun.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "`EMPLOYEES`")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "employee_fn", nullable = false)
    private String firstName;

    @Column(name = "employee_mn", nullable = false)
    private String middleName;

    @Column(name = "employee_ln", nullable = false)
    private String lastName;

    @JsonBackReference(value = "DptmntToEmpl")
    @ManyToOne
    @JoinColumn(name = "employee_department_id", nullable = false)
    private Department department;
    
    @JsonManagedReference(value = "EmplToOrder")
    @OneToMany(mappedBy = "employee")
    private Set<Order> orders;


    public Employee() {
    	
    }

	public Employee(long id, String firstName, String middleName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
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
        return "Employee [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
                + lastName + "]";
    }

}
