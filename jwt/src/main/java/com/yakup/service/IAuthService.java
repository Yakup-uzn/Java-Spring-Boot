package com.yakup.service;

import com.yakup.dto.DtoUser;
import com.yakup.jwt.AuthRequest;
import com.yakup.jwt.AuthResponse;

public interface IAuthService {

	public DtoUser register(AuthRequest request);
	
	public AuthResponse authenticate(AuthRequest request);
}
