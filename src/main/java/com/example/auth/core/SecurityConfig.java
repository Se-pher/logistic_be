package com.example.auth.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*d

@Since 5/25/2026
@Author qle20

*/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // (1) Đây chính là cái Bean mà thằng Spring nó đang gào thét tìm kiếm nãy giờ
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Thuật toán băm mật khẩu chuẩn cmn quốc tế hiện nay
    }

    // (2) Cấu hình mở cửa cho API Login
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Cấp thẻ VIP cho Auth và toàn bộ URL của Swagger
                        .requestMatchers(
                                "/api/v1/auth/**",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        // Các API khác vẫn phải kiểm tra Token
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
