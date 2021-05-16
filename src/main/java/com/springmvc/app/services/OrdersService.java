package com.springmvc.app.services;

import com.springmvc.app.domain.Orders;
import com.springmvc.app.repos.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public List<Orders> getAllOrdersRecords() {
        List<Orders> ordersList = ordersRepository.findAll();
        return ordersList;
    }

    public void saveOrderIntoDB(Orders order) {
        this.ordersRepository.save(order);
    }
}
