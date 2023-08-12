package com.skateboard.data;

import com.skateboard.DTO.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcOrderRepository implements OrderRepository{

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Order> findAll() {
        return null;
    }

    @Override
    public Order findById(String id) {
        return null;
    }

    @Override
    public Order save(Order order) {
        return null;
    }

}
