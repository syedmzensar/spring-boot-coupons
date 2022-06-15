package com.coupon.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.dto.CouponDto;
import com.coupon.entity.Coupon;
import com.coupon.service.CouponService;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class CouponController {

	@Autowired
	private CouponService couponService;

	@GetMapping("/coupon/{couponIdDto}")
	public Coupon getCoupon(@PathVariable("couponIdDto") int couponIdDto) {
		return couponService.getCoupon(couponIdDto);
	}

	@GetMapping("/coupons")
	public ArrayList<Coupon> getAllCoupons() {
		return couponService.getAllCoupons();
	}

	@PostMapping("/coupon")
	public void insertCoupon(@RequestBody CouponDto couponDto) {

		couponService.insertCoupon(couponDto);
	}

	@PutMapping("/coupon/{couponId}")
	public void updateCoupon(@PathVariable("couponIdDto") int couponIdDto, 
			@RequestBody CouponDto couponDto) {
		couponService.updateCoupon(couponIdDto, couponDto);
	}

	@DeleteMapping("/coupon/{couponId}")
	public void deleteCoupon(@PathVariable("couponIdDto") int couponIdDto) {
		couponService.deleteCoupon(couponIdDto);
	}

}
