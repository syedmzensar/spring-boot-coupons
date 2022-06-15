package com.coupon.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.dto.CouponDto;
import com.coupon.entity.Coupon;
import com.coupon.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CouponDto getCoupon(int couponId) {
		Coupon coupon = couponRepository.findById(couponId).get();

		return modelMapper.map(coupon, CouponDto.class);

	}

	public List<CouponDto> getAllCoupons() {
		List<Coupon> coupon = couponRepository.findAll();

		List<CouponDto> listOfCouponDto = new ArrayList<CouponDto>();

		for (Coupon c : coupon) {
			listOfCouponDto.add(modelMapper.map(c, CouponDto.class));
		}

		return listOfCouponDto;

	}

	public CouponDto insertCoupon(CouponDto couponDto) {

		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon insertedCoupon = couponRepository.save(coupon);

		return modelMapper.map(insertedCoupon, CouponDto.class);

	}

	public void updateCoupon(int couponId, CouponDto couponDto) {

		couponRepository.save(modelMapper.map(couponDto, Coupon.class));
	}

	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);
	}

}
