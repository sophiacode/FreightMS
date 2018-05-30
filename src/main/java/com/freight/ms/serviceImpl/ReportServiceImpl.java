package com.freight.ms.serviceImpl;

import com.freight.ms.dao.ComplaintMapper;
import com.freight.ms.dao.ExchangeMapper;
import com.freight.ms.dao.OrderMapper;
import com.freight.ms.model.Report;
import com.freight.ms.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ComplaintMapper complaintMapper;

    @Autowired
    ExchangeMapper exchangeMapper;

    public Report getReport(String startTime, String endTime){
        Map<String, Object> map = new HashMap<>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);

        Report report = new Report();
        report.setOrderTotal(orderMapper.getTotal(map));
        report.setOrderProcess(orderMapper.getProcess(map));
        report.setOrderFinish(orderMapper.getFinish(map));
        report.setOrderCancel(orderMapper.getCancel(map));
        report.setPriceTotal(orderMapper.getPrice(map));
        report.setComplaintCount(complaintMapper.getCountByTime(map));
        report.setPointDriver(exchangeMapper.getDriverPoint(map));
        report.setPointConsignor(exchangeMapper.getConsignorPoint(map));

        return report;
    }



}
