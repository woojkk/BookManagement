package com.woojkk.bookmanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig{

  @Bean
  public OpenAPI api() {
    return new OpenAPI()
        .info(this.apiInfo());
  }

  private Info apiInfo() {
    return new Info().title("Book Management")
        .description("도서 관리 시스템");
  }
}
