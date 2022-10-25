package com.ibs.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "authorizationservice")
public interface AuthorizationFeign {

	@GetMapping("/api/auth/getUser")
	public ResponseEntity<?> getUser(@RequestHeader("IdToken") String jwt);
}
