package com.coupon.service;

import java.util.List;

import com.coupon.dto.CouponDto;

public interface CouponService {

	public CouponDto getCoupon(int couponId);

	public List<CouponDto> getAllCoupons(int pageNumber, int pageSize);

	public CouponDto insertCoupon(CouponDto couponDto);

	public void updateCoupon(int couponId, CouponDto couponDto);

	public void deleteCoupon(int couponId);

	List<CouponDto> getDates(String couponExpiry);

	List<CouponDto> checkCoupon(int couponCode);

	/* List<Coupon> checkExpiry(int couponId); */

}
