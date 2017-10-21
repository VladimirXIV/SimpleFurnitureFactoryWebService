package noncom.just.fun.model;

import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "`DEPARTMENTS`")
public class Department {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private long id;

    @Column(name = "department_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
   
    @OneToMany(mappedBy = "department")
    private Set<Order> orders;
    

    public Department() {
    }

	public Department(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
