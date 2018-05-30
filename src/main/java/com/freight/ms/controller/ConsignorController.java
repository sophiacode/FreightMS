package com.freight.ms.controller;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.Consignor;
import com.freight.ms.service.ConsignorService;
import com.freight.ms.system.log.BusinessLog;
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
import java.util.List;

@Controller
@RequestMapping("/manage/consignor")
public class ConsignorController {
    @Autowired
    private ConsignorService consignorService;

    @RequiresPermissions("consignor:list")
    @BusinessLog(operation = "查看货主用户列表")
    @RequestMapping("")
    public String index(){
        return "/consignor/consignor.html";
    }

    @RequiresPermissions("consignor:list")
    @RequestMapping(value = "/consignor_list")
    @ResponseBody
     public String getList(@RequestParam(value = "telephone",required = false) String telephone,
                           @RequestParam(value = "status",required = false) Integer status,
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
        paramMap.put("telephone", telephone);
        paramMap.put("status", status);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        return consignorService.findConsignors(paramMap);
    }

    @RequiresPermissions("consignor:change_status")
    @BusinessLog(operation = "修改货主用户状态")
    @RequestMapping("/consignor_status")
    @ResponseBody
    public String changeStatus(@RequestParam(value="idArray") List<Integer> idArray)
            throws BusinessException{
        consignorService.changeStatus(idArray);
        return SuccessJson.getJson("修改状态成功");
    }
}
