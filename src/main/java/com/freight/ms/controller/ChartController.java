package com.freight.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.freight.ms.model.Report;
import com.freight.ms.service.ConsignorService;
import com.freight.ms.service.DriverService;
import com.freight.ms.service.ReportService;
import com.freight.ms.util.JsonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/manage/chart")
public class ChartController {
    @Autowired
    DriverService driverService;

    @Autowired
    ConsignorService consignorService;

    @Autowired
    ReportService reportService;

    @RequestMapping("/user")
    @RequiresPermissions("chart_register")
    public String userIndex() {
        return "/chart/user_chart.html";
    }

    @RequestMapping("/business")
    @RequiresPermissions("chart_business")
    public String businessIndex() {
        return  "/chart/business_chart.html";
    }

    @RequiresPermissions("chart_register")
    @RequestMapping("/yearLabels")
    @ResponseBody
    public String generateYearLabels() {
        List<String> list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 12; i++) {
            list.add(0, sdf.format(calendar.getTime()));
            calendar.add(Calendar.MONTH, -1);

        }
        return JSON.toJSONString(list);
    }

    @RequiresPermissions("chart_register")
    @RequestMapping("/userYearData")
    @ResponseBody
    public String generateUserYearData(@RequestParam(value = "userType") String userType) {
        List<Long> data = new ArrayList<>();

        String startTime, endTime;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 12; i++) {
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            startTime = sdf.format(calendar.getTime());

            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endTime = sdf.format(calendar.getTime());
            if (userType.equals("Driver")) {
                data.add(0, (long) driverService.getCountByTime(startTime, endTime));
            } else if (userType.equals("Consignor")) {
                data.add(0, (long) consignorService.getCountByTime(startTime, endTime));
            }

            calendar.add(Calendar.MONTH, -1);
        }

        return JSON.toJSONString(data);
    }

    @RequiresPermissions("chart_register")
    @RequestMapping("/monthLabels")
    @ResponseBody
    public String generateMonthLabels() {
        List<String> list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i <= 30; i++) {
            list.add(0, sdf.format(calendar.getTime()));
            calendar.add(Calendar.DATE, -1);
        }
        return JSON.toJSONString(list);
    }

    @RequiresPermissions("chart_register")
    @RequestMapping("/userMonthData")
    @ResponseBody
    public String generateUserMonthData(@RequestParam(value = "userType") String userType) {
        List<Long> data = new ArrayList<>();

        List<String> days = JSON.parseArray(generateMonthLabels(), String.class);

        for (String day : days) {
            if (userType.equals("Driver")) {
                data.add(0, (long) driverService.getCountByTime(day, day));
            } else if (userType.equals("Consignor")) {
                data.add(0, (long) consignorService.getCountByTime(day, day));
            }
        }

        return JSON.toJSONString(data);
    }

    @RequiresPermissions("chart_business")
    @RequestMapping("/report")
    @ResponseBody
    public String generateReport(@RequestParam(value = "startTime", required = false) String startTime,
                                @RequestParam(value = "endTime", required = false) String endTime){
        Report report = reportService.getReport(startTime, endTime);
        List<Report> list = new ArrayList<>();
        list.add(report);

        JSONObject object = new JSONObject();
        object.put("total", 1);
        object.put("rows", list);

        return object.toJSONString();
    }
}
