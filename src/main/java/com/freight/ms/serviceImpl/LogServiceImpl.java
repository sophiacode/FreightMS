package com.freight.ms.serviceImpl;

import com.freight.ms.dao.LogMapper;
import com.freight.ms.model.Log;
import com.freight.ms.service.LogService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.LogWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService{
    @Autowired
    private LogMapper logMapper;

    public Log findLogById(Integer id) {
        return logMapper.selectByPrimaryKey(id);
    }

    public String findLogs(Map<String, Object> paramMap){
        List<Log> logList = logMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(logMapper.getCount(paramMap),
                        new LogWrapper(logList).wrap());
    }

    public void addLog(Log log){
        try{
            logMapper.insertSelective(log);
        }catch (Exception e){
            //throw new BusinessException(BusinessEnumException.USER_ADD_FAIL);
            e.printStackTrace();
        }
    }
}
