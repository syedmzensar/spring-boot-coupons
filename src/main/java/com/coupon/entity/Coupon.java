package com.coupon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Coupon {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int couponId;

	@Column(name = "code")
	private String couponCode;
	
	@Column(name = "discount")
	private Double discount;

	@Column(name = "expiry_date")
	private String couponExpiry;

	/*
	 * public Coupon() { super(); }
	 * 
	 * public Coupon(int couponId, int couponCode, String couponExpiry) { super();
	 * this.couponId = couponId; this.couponCode = couponCode; this.couponExpiry =
	 * couponExpiry; }
	 * 
	 * public int getCouponId() { return couponId; }
	 * 
	 * public void setCouponId(int couponId) { this.couponId = couponId; }
	 * 
	 * public int getCouponCode() { return couponCode; }
	 * 
	 * public void setCouponCode(int couponCode) { this.couponCode = couponCode; }
	 * 
	 * public String getCouponExpiry() { return couponExpiry; }
	 * 
	 * public void setCouponExpiry(String couponExpiry) { this.couponExpiry =
	 * couponExpiry; }
	 * 
	 * @Override public String toString() { return "Coupon [couponId=" + couponId +
	 * ", couponCode=" + couponCode + ", couponExpiry=" + couponExpiry + "]"; }
	 */
}
