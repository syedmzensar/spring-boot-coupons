package com.coupon.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class CouponDto {

	private int couponIdDto;

	private String couponExpiryDto;

	public CouponDto() {
		super();
	}

	public CouponDto(int couponIdDto, String couponExpiryDto) {
		super();
		this.couponIdDto = couponIdDto;
		this.couponExpiryDto = couponExpiryDto;
	}

	public int getCouponIdDto() {
		return couponIdDto;
	}

	public void setCouponIdDto(int couponIdDto) {
		this.couponIdDto = couponIdDto;
	}

	public String getCouponExpiryDto() {
		return couponExpiryDto;
	}

	public void setCouponExpiryDto(String couponExpiryDto) {
		this.couponExpiryDto = couponExpiryDto;
	}

	@Override
	public String toString() {
		return "CouponDto [couponIdDto=" + couponIdDto + ", couponExpiryDto=" + couponExpiryDto + "]";
	}
	
	
}
