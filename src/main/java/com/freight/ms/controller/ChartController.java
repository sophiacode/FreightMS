package com.freight.ms.controller;

import com.alibaba.fastjson.JSON;
import com.freight.ms.service.ConsignorService;
import com.freight.ms.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Sophia on 2018/5/26.
 */

@Controller
@RequestMapping("/manage/chart")
public class ChartController {
    @Autowired
    DriverService driverService;

    @Autowired
    ConsignorService consignorService;

    @RequestMapping("/user")
    public String userIndex() {
        return "/chart/user_chart.html";
    }

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
}
