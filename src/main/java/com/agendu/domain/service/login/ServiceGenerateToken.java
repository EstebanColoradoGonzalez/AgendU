package com.agendu.domain.service.login;

import java.util.List;

public interface ServiceGenerateToken
{
    String generateToken(String email, List<String> roles);
}