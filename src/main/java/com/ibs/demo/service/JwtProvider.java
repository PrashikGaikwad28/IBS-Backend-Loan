package com.ibs.demo.service;

import java.security.Key;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtProvider {
	private Key key;

	@PostConstruct
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
		System.out.println("Key = " +key);		//Key = javax.crypto.spec.SecretKeySpec@fa77de6b
	}

	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		
		return claims.getSubject();
	}
}
