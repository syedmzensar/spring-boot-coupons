package com.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.dto.CouponDto;
import com.coupon.model.AuthenticationRequest;
import com.coupon.model.AuthenticationResponse;
import com.coupon.security.MyUserDetailsService;
import com.coupon.service.CouponService;
import com.coupon.util.JwtUtil;

@RestController
/*
 * @RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE,
 * MediaType.APPLICATION_XML_VALUE }, consumes = {
 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
 */

public class CouponController {

	@Autowired
	private CouponService couponService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@GetMapping("/coupons/{couponCode}")
	public ResponseEntity<CouponDto> getCoupon(@PathVariable("couponCode") String couponCode) {
		return new ResponseEntity<CouponDto>(couponService.findByCouponCode(couponCode), HttpStatus.OK);
	}

	@GetMapping("/coupons")
	public ResponseEntity<List<CouponDto>> getAllCoupons(
			@RequestParam(required = false, defaultValue = "0") int pageNumber,
			@RequestParam(required = false, defaultValue = "4") int pageSize) {
		return new ResponseEntity<List<CouponDto>>(couponService.getAllCoupons(pageNumber, pageSize), HttpStatus.OK);
	}

	@PostMapping("/coupons")
	public ResponseEntity<CouponDto> insertCoupon(@RequestBody CouponDto couponDto) {
		return new ResponseEntity<CouponDto>(couponService.insertCoupon(couponDto), HttpStatus.CREATED);
	}

	@PutMapping("/coupons/{couponId}")
	public ResponseEntity<String> updateCoupon(@PathVariable("couponId") int couponId,
			@RequestBody CouponDto couponDto) {
		couponService.updateCoupon(couponId, couponDto);
		return new ResponseEntity<String>("Coupon successfully updated", HttpStatus.CREATED);
	}

	@DeleteMapping("/coupons/{couponId}")
	public ResponseEntity<String> deleteCoupon(@PathVariable("couponId") int couponId) {
		couponService.deleteCoupon(couponId);
		return new ResponseEntity<String>("Coupon successfully deleted", HttpStatus.ACCEPTED);
	}

	/* Method to check the coupon for expiry by entering te coupon id */
	@GetMapping("/coupons/expirydate/{couponId}")
	public ResponseEntity<String> checkExpiry(@PathVariable("couponId") int couponId) {
		return new ResponseEntity<String>(couponService.checkExpiry(couponId), HttpStatus.OK);
	}

}
