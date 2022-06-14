package com.coupon.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.entity.Coupon;
import com.coupon.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	public Coupon getCoupon(int couponId) {
		return couponRepository.findById(couponId).get();
	}

	public ArrayList<Coupon> getAllCoupons() {
		return (ArrayList<Coupon>) couponRepository.findAll();

	}

	public void insertCoupon(Coupon coupon) {
		couponRepository.save(coupon);

	}

	public void updateCoupon(int couponId, Coupon coupon) {
		couponRepository.save(coupon);
	}

	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);
	}

}
