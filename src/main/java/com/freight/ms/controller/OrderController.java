package com.freight.ms.controller;

import com.freight.ms.model.Consignor;
import com.freight.ms.model.Driver;
import com.freight.ms.service.ConsignorService;
import com.freight.ms.service.DriverService;
import com.freight.ms.service.OrderService;
import com.freight.ms.system.log.BusinessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/manage/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ConsignorService consignorService;

    @Autowired
    private DriverService driverService;

    @RequestMapping("")
    public String index(){
        return "/order/order.html";
    }

    @BusinessLog(operation = "查看订单列表")
    @RequestMapping(value = "/order_list")
    @ResponseBody
     public String getList(@RequestParam(value = "orderNo",required = false) String orderNo,
                           @RequestParam(value = "consignorName",required = false) String consignorName,
                           @RequestParam(value = "driverName",required = false) String driverName,
                           @RequestParam(value = "receiverName",required = false) String receiverName,
                           @RequestParam(value = "orderStatus",required = false) String orderStatus,
                           @RequestParam(value = "payStatus",required = false) String payStatus,
                           @RequestParam(value = "createStartTime",required = false) String createStartTime,
                           @RequestParam(value = "createEndTime",required = false) String createEndTime,
                           @RequestParam(value = "limit",required = false) Integer limit,
                           @RequestParam(value = "offset",required = false) Integer offset){
        if(limit == null){
            limit = 10;
        }
        if(offset == null){
            offset = 0;
        }

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("orderNo", orderNo);
        paramMap.put("receiverName", receiverName);
        paramMap.put("orderStatus", orderStatus);
        paramMap.put("payStatus", payStatus);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        if(consignorName != null){
            Consignor consignor = consignorService.findConsignorByName(consignorName);
            if(consignor != null){
                paramMap.put("consignorId", consignor.getId());
            }else{
                paramMap.put("consignorId", 0);
            }
        }else{
            paramMap.put("consignorId", null);
        }

        if(driverName != null){
            Driver driver = driverService.findDriverByName(driverName);
            if(driver != null){
                paramMap.put("driverId", driver.getId());
            }else{
                paramMap.put("driverId", 0);
            }
        }else{
            paramMap.put("driverId", null);
        }

        return orderService.findOrders(paramMap);
    }
}
