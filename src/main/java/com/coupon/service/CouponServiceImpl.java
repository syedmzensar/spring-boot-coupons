package com.coupon.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.dto.CouponDto;
import com.coupon.entity.Coupon;
import com.coupon.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	public Coupon getCoupon(int couponIdDto) {
		return couponRepository.findById(couponIdDto).get();
	}

	public ArrayList<Coupon> getAllCoupons() {
		return (ArrayList<Coupon>) couponRepository.findAll();

	}

	public void insertCoupon(CouponDto couponDto) {
		Coupon coupon = new Coupon();
		coupon.setCouponId(couponDto.getCouponIdDto());
		coupon.setCouponExpiry(couponDto.getCouponExpiryDto());
		couponRepository.save(coupon);

	}

	public void updateCoupon(int couponIdDto, CouponDto couponDto) {
		Coupon coupon = new Coupon();
		coupon.setCouponId(couponDto.getCouponIdDto());
		coupon.getCouponCode();
		coupon.setCouponExpiry(couponDto.getCouponExpiryDto());
		couponRepository.save(coupon);
	}

	public void deleteCoupon(int couponIdDto) {
		couponRepository.deleteById(couponIdDto);
	}

}
