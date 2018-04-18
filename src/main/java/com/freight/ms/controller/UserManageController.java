package com.freight.ms.controller;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.User;
import com.freight.ms.service.RoleService;
import com.freight.ms.service.UserService;
import com.freight.ms.system.log.BusinessLog;
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

/**
 * Created by wyq on 2018/4/2.
 */

@Controller
@RequestMapping("/manage/user")
public class UserManageController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("")
    public String index(){
        return "/user/user.html";
    }

    @RequestMapping("/add")
    public String addView() {
        return "/user/user_add.html";
    }

    @RequestMapping("/edit/{id}")
    public String editView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        User user = userService.findUserById(id);
        model.addAttribute(user);
        return "/user/user_edit.html";
    }

    @RequestMapping("/role/{id}")
    public String setRoleView(@PathVariable Integer id, Model model){
        model.addAttribute("user_id", id);
        model.addAttribute("roleList", roleService.getAllRole());
        return "/user/user_role.html";
    }

    @BusinessLog(operation = "查看用户列表")
    @RequestMapping(value = "/user_list")
    @ResponseBody
     public String getList(@RequestParam(value = "username",required = false) String username,
                          @RequestParam(value = "name",required = false) String name,
                          @RequestParam(value = "sex",required = false) String sex,
                          @RequestParam(value = "age",required = false) String age,
                          @RequestParam(value = "telephone",required = false) String telephone,
                          @RequestParam(value = "status",required = false) String status,
                          @RequestParam(value = "type",required = false) String type,
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
        paramMap.put("username",username);
        paramMap.put("name",name);
        paramMap.put("sex", sex);
        paramMap.put("age", age);
        paramMap.put("telephone", telephone);
        paramMap.put("status", status);
        paramMap.put("type", type);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        return userService.findUsers(paramMap);
    }

    @BusinessLog(operation = "添加用户")
    @RequestMapping("/user_add")
    @ResponseBody
    public String addUser(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "sex", required = false) Integer sex,
                          @RequestParam(value = "age", required = false) Integer age,
                          @RequestParam(value = "telephone", required = false) String telephone,
                          @RequestParam(value = "type") Integer type) throws BusinessException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        user.setTelephone(telephone);
        user.setType(type);
        user.setStatus(0);

        userService.addUser(user);

        return SuccessJson.getJson("添加成功");
    }

    @BusinessLog(operation = "修改用户资料")
    @RequestMapping("/user_edit")
    @ResponseBody
    public String editUser(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "new_password", required = false) String password,
                           @RequestParam(value = "sex", required = false) Integer sex,
                           @RequestParam(value = "age", required = false) Integer age,
                           @RequestParam(value = "telephone", required = false) String telephone,
                           @RequestParam(value = "type", required = false) Integer type) throws BusinessException{
        User user = new User();

        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setSex(sex);
        user.setAge(age);
        user.setTelephone(telephone);
        user.setType(type);

        userService.editUser(user);

        return SuccessJson.getJson("修改成功");
    }

    @BusinessLog(operation = "删除用户")
    @RequestMapping("/user_delete")
    @ResponseBody
    public String deleteUser(@RequestParam(value="idArray")List<Integer> idArray)
            throws BusinessException{
        userService.deleteUsers(idArray);
        return SuccessJson.getJson("删除成功");
    }

    @BusinessLog(operation = "修改用户状态")
    @RequestMapping("/user_status")
    @ResponseBody
    public String changeStatus(@RequestParam(value="idArray") List<Integer> idArray)
        throws BusinessException{
        userService.changeStatus(idArray);
        return SuccessJson.getJson("修改状态成功");
    }

    @BusinessLog(operation = "分配角色")
    @RequestMapping("/user_role")
    @ResponseBody
    public String setRole(@RequestParam(value="user_id") Integer userId,
                          @RequestParam(value="role_id") Integer roleId )
            throws BusinessException{
        userService.setRole(userId, roleId);
        return SuccessJson.getJson("分配角色成功");
    }
}
