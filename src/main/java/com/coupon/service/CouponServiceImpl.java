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
//		Coupon coupon = entityToDto(couponDto); 
		Coupon insertedCoupon = couponRepository.save(coupon);

		return modelMapper.map(insertedCoupon, CouponDto.class);

//		return dtoToEntity(insertedCoupon);

	}

	public void updateCoupon(int couponId, CouponDto couponDto) {

		couponRepository.save(modelMapper.map(couponDto, Coupon.class));
	}

	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);
	}

	public List<CouponDto> getDates(String couponExpiry) {

		List<Coupon> dates = couponRepository.getDates(couponExpiry);

		List<CouponDto> listOfCouponDto = new ArrayList<CouponDto>();

		for (Coupon c : dates) {
			listOfCouponDto.add(modelMapper.map(c, CouponDto.class));
		}

		return listOfCouponDto;

	}

	public List<CouponDto> checkCoupon(int couponCode) {
		List<Coupon> codes = couponRepository.checkCoupon(couponCode);

		List<CouponDto> listOfCouponDto = new ArrayList<CouponDto>();

		for (Coupon c : codes) {
			listOfCouponDto.add(modelMapper.map(c, CouponDto.class));
		}

		return listOfCouponDto;
	}

//	/*public List<Coupon> checkExpiry(int couponId) {
//
//		List<Coupon> coupons = couponRepository.findAll();
//
//		for (Coupon c : coupons) {
//			if (c.getCouponExpiry().contains("2021"))
//				coupons.remove(c);
//		}
//		return coupons;*/
//
//	}

	/*
	 * public Coupon entityToDto(CouponDto couponDto) {
	 * 
	 * Coupon coupon = new Coupon(); coupon.setCouponId(couponDto.getCouponIdDto());
	 * coupon.setCouponCode(couponDto.getCouponCodeDto());
	 * coupon.setCouponExpiry(couponDto.getCouponExpiryDto());
	 * 
	 * return coupon;
	 * 
	 * }
	 * 
	 * public CouponDto dtoToEntity(Coupon coupon) {
	 * 
	 * CouponDto couponDto = new CouponDto();
	 * couponDto.setCouponIdDto(coupon.getCouponId());
	 * couponDto.setCouponCodeDto(coupon.getCouponCode());
	 * couponDto.setCouponExpiryDto(coupon.getCouponExpiry());
	 * 
	 * return couponDto;
	 * 
	 * }
	 */
}
