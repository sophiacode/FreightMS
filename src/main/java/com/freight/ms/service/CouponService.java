package com.freight.ms.service;

import com.freight.ms.model.Coupon;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CouponService {

    Coupon findCouponById(Integer id);

    String findCoupons(Map<String, Object> paramMap);

    void addCoupon(Coupon coupon);

    void editCoupon(Coupon coupon);

    void deleteCoupons(List<Integer> list);
}
