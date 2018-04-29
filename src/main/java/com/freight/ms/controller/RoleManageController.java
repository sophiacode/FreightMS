package com.freight.ms.controller;

import com.alibaba.fastjson.JSONObject;
import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.Operation;
import com.freight.ms.model.Role;
import com.freight.ms.service.OperationService;
import com.freight.ms.service.RoleService;
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

@Controller
@RequestMapping("/manage/role")
public class RoleManageController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private OperationService operationService;

    @RequestMapping("")
    public String index(){
        return "/role/role.html";
    }

    @RequestMapping("/add")
    public String addView() {
        return "/role/role_add.html";
    }

    @RequestMapping("/edit/{id}")
    public String editView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        Role role = roleService.findRoleById(id);
        model.addAttribute(role);
        return "/role/role_edit.html";
    }

    @RequestMapping("/permission/{id}")
    public String permissionView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        Role role = roleService.findRoleById(id);
        model.addAttribute(role);

        return "/role/role_permission.html";
    }

    @BusinessLog(operation = "查看角色列表")
    @RequestMapping(value = "/role_list")
    @ResponseBody
     public String getList(@RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "identifier",required = false) String identifier,
                           @RequestParam(value = "createStartTime", required = false) String createStartTime,
                           @RequestParam(value = "createEndTime", required = false) String createEndTime,
                           @RequestParam(value = "limit",required = false) Integer limit,
                           @RequestParam(value = "offset",required = false) Integer offset){
        if(limit == null){
            limit = 10;
        }
        if(offset == null){
            offset = 0;
        }

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name",name);
        paramMap.put("identifier",identifier);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        return roleService.findRoles(paramMap);
    }

    @BusinessLog(operation = "添加角色")
    @RequestMapping("/role_add")
    @ResponseBody
    public String addUser(@RequestParam(value = "name") String name,
                          @RequestParam(value = "identifier") String identifier,
                          @RequestParam(value = "description") String description,
                          @RequestParam(value = "permissions", required = false) List<Integer> permissions) throws BusinessException {
        Role role = new Role();
        role.setName(name);
        role.setIdentifier(identifier);
        role.setDescription(description);

        roleService.addRole(role, permissions);

        return SuccessJson.getJson("添加成功");
    }

    @BusinessLog(operation = "修改角色")
    @RequestMapping("/role_edit")
    @ResponseBody
    public String editRole(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "identifier") String identifier,
                           @RequestParam(value = "description") String description,
                           @RequestParam(value = "permissions", required = false) List<Integer> permissions) throws BusinessException{
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        role.setIdentifier(identifier);
        role.setDescription(description);

        roleService.editRole(role, permissions);

        return SuccessJson.getJson("修改成功");
    }

    @BusinessLog(operation = "删除角色")
    @RequestMapping("/role_delete")
    @ResponseBody
    public String deleteRole(@RequestParam(value="idArray") List<Integer> idArray)
            throws BusinessException{
        roleService.deleteRoles(idArray);
        return SuccessJson.getJson("删除成功");
    }

    @RequestMapping("/role_permission")
    @ResponseBody
    public String operationList(@RequestParam(value = "roleId") int roleId) throws BusinessException{
        JSONObject object = new JSONObject();

        List<Operation> all = operationService.getAll();
        object.put("all", all);

        Role role = roleService.findRoleById(roleId);
        List<Operation> checked = operationService.getOperationsOfRole(role);
        object.put("checked", checked);

        return object.toJSONString();
    }

    @RequestMapping("/change_permission")
    @ResponseBody
    public String changePermission(@RequestParam(value = "roleId") Integer roleId,
                                   @RequestParam(value = "idArray") List<Integer> idArray) throws BusinessException{
        operationService.updatePermissions(roleId, idArray);
        return SuccessJson.getJson("修改成功");
    }

}
