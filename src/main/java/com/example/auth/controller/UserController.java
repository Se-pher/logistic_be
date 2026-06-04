package com.example.auth.controller;

import com.example.auth.core.ApiResponse;
import com.example.auth.dto.request.RegisterRequest;
import com.example.auth.dto.response.LoginResponse;
import com.example.auth.model.Users;
import com.example.auth.services.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*d

@Since 5/25/2026
@Author qle20

*/
@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    @Resource
    private UserService userService;


    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody  Users usersInfo) {

        return new ApiResponse<>(userService.login(usersInfo));
    }

    @PostMapping("/register")
    public ApiResponse<Void> register(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);
        return new ApiResponse<>(null);
    }

}
