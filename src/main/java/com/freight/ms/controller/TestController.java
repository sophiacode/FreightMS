package com.freight.ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sophia on 2018/3/23.
 */

@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping("/manage")
    String login(){
        return "/log/log.html";
    }
}
