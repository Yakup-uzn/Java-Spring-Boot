package com.yakup.service;

import com.yakup.jwt.AuthResponse;
import com.yakup.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {

	public AuthResponse refreshToken(RefreshTokenRequest request);
}
