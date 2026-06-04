package com.example.auth.model;

import jakarta.persistence.*;
import lombok.Data;

/*d

@Since 5/22/2026
@Author qle20

*/
@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Column (name = "phone_number")
    private String phoneNumber;
    private Integer role;

    
}
