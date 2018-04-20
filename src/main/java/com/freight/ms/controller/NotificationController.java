package com.freight.ms.controller;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.Notification;
import com.freight.ms.model.User;
import com.freight.ms.service.NotificationService;
import com.freight.ms.service.UserService;
import com.freight.ms.system.log.BusinessLog;
import org.apache.shiro.SecurityUtils;
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
@RequestMapping("/manage/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String index(){
        return "/notification/notification.html";
    }

    @RequestMapping("/add")
    public String addView() {
        return "/notification/notification_add.html";
    }

    @RequestMapping("/edit/{id}")
    public String editView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        Notification notification = notificationService.findNotificationById(id);
        model.addAttribute(notification);
        return "/notification/notification_edit.html";
    }

    @BusinessLog(operation = "查看通知列表")
    @RequestMapping(value = "/notification_list")
    @ResponseBody
     public String getList(@RequestParam(value = "title", required = false) String title,
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
        paramMap.put("title", title);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        return notificationService.findNotifications(paramMap);
    }

    @BusinessLog(operation = "添加通知")
    @RequestMapping("/notification_add")
    @ResponseBody
    public String addUser(@RequestParam(value = "title") String title,
                          @RequestParam(value = "content", required = false) String content) throws BusinessException {
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setContent(content);

        String authorName = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.findUserByUsername(authorName);
        notification.setAuthorId(user.getId());

        notificationService.addNotification(notification);

        return SuccessJson.getJson("添加成功");
    }

    @BusinessLog(operation = "修改通知")
    @RequestMapping("/notification_edit")
    @ResponseBody
    public String editNotification(@RequestParam(value = "title") String title,
                                   @RequestParam(value = "content", required = false) String content) throws BusinessException{
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setContent(content);

        notificationService.editNotification(notification);

        return SuccessJson.getJson("修改成功");
    }

    @BusinessLog(operation = "删除通知")
    @RequestMapping("/notification_delete")
    @ResponseBody
    public String deleteNotification(@RequestParam(value="idArray") List<Integer> idArray)
            throws BusinessException{
        notificationService.deleteNotifications(idArray);
        return SuccessJson.getJson("删除成功");
    }
}
