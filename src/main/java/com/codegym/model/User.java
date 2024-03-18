package com.codegym.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Thiếu username")
    private String username;
    @Size(min = 6, max = 32)
    private String password;
    private String confirmPassword;
    @NotEmpty(message = "Thiếu email")
    @Email(message = "Email không hợp lệ")
    private String email;
    private String phone;
    private String birthday;
}
