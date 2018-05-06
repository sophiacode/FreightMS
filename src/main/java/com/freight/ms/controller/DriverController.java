package com.freight.ms.controller;

import com.freight.ms.common.constant.ConstantFactory;
import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.Driver;
import com.freight.ms.service.DriverService;
import com.freight.ms.system.log.BusinessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @RequestMapping("")
    public String index(){
        return "/driver/driver.html";
    }

    @RequestMapping("/auth/{id}")
    public String authView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        Driver driver = driverService.findDriverById(id);
        driver.setAuthStateStr(ConstantFactory.getDriverAuthState(driver.getAuthState()));
        model.addAttribute(driver);
        return "/driver/driver_auth.html";
    }

    @BusinessLog(operation = "查看车主用户列表")
    @RequestMapping(value = "/driver_list")
    @ResponseBody
     public String getList(@RequestParam(value = "telephone",required = false) String telephone,
                           @RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "status",required = false) Integer status,
                           @RequestParam(value = "authState",required = false) Integer authState,
                           @RequestParam(value = "onlineState",required = false) Integer onlineState,
                           @RequestParam(value = "workState",required = false) Integer workState,
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
        paramMap.put("name", name);
        paramMap.put("status", status);
        paramMap.put("authState", authState);
        paramMap.put("onlineState", onlineState);
        paramMap.put("workState", workState);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        return driverService.findDrivers(paramMap);
    }

    @BusinessLog(operation = "修改车主用户状态")
    @RequestMapping("/driver_status")
    @ResponseBody
    public String changeStatus(@RequestParam(value="idArray") List<Integer> idArray)
            throws BusinessException{
        driverService.changeStatus(idArray);
        return SuccessJson.getJson("修改状态成功");
    }

    @BusinessLog(operation = "修改车主认证状态")
    @RequestMapping("/driver_auth")
    @ResponseBody
    public String changeAuthState(@RequestParam(value="id") Integer id,
                                  @RequestParam(value="authState") Integer authState)
            throws BusinessException{
        driverService.changeAuthState(id, authState);
        return SuccessJson.getJson("修改认证状态成功");
    }


}
