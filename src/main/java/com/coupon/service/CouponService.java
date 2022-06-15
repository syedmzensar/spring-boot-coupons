package com.coupon.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coupon.dto.CouponDto;
import com.coupon.entity.Coupon;

public interface CouponService {
	
	public CouponDto getCoupon(int couponId);
	
	public List<CouponDto> getAllCoupons();

	public CouponDto insertCoupon(CouponDto couponDto);

	public void updateCoupon(int couponId, CouponDto couponDto); 
	

	public void deleteCoupon(int couponId);

}
