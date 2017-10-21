package noncom.just.fun.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`Furniture`")
public class Furniture implements Serializable {
	
	private static final long serialVersionUID = -7622577764714125131L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "furniture_id")
	private long id;
	
	@Column(name = "furniture_name")
	private String name;
	
	@OneToMany(mappedBy = "furniture")
	private Set<Goods> goods;
	

	public Furniture() {

	}

	public Furniture(long id, String name) {
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

	@Override
	public String toString() {
		return "Furniture [id=" + id + ", name=" + name + "]";
	}
}
