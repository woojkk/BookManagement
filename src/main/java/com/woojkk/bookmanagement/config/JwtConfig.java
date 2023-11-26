package com.woojkk.bookmanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
  @Value("${aes.encryptionKey}")
  private String secretKey;

  @Bean
  public JwtProvider jwtAuthenticationProvider() {
    return new JwtProvider(secretKey);
  }
}
