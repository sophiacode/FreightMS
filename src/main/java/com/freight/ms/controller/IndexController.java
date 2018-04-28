package com.freight.ms.controller;

import com.freight.ms.model.Notification;
import com.freight.ms.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wyq on 2018/4/28.
 */

@Controller
@RequestMapping("/manage")
public class IndexController {
    @Autowired
    NotificationService notificationService;

    @RequestMapping("")
    public String index(Model model) {
        List<Notification> list = notificationService.findAll();
        model.addAttribute("notificationList", list);

        return "/index.html";
    }
}
