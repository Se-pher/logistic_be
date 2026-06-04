package com.example.auth.utils;

import org.springframework.stereotype.Component;

/*d

@Since 5/26/2026
@Author qle20

*/
@Component
public class PhoneUtils {
    public Boolean validatePhoneNumberAndEmail(String phoneNumber, String email) {
        if (phoneNumber == null || email == null) {
            return false;
        }
        String phoneRegex = "^(\\+84|0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5]|9[0-4|6-9])[0-9]{7}$";
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return phoneNumber.matches(phoneRegex) && email.matches(emailRegex);
    }


}
