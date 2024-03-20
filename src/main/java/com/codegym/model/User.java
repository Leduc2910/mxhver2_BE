package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Vui lòng nhập tài khoản")
    @Column(unique = true)
    private String username;
    @NotEmpty(message = "Vui lòng nhập mật khẩu")
    @Size(min = 6, max = 32, message = "Vui lòng nhập mật khẩu từ 6-32 ký tự")
    private String password;
    @NotEmpty(message = "Vui lòng xác nhận lại mật khẩu")
    private String confirmPassword;
    @NotEmpty(message = "Vui lòng nhập email")
    @Email(message = "Email không hợp lệ")
    @Column(unique = true)
    private String email;
    private String phone;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime birthday = LocalDateTime.now();
    private String avatar = "https://firebasestorage.googleapis.com/v0/b/social-network-c9f60.appspot.com/o/images%2Favatar-default.png?alt=media&token=5d1fe836-096e-45b8-a2ea-a2028072305c";
    private String fullname;
    @Column(columnDefinition = "TEXT")
    private String address;
    @Column(columnDefinition = "TEXT")
    private String hobby;
}
