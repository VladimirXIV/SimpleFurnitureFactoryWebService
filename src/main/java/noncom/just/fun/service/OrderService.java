package noncom.just.fun.service;

import java.util.List;

import noncom.just.fun.dto.ExpireTimeDto;
import noncom.just.fun.dto.OrderDto;
import noncom.just.fun.util.UndoneOrder;

public interface OrderService {
	
	OrderDto addOrder(OrderDto orderDto);                  // Create
	OrderDto getById(long id);                             // Retrieve
	OrderDto updateOrder(OrderDto order, long id);         // Update
    void delete(long id);                                  // Delete
     
    List<OrderDto> getAllOrders();                         // Retrieve all orders
    ExpireTimeDto getTimeToExpire(long id);                // Retrieve info about time to expire
    List<OrderDto> getOrdersByDprtmntId(long id);          // 
    List<OrderDto> getOrdersByEmplId(long id);             // 
    
    OrderDto setReadinessStatus(boolean isReady, long id); // Setting the status of order
    List<UndoneOrder> getUndoneOrders();                   //
}
