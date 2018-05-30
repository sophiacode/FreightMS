package com.freight.ms.controller;

import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.Complaint;
import com.freight.ms.model.Order;
import com.freight.ms.model.User;
import com.freight.ms.service.ComplaintService;
import com.freight.ms.service.OrderService;
import com.freight.ms.service.UserService;
import com.freight.ms.system.log.BusinessLog;
import com.freight.ms.util.JsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private UserService userService;

    @RequiresPermissions("complaint:list")
    @BusinessLog(operation = "查看投诉列表")
    @RequestMapping("")
    public String index(){
        return "/complaint/complaint.html";
    }

    @RequiresPermissions("complaint:handle")
    @RequestMapping("/handle/{id}")
    public String handleView(@PathVariable Integer id, Model model){
        Complaint complaint = complaintService.findComplaintById(id);
        model.addAttribute("complaint", complaint);
        return "/complaint/complaint_handle.html";
    }

    @RequiresPermissions("complaint:list")
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

    @RequiresPermissions("complaint:handle")
    @BusinessLog(operation = "处理投诉")
    @RequestMapping("/complaint_handle")
    @ResponseBody
    public String handleComplaint(@RequestParam(value = "id") Integer id,
                                  @RequestParam(value = "process") String process){
        Integer userId = null;

        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.findUserByUsername(username);
        if(user != null){
            userId = user.getId();
        }

        complaintService.handleComplaint(id, process, userId);
        return SuccessJson.getJson("添加处理说明成功");
    }
}
