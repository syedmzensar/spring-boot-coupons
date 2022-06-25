package com.coupon.service;

import java.util.List;

import com.coupon.dto.CouponDto;
import com.coupon.entity.Coupon;

public interface CouponService {

	public CouponDto findByCouponCode(String couponCode);

	public List<CouponDto> getAllCoupons(int pageNumber, int pageSize);

	public CouponDto insertCoupon(CouponDto couponDto);

	public void updateCoupon(int couponId, CouponDto couponDto);

	public void deleteCoupon(int couponId);

	String checkExpiry(int couponId);

}
