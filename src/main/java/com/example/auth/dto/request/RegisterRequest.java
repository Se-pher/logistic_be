package com.example.auth.dto.request;

import lombok.Data;

/*d

@Since 5/26/2026
@Author qle20

*/
@Data
public class RegisterRequest {
    private String name;
    private String email; 
    private String password;
    private String phoneNumber;
    private Integer role;}
