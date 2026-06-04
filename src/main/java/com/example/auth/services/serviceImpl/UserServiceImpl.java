package com.example.auth.services.serviceImpl;

import com.example.auth.core.JwtService;
import com.example.auth.dto.request.RegisterRequest;
import com.example.auth.dto.response.LoginResponse;
import com.example.auth.model.Users;
import com.example.auth.repository.UserRepository;
import com.example.auth.services.UserService;
import com.example.auth.utils.PhoneUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*d

@Since 5/25/2026
@Author qle20

*/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtService jwtService;
    @Resource
    private PhoneUtils phoneUtils;
    @Override
    public LoginResponse login(Users request) {
        Users user = userRepository.getByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse(token, user.getName());
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        Users users = userRepository.getByEmailOrPhoneNumber(registerRequest.getEmail(), registerRequest.getPhoneNumber());
        if (users != null) {
            throw new RuntimeException("Email or phone number already exists");
        }
        phoneUtils.validatePhoneNumberAndEmail(registerRequest.getPhoneNumber(), registerRequest.getEmail());
        Users newUser = new Users();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setName(registerRequest.getName());
        newUser.setPhoneNumber(registerRequest.getPhoneNumber());
        newUser.setRole(1);
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(newUser);
    }
}
