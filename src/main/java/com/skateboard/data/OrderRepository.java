package com.skateboard.data;

import com.skateboard.DTO.Order;

//Order Repository가 할 일
public interface OrderRepository {
    Iterable<Order> findAll(); // Order에서 모든 값 가져오기
    Order findById(String id); // ID로 조회
    Order save(Order order); // 저장하기
}
