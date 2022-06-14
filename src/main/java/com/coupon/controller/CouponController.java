package com.coupon.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.entity.Coupon;
import com.coupon.service.CouponService;

@RestController
public class CouponController {

	@Autowired
	private CouponService couponService;

	@GetMapping("/coupon/{couponId}")
	public Coupon getCoupon(@PathVariable("couponId") int couponId) {
		return couponService.getCoupon(couponId);
	}

	@GetMapping("/coupons")
	public ArrayList<Coupon> getAllCoupons() {
		return couponService.getAllCoupons();
	}

	@PostMapping("/coupon")
	public void insertCoupon(@RequestBody Coupon coupon) {

		couponService.insertCoupon(coupon);
	}

	@PutMapping("/coupon/{couponId}")
	public void updateCoupon(@PathVariable("couponId") int couponId, @RequestBody Coupon coupon) {
		couponService.updateCoupon(couponId, coupon);
	}

	@DeleteMapping("/coupon/{couponId}")
	public void deleteCoupon(@PathVariable("couponId") int couponId) {
		couponService.deleteCoupon(couponId);
	}

}
