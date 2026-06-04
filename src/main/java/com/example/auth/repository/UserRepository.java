package com.example.auth.repository;


import com.example.auth.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*d

@Since 5/25/2026
@Author qle20

*/
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> getByEmail(String email);

    Users getByEmailOrPhoneNumber(String email, String phoneNumber);
}
