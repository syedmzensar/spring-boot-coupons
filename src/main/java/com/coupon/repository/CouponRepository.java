package com.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coupon.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
