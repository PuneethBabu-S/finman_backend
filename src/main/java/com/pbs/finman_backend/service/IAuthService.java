package com.pbs.finman_backend.service;

import com.pbs.finman_backend.dto.LoginRequestDTO;
import com.pbs.finman_backend.dto.RegisterRequestDTO;

public interface IAuthService {
    public void register(RegisterRequestDTO request);
    public String login(LoginRequestDTO request);
}
