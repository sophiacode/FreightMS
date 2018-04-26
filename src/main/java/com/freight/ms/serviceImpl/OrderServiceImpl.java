package com.freight.ms.serviceImpl;

import com.freight.ms.dao.OrderMapper;
import com.freight.ms.model.Order;
import com.freight.ms.service.OrderService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    public Order findOrderById(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    public Order findOrderByOrderNo(String orderNo){
        return orderMapper.selectByOrderNo(orderNo);
    }

    public String findOrders(Map<String, Object> paramMap){
        List<Order> orderList = orderMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(orderMapper.getCount(),
                        new OrderWrapper(orderList).wrap());
    }
}
