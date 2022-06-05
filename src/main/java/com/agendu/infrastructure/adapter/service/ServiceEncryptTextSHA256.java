package com.agendu.infrastructure.adapter.service;

import com.agendu.domain.service.login.ServiceEncryptText;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class ServiceEncryptTextSHA256 implements ServiceEncryptText
{

    @Override
    public String encryptText(String text)
    {
        return DigestUtils.sha256Hex(text);
    }
}