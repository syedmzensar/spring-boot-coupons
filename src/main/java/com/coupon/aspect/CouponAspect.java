package com.coupon.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CouponAspect {

	@Before(value = "execution(* com.coupon.service.CouponServiceImpl.*(..)) and args(couponId,couponCode,couponExpiry)")
	public void beforeAdvice(JoinPoint joinPoint, int couponId, int couponCode, String couponExpiry) {
		System.out.println("Before method:" + joinPoint.getSignature());
		
		System.out.println("Creating before.......");
	}

	@After(value = "execution(* com.coupon.service.CouponServiceImpl.*(..)) and args(couponId,couponCode,couponExpiry)")
	public void afterAdvice(JoinPoint joinPoint, int couponId, int couponCode, String couponExpiry) {
		System.out.println("After method:" + joinPoint.getSignature());

		System.out.println("Finished...after.......");
	}
}
