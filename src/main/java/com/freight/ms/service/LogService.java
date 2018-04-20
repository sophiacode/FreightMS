package com.freight.ms.service;

import com.freight.ms.model.Log;

import java.util.Map;

public interface LogService {
    Log findLogById(Integer id);

    String findLogs(Map<String, Object> paramMap);

    void addLog(Log log);
}
