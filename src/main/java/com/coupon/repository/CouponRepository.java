package com.coupon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coupon.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	Coupon findByCouponCode(String couponCode);

	@Query(value = "select * from coupon where id=?1 ", nativeQuery = true)
	String checkExpiry(int couponId);

}
