package noncom.just.fun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import noncom.just.fun.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByEmployee_Id(long id);       //< retrieve all orders via employee's ID
	
	List<Order> findByDepartment_Id(long id);     //< retrieve all orders via department's ID
	
	List<Order> findByIsReady(boolean isReady);   //< retrieve all unfinished orders

}
