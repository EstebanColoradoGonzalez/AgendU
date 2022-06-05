package com.agendu.domain.service.login;

import org.springframework.stereotype.Service;

@Service
public interface ServiceEncryptText
{
    String encryptText(String text);
}