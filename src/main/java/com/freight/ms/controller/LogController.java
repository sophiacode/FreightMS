package com.freight.ms.controller;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.model.Log;
import com.freight.ms.service.LogService;
import com.freight.ms.system.log.BusinessLog;
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
@RequestMapping("/manage/log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("")
    public String index(){
        return "/log/log.html";
    }

    @RequestMapping("/add")
    public String addView() {
        return "/log/log_add.html";
    }

    @RequestMapping("/edit/{id}")
    public String editView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        Log log = logService.findLogById(id);
        model.addAttribute(log);
        return "/log/log_edit.html";
    }

    @BusinessLog(operation = "查看日志列表")
    @RequestMapping(value = "/log_list")
    @ResponseBody
     public String getList(@RequestParam(value = "type",required = false) String type,
                           @RequestParam(value = "operation",required = false) String operation,
                           @RequestParam(value = "username",required = false) String username,
                           @RequestParam(value = "status",required = false) String status,
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
        paramMap.put("operation", operation);
        paramMap.put("username", username);
        paramMap.put("status", status);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        return logService.findLogs(paramMap);
    }
}
