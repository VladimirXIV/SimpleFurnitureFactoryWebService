package noncom.just.fun.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

@Entity
@Table(name="`ORDERS`")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long id;

    @Column(name = "order_name",  nullable = false)
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "order_date", nullable = false)
    private LocalDate date;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "order_final_date", nullable = false)
    private LocalDate  finalDate;

    @Column(name = "order_is_ready", nullable = false)
    private boolean isReady;

    @JsonBackReference(value = "EmplToOrder")
    @ManyToOne
    @JoinColumn(name = "order_employee_id", nullable = true)
    private Employee employee;

    @JsonBackReference(value = "DptmntToOrder")
    @ManyToOne
    @JoinColumn(name = "order_department_id", nullable = true)
    private Department department;
    
    @OneToMany(mappedBy = "")
    Set<Goods> goods;


    public Order() {
    	
    }

	public Order(long id, String name, LocalDate date, LocalDate finaleDate, boolean isReady) {
		super();
		this.id = id;
		this.name = name;
	    this.date = date;
		this.finalDate = finaleDate;
		this.isReady = isReady;
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
		return "Order [id=" + id + ", name=" + name + ", date=" + date + ", finalDate=" + finalDate + ", isReady="
				+ isReady + "]";
	}
}

