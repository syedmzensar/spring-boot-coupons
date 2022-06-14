package com.coupon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coupon {

	@Id
	@Column(name = "id")
	private int couponId;

	@Column(name = "code")
	private int couponCode;

	@Column(name = "type")
	private String couponType;

	public Coupon() {
		super();
	}

	public Coupon(int couponId, int couponCode, String couponType) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.couponType = couponType;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public int getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(int couponCode) {
		this.couponCode = couponCode;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", couponType=" + couponType + "]";
	}

}
