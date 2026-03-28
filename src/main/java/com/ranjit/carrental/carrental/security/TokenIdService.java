package com.ranjit.carrental.carrental.security;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class TokenIdService {

    public String encode(Long id) {
        return Base64.getEncoder()
                .encodeToString(String.valueOf(id).getBytes());
    }
}