package com.skateboard.data;

import com.skateboard.DTO.Order;
import org.springframework.data.repository.CrudRepository;

//Order Repository가 할 일
public interface OrderRepository extends CrudRepository<Order, Long> {

}
