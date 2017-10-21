package noncom.just.fun.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`GOODS`")
public class Goods implements Serializable {
	
	private static final long serialVersionUID = -1621684174171869520L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "good_id")
	private long id;
	
	@Column(name = "good_quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "good_order_id", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "good_furniture_id", nullable = false)
	private Furniture furniture;

	
	public Goods() {
		
	}

	public Goods(long id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", quantity=" + quantity + ", order=" + order + ", furniture=" + furniture + "]";
	}
}
