package com.example.auth.services;


import com.example.auth.dto.request.RegisterRequest;
import com.example.auth.dto.response.LoginResponse;
import com.example.auth.model.Users;
import jakarta.servlet.http.HttpServletRequest;

/*d

@Since 5/25/2026
@Author qle20

*/
public interface UserService {
    LoginResponse login(Users usersInfo);

    void register(RegisterRequest registerRequest);
}
