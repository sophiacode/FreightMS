package com.freight.ms.serviceImpl;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.CouponMapper;
import com.freight.ms.model.Coupon;
import com.freight.ms.service.CouponService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.CouponWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CouponServiceImpl implements CouponService{
    @Autowired
    private CouponMapper couponMapper;


    public Coupon findCouponById(Integer id) {
        return couponMapper.selectByPrimaryKey(id);
    }

    public String findCoupons(Map<String, Object> paramMap){
        List<Coupon> couponList = couponMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(couponMapper.getCount(),
                        new CouponWrapper(couponList).wrap());
    }

    public void addCoupon(Coupon coupon){
        try{
            couponMapper.insertSelective(coupon);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.COUPON_ADD_FAIL);
        }
    }

    public void editCoupon(Coupon coupon){
        try{
            couponMapper.updateByPrimaryKeySelective(coupon);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.COUPON_EDIT_FAIL);
        }
    }

    public void deleteCoupons(List<Integer> list){
        try{
            for(Integer id:list){
                couponMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.COUPON_DELETE_FAIL);
        }
    }
}
