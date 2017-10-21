package noncom.just.fun.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noncom.just.fun.dto.ExpireTimeDto;
import noncom.just.fun.dto.OrderDto;
import noncom.just.fun.model.Order;
import noncom.just.fun.repository.OrderRepository;
import noncom.just.fun.service.OrderService;
import noncom.just.fun.util.AppHelper;
import noncom.just.fun.util.UndoneOrder;

@Service(value = "ordrSrv")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	
	@Override
	public OrderDto addOrder(OrderDto orderDto) {
		
		Order order = new Order();
		order.setName(order.getName());
		order.setDate(orderDto.getDate());
		order.setFinalDate(order.getFinalDate());
		order.setReady(order.isReady());
		
		order = orderRepository.saveAndFlush(order); //< added order
		orderDto.setId(order.getId());
		
		return orderDto;
	}
	
	@Override
	public OrderDto getById(long id) {
		
		OrderDto orderDto = null;
		
		Order order = orderRepository.findOne(id);
		if (order != null) {
			/* from entity to DTO */
			orderDto = new OrderDto(order.getId(), 
					                order.getName(), 
					                order.getDate(), 
					                order.getFinalDate(), 
					                order.isReady(), 
					                order.getEmployee(), 
					                order.getDepartment());
			
		}
		
		return orderDto;
	}
	
	@Override
	public OrderDto updateOrder(OrderDto orderDto, long id) {
		
		Order order = new Order(id, 
				                orderDto.getName(), 
				                orderDto.getDate(), 
				                orderDto.getFinalDate(), 
				                orderDto.isReady());
		
		order = orderRepository.saveAndFlush(order);
		return orderDto;
	}

	@Override
	public void delete(long id) {
		orderRepository.delete(id);
	}
	
	@Override
	public List<OrderDto> getAllOrders() {
		
		List<OrderDto> ordersDto = null;
		
		List<Order> orders = orderRepository.findAll();
		if (orders != null) {
			
			ordersDto = orders.stream()
		                   .map(order -> new OrderDto(order.getId(),
		                		                      order.getName(),
		                		                      order.getDate(),
		                		                      order.getFinalDate(),
		                		                      order.isReady(),
		                		                      order.getEmployee(),
		                		                      order.getDepartment()))
		                   .collect(Collectors.toList());
        }
		
		return ordersDto;		
	}
	
	@Override
	public List<OrderDto> getOrdersByDprtmntId(long id) {
		
        List<OrderDto> ordersDto = null;
		
		List<Order> orders = orderRepository.findByDepartment_Id(id);
		if (orders != null) {
			
			ordersDto = orders.stream()
		                   .map(order -> new OrderDto(order.getId(),
		                		                      order.getName(),
		                		                      order.getDate(),
		                		                      order.getFinalDate(),
		                		                      order.isReady(),
		                		                      order.getEmployee(),
		                		                      order.getDepartment()))
		                   .collect(Collectors.toList());
        }
		
		return ordersDto;
		
	}
	
	@Override
	public List<OrderDto> getOrdersByEmplId(long id) {
		
        List<OrderDto> ordersDto = null;
		
		List<Order> orders = orderRepository.findByEmployee_Id(id);
		if (orders != null) {
			
			ordersDto = orders.stream()
		                   .map(order -> new OrderDto(order.getId(),
		                		                      order.getName(),
		                		                      order.getDate(),
		                		                      order.getFinalDate(),
		                		                      order.isReady(),
		                		                      order.getEmployee(),
		                		                      order.getDepartment()))
		                   .collect(Collectors.toList());
        }
		
		return ordersDto;		
	}
	
	@Override
	public ExpireTimeDto getTimeToExpire(long id) {
		
		ExpireTimeDto expireTime = null;
		Order order = orderRepository.findOne(id);
		
		if (order != null) {			
			expireTime = AppHelper.getDaysToExpireDate(order);
		}
		
		return expireTime;
	}
	
	@Override
	public OrderDto setReadinessStatus(boolean isReady, long id) {
		
		OrderDto orderDto = null;
		Order order = orderRepository.getOne(id);
		
		if (order != null) {
			
		    order.setReady(isReady);		
		    orderRepository.saveAndFlush(order);
		    
		    orderDto = new OrderDto(id, 
		    		                order.getName(), 
		    		                order.getDate(), 
		    		                order.getFinalDate(), 
		    		                order.isReady(), 
		    		                order.getEmployee(), 
		    		                order.getDepartment());
		}
		
		return orderDto;
	}
	
	@Override
	public List<UndoneOrder> getUndoneOrders() {
		// TODO Auto-generated method stub
		return null;
	}
}
