package noncom.just.fun.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import noncom.just.fun.dto.ExpireTimeDto;
import noncom.just.fun.dto.OrderDto;
import noncom.just.fun.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier(value = "ordrSrv")
	OrderService orderService;
	
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {

		logger.info("EmployeeController.addEmployee");
		
		if (orderDto == null) {
			return new ResponseEntity<OrderDto>(HttpStatus.NOT_FOUND);
		}
		
		orderDto = orderService.addOrder(orderDto);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Order created  - ", String.valueOf(orderDto.getId()));
		
		return new ResponseEntity<OrderDto>(orderDto, httpHeaders, HttpStatus.CREATED);		
	}
	
	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderDto> getOrderById(@PathVariable long id) {
       
		logger.info("OrderController.getOrderById id = {}", id);
		
        OrderDto orderDto = orderService.getById(id);
		if (orderDto == null) {
			return new ResponseEntity<OrderDto>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateOrder/{id}", method = RequestMethod.PUT)
	public ResponseEntity<OrderDto> updateOrder(@PathVariable long id,
			                                    @RequestBody OrderDto orderDto) {
        
		logger.info("OrderController.updateOrder");
		
		if (orderDto == null) {
			return new ResponseEntity<OrderDto>(HttpStatus.BAD_REQUEST);
		}
		
		OrderDto isExist = orderService.getById(id);
		if (isExist == null) {
			return new ResponseEntity<OrderDto>(HttpStatus.NOT_FOUND);
		}
		
		orderDto = orderService.updateOrder(orderDto, id);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Order updated  - ", String.valueOf(orderDto));
		
		return new ResponseEntity<OrderDto>(orderDto, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") long id) {

		logger.info("OrderController.deleteEmployeeById   id = {}", id);
		
		orderService.delete(id);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Order deleted - ", String.valueOf(id));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDto>> getAllOrders() {
		
        logger.info("OrderController.getAllOrders");
		
		List<OrderDto> ordersDto = orderService.getAllOrders();		
		if (ordersDto == null) {
			return new ResponseEntity<List<OrderDto>>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Number Of Records Found", String.valueOf(ordersDto.size()));
		
		return new ResponseEntity<List<OrderDto>>(ordersDto, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrdersByDepartmentId/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDto>> getOrdersByDepartmentId(@PathVariable long id) {
		
		logger.info("OrderController.getOrdersByDepartmentId  employeeId = {}", id);
		
		List<OrderDto> ordersDto = orderService.getOrdersByDprtmntId(id);
		if (ordersDto == null) {
			return new ResponseEntity<List<OrderDto>>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Number Of Records Found", String.valueOf(ordersDto.size()));
		
		return new ResponseEntity<List<OrderDto>>(ordersDto, httpHeaders, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/getOrdersByEmplId/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDto>> getOrderByEmplId(@PathVariable long id) {
		
		logger.info("OrderController.getOrderByEmplId  employeeId = {}", id);
		
		List<OrderDto> ordersDto = orderService.getOrdersByEmplId(id);
		if (ordersDto == null) {
			return new ResponseEntity<List<OrderDto>>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Number Of Records Found", String.valueOf(ordersDto.size()));
		
		return new ResponseEntity<List<OrderDto>>(ordersDto, httpHeaders, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/getTimeToExpire/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExpireTimeDto> getTimeToExpire(@PathVariable long id) {
		
		logger.info("OrderController.getExpireTime  orderId = {}");
		
		ExpireTimeDto expireTime = orderService.getTimeToExpire(id);
		if (expireTime == null) {
			return new ResponseEntity<ExpireTimeDto>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Time to expire is found - ", "TRUE");
		
		return new ResponseEntity<ExpireTimeDto>(expireTime, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/setReadinessStatusAsReady/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderDto> setReadinessStatusAsReady(@PathVariable long id) {
		
		logger.info("OrderController.getExpireTime  orderId = {}");
		
		OrderDto orderDto = orderService.setReadinessStatus(true, id);
		
		if (orderDto == null) {
			return new ResponseEntity<OrderDto>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Order was updated - ", String.valueOf(orderDto));
		
		return new ResponseEntity<OrderDto>(orderDto, httpHeaders, HttpStatus.OK);		
	}
}
