package com.coupon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coupon.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	@Query(value = "select * from coupon where expiry_date like %?1 ", nativeQuery = true)
	List<Coupon> getDates(String couponExpiry);

	@Query(value = "select * from coupon where code>4000 and code<4600", nativeQuery = true)
	List<Coupon> checkCoupon(int couponCode);
	
	/*
	 * @Query(value = "select * from coupon where CONTAINS ( expiry_date, '%:n') ",
	 * nativeQuery = true) List<Coupon> checkExpiry(@Param("n") int couponId);
	 */

}
