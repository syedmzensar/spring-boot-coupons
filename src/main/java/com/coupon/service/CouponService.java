package com.coupon.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coupon.dto.CouponDto;
import com.coupon.entity.Coupon;

public interface CouponService {
	
	public Coupon getCoupon(int couponIdDto);
	
	public ArrayList<Coupon> getAllCoupons();

	public void insertCoupon(CouponDto couponDto);

	public void updateCoupon(int couponIdDto, CouponDto couponDto); 
	

	public void deleteCoupon(int couponIdDto);

}
