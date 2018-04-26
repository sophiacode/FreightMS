package com.freight.ms.controller;

import com.freight.ms.model.Order;
import com.freight.ms.service.ComplaintService;
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
@RequestMapping("/manage/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("")
    public String index(){
        return "/complaint/complaint.html";
    }

    @BusinessLog(operation = "查看投诉列表")
    @RequestMapping(value = "/complaint_list")
    @ResponseBody
     public String getList(@RequestParam(value = "orderNo",required = false) String orderNo,
                           @RequestParam(value = "type",required = false) Integer type,
                           @RequestParam(value = "status", required = false) Integer status,
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
        paramMap.put("type", type);
        paramMap.put("status", status);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        if(orderNo != null){
            Order order = orderService.findOrderByOrderNo(orderNo);
            if(order != null){
                paramMap.put("orderId", order.getId());
            }else{
                paramMap.put("orderId", 0);
            }
        }else{
            paramMap.put("orderId", null);
        }

        return complaintService.findComplaints(paramMap);
    }

    //TODO:处理投诉
}
