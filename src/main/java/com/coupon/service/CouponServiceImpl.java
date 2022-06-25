package com.coupon.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.coupon.dto.CouponDto;
import com.coupon.entity.Coupon;
import com.coupon.exception.CouponAlreadyExistsException;
import com.coupon.exception.CouponNotFoundException;
import com.coupon.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CouponDto findByCouponCode(String couponCode) {
		Coupon coupon = couponRepository.findByCouponCode(couponCode);
		if (coupon.getCouponCode().isEmpty())
			throw new CouponNotFoundException("Coupon with this id is not there");
		else
			return modelMapper.map(coupon, CouponDto.class);
	}

	public List<CouponDto> getAllCoupons(int pageNumber, int pageSize) {
		Page<Coupon> findAllCoupons = couponRepository.findAll(PageRequest.of(pageNumber, pageSize));

		List<Coupon> coupons = findAllCoupons.getContent();

		List<CouponDto> listOfCouponDto = new ArrayList<CouponDto>();

		for (Coupon c : coupons) {
			listOfCouponDto.add(modelMapper.map(c, CouponDto.class));
		}

		return listOfCouponDto;

	}

	public CouponDto insertCoupon(CouponDto couponDto) {

		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		
		boolean checkId = couponRepository.existsById(coupon.getCouponId());

		if (checkId) {
			throw new CouponAlreadyExistsException("This coupon already exists");
		}

		
		Coupon insertedCoupon = couponRepository.save(coupon);

		return modelMapper.map(insertedCoupon, CouponDto.class);

	}

	public void updateCoupon(int couponId, CouponDto couponDto) {

		couponRepository.save(modelMapper.map(couponDto, Coupon.class));
	}

	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);
	}

	public String checkExpiry(int couponId) {
		List<Coupon> coupons = couponRepository.findAll();
		for (Coupon c : coupons) {
			if (couponId == c.getCouponId()) {
				if (c.getCouponExpiry().split("-")[0].matches("200[0-9]|201[0-9]|202[01]")) {
					return "Coupon is expired";
				}
			}

		}
		return "Coupon is valid";

	}

}
