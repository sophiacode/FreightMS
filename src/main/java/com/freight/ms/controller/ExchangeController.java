package com.freight.ms.controller;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.Goods;
import com.freight.ms.service.GoodsService;
import com.freight.ms.system.log.BusinessLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller
@RequestMapping("/manage/goods")
public class ExchangeController {
    @Autowired
    private GoodsService goodsService;

    @RequiresPermissions("goods:list")
    @BusinessLog(operation = "查看积分物品列表")
    @RequestMapping("")
    public String index(){
        return "/goods/goods.html";
    }

    @RequiresPermissions("goods:add")
    @RequestMapping("/add")
    public String addView() {
        return "/goods/goods_add.html";
    }

    @RequiresPermissions("goods:edit")
    @RequestMapping("/edit/{id}")
    public String editView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        Goods goods = goodsService.findGoodsById(id);
        model.addAttribute(goods);
        return "/goods/goods_edit.html";
    }

    @RequiresPermissions("goods:exchange_record")
    @RequestMapping("/exchange/{id}")
    public String exchangeView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        Goods goods = goodsService.findGoodsById(id);
        model.addAttribute(goods);
        return "/goods/goods_exchange.html";
    }

    @RequiresPermissions("goods:list")
    @RequestMapping(value = "/goods_list")
    @ResponseBody
     public String getList(@RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "pointStart",required = false) String pointStart,
                           @RequestParam(value = "pointEnd",required = false) String pointEnd,
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
        paramMap.put("name", name);
        paramMap.put("pointStart", pointStart);
        paramMap.put("pointEnd", pointEnd);
        paramMap.put("status", status);
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        return goodsService.findGoods(paramMap);
    }

    @RequiresPermissions("goods:add")
    @BusinessLog(operation = "添加积分物品")
    @RequestMapping("/goods_add")
    @ResponseBody
    public String addUser(@RequestParam(value = "name",required = false) String name,
                          @RequestParam(value = "point",required = false) Integer point,
                          @RequestParam(value = "status",required = false) Integer status) throws BusinessException { //TODO：具体参数
        Goods goods = new Goods();
        goods.setName(name);
        goods.setPoint(point);
        goods.setStatus(status);

        goodsService.addGoods(goods);

        return SuccessJson.getJson("添加成功");
    }

    @RequiresPermissions("goods:edit")
    @BusinessLog(operation = "修改积分物品")
    @RequestMapping("/goods_edit")
    @ResponseBody
    public String editGoods(@RequestParam(value = "id",required = false) Integer id,
                            @RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "point",required = false) Integer point,
                            @RequestParam(value = "status",required = false) Integer status) throws BusinessException{ //TODO:具体参数
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName(name);
        goods.setPoint(point);
        goods.setStatus(status);

        goodsService.editGoods(goods);

        return SuccessJson.getJson("修改成功");
    }

    @RequiresPermissions("goods:delete")
    @BusinessLog(operation = "删除积分物品")
    @RequestMapping("/goods_delete")
    @ResponseBody
    public String deleteGoods(@RequestParam(value="idArray")List<Integer> idArray)
            throws BusinessException{
        goodsService.deleteGoodss(idArray);
        return SuccessJson.getJson("删除成功");
    }

    @RequiresPermissions("goods:exchange_record")
    @RequestMapping("/goods_exchange")
    @ResponseBody
    public String goodsExchange(@RequestParam(value="goodsId",required = false) Integer goodsId){
        if(goodsId == null){
            return null;
        }

        return goodsService.getExchangeRecord(goodsId);
    }
}
