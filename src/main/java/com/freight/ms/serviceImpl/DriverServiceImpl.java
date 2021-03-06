package com.freight.ms.serviceImpl;

import com.freight.ms.common.constant.DriverEnum;
import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.DriverMapper;
import com.freight.ms.model.Driver;
import com.freight.ms.service.DriverService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.DriverWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverMapper driverMapper;

    public Driver findDriverById(Integer id) {
        return driverMapper.selectByPrimaryKey(id);
    }

    public Driver findDriverByName(String name) {
        return driverMapper.selectByName(name);
    }

    public String findDrivers(Map<String, Object> paramMap){
        List<Driver> driverList = driverMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(driverMapper.getCount(paramMap),
                new DriverWrapper(driverList).wrap());
    }

    public void changeStatus(List<Integer> list){
        List<Driver> drivers = new ArrayList<>();

        for(Integer id:list){
            Driver driver = driverMapper.selectByPrimaryKey(id);

            if(driver.getStatus() == DriverEnum.DRIVER_STATUS_OK.getCode()){
                driver.setStatus(DriverEnum.DRIVER_STATUS_FREEZE.getCode());
            }else{
                driver.setStatus(DriverEnum.DRIVER_STATUS_OK.getCode());
            }
            drivers.add(driver);
        }

        try{
            for(Driver driver:drivers){
                driverMapper.updateByPrimaryKey(driver);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.DRIVER_CHANGE_STATUS_FAIL);
        }
    }

    public void changeAuthState(Integer id, Integer authState){
        try{
            Driver driver = driverMapper.selectByPrimaryKey(id);
            driver.setAuthState(authState);
            driverMapper.updateByPrimaryKey(driver);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.DRIVER_AUTH_FAIL);
        }
    }

    public int getCountByTime(String start, String end){
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);

        return driverMapper.getCountByTime(map);
    }
}
