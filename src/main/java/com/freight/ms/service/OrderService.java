package com.freight.ms.service;

import com.freight.ms.model.Order;

import java.util.Map;

public interface OrderService {

    Order findOrderById(Integer id);

    Order findOrderByOrderNo(String orderNo);

    String findOrders(Map<String, Object> paramMap);


}
