package com.freight.ms.serviceImpl;

import com.freight.ms.dao.LogMapper;
import com.freight.ms.model.Log;
import com.freight.ms.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wyq on 2018/4/17.
 */

@Service("LogService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    public void addLog(Log log){
        try{
            logMapper.insert(log);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
