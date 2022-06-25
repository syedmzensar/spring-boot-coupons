package com.coupon.exception;

public class CouponAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public CouponAlreadyExistsException() {
		super();
	}

	public CouponAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}

}
