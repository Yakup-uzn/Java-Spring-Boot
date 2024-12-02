package com.yakup.controller;

import com.yakup.dto.DtoUser;
import com.yakup.jwt.AuthRequest;
import com.yakup.jwt.AuthResponse;
import com.yakup.jwt.RefreshTokenRequest;

public interface IRestAuthController {

	public DtoUser register(AuthRequest request);
	
	public AuthResponse authenticate(AuthRequest request);
	
	public AuthResponse refreshToken(RefreshTokenRequest request);
}
