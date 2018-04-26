package com.freight.ms.controller;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.common.json.SuccessJson;
import com.freight.ms.model.Coupon;
import com.freight.ms.service.CouponService;
import com.freight.ms.system.log.BusinessLog;
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
@RequestMapping("/manage/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @RequestMapping("")
    public String index(){
        return "/coupon/coupon.html";
    }

    @RequestMapping("/add")
    public String addView() {
        return "/coupon/coupon_add.html";
    }

    @RequestMapping("/edit/{id}")
    public String editView(@PathVariable Integer id, Model model){
        if(id == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        Coupon coupon = couponService.findCouponById(id);
        model.addAttribute(coupon);
        return "/coupon/coupon_edit.html";
    }

    @BusinessLog(operation = "查看优惠券列表")
    @RequestMapping(value = "/coupon_list")
    @ResponseBody
     public String getList(@RequestParam(value = "name",required = false) String name,
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
        paramMap.put("createStartTime", createStartTime);
        paramMap.put("createEndTime", createEndTime);
        paramMap.put("limit", limit);
        paramMap.put("offset", offset);

        return couponService.findCoupons(paramMap);
    }

    @BusinessLog(operation = "添加优惠券")
    @RequestMapping("/coupon_add")
    @ResponseBody
    public String addUser(@RequestParam(value = "name",required = false) String name,
                          @RequestParam(value = "activeTime",required = false) Integer activeTime,
                          @RequestParam(value = "price",required = false) Double price,
                          @RequestParam(value = "startPrice",required = false) Double startPrice) throws BusinessException { //TODO：具体参数
        Coupon coupon = new Coupon();
        coupon.setName(name);
        coupon.setActiveTime(activeTime);
        coupon.setPrice(price);
        coupon.setStartPrice(startPrice);

        couponService.addCoupon(coupon);

        return SuccessJson.getJson("添加成功");
    }

    @BusinessLog(operation = "修改优惠券")
    @RequestMapping("/coupon_edit")
    @ResponseBody
    public String editCoupon(@RequestParam(value = "id",required = false) Integer id,
                             @RequestParam(value = "name",required = false) String name,
                             @RequestParam(value = "activeTime",required = false) Integer activeTime,
                             @RequestParam(value = "price",required = false) Double price,
                             @RequestParam(value = "startPrice",required = false) Double startPrice) throws BusinessException{ //TODO:具体参数
        Coupon coupon = new Coupon();
        coupon.setId(id);
        coupon.setName(name);
        coupon.setActiveTime(activeTime);
        coupon.setPrice(price);
        coupon.setStartPrice(startPrice);

        couponService.editCoupon(coupon);

        return SuccessJson.getJson("修改成功");
    }

    @BusinessLog(operation = "删除优惠券")
    @RequestMapping("/coupon_delete")
    @ResponseBody
    public String deleteCoupon(@RequestParam(value="idArray")List<Integer> idArray)
            throws BusinessException{
        couponService.deleteCoupons(idArray);
        return SuccessJson.getJson("删除成功");
    }
}
