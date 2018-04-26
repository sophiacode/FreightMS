package com.freight.ms.controller;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.Activity;
import com.freight.ms.model.User;
import com.freight.ms.service.ActivityService;
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
@RequestMapping("/manage/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String index(){
        return "/activity/activity.html";
    }

    @RequestMapping("/add")
    public String addView() {
        return "/activity/activity_add.html";
    }

    @RequestMapping("/edit/{id}")
    public String editView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        Activity activity = activityService.findActivityById(id);
        model.addAttribute(activity);
        return "/activity/activity_edit.html";
    }

    @BusinessLog(operation = "查看活动列表")
    @RequestMapping(value = "/activity_list")
    @ResponseBody
     public String getList(@RequestParam(value = "title",required = false) String title,
                           @RequestParam(value = "authorName",required = false) String authorName,
                           @RequestParam(value = "status",required = false) Integer status,
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
        paramMap.put("status", status);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        if(authorName != null){
            User user = userService.findUserByUsername(authorName);
            if(user != null){
                paramMap.put("authorId", user.getId());
            }else{
                paramMap.put("authorId", 0);
            }
        }else{
            paramMap.put("authorId", 0);
        }

        return activityService.findActivitys(paramMap);
    }

    @BusinessLog(operation = "添加活动")
    @RequestMapping("/activity_add")
    @ResponseBody
    public String addActivity(@RequestParam(value = "title") String title,
                              @RequestParam(value = "content",required = false) String content,
                              @RequestParam(value = "banner",required = false) String banner,
                              @RequestParam(value = "status") Integer status) throws BusinessException { //TODO：具体参数
        Activity activity = new Activity();
        activity.setTitle(title);
        activity.setContent(content);
        activity.setBanner(banner);
        activity.setStatus(status);

        String authorName = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.findUserByUsername(authorName);
        if(user != null){
            activity.setAuthorId(user.getId());
        }

        activityService.addActivity(activity);

        return SuccessJson.getJson("添加成功");
    }

    @BusinessLog(operation = "修改活动")
    @RequestMapping("/activity_edit")
    @ResponseBody
    public String editActivity(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "title") String title,
                               @RequestParam(value = "content",required = false) String content,
                               @RequestParam(value = "banner",required = false) String banner,
                               @RequestParam(value = "status") Integer status) throws BusinessException{
        Activity activity = new Activity();
        activity.setId(id);
        activity.setTitle(title);
        activity.setContent(content);
        activity.setBanner(banner);
        activity.setStatus(status);

        activityService.editActivity(activity);

        return SuccessJson.getJson("修改成功");
    }

    @BusinessLog(operation = "删除活动")
    @RequestMapping("/activity_delete")
    @ResponseBody
    public String deleteActivity(@RequestParam(value="idArray") List<Integer> idArray)
            throws BusinessException{
        activityService.deleteActivitys(idArray);
        return SuccessJson.getJson("删除成功");
    }
}
