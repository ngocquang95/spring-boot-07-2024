package com.sqc.academy;

import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class AcademyApplicationTests {

    @Test
    void hash() throws NoSuchAlgorithmException {
        String password = "123"; // Chuỗi mật khẩu cần mã hóa

        // Tạo một instance của MessageDigest với thuật toán MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Mã hóa mật khẩu bằng MD5 lần 1
        md.update(password.getBytes()); // Cập nhật mật khẩu vào MessageDigest
        byte[] digest = md.digest(); // Lấy kết quả mã hóa dưới dạng mảng byte
        String md5Hash = DatatypeConverter.printHexBinary(digest); // Chuyển đổi mảng byte thành chuỗi hexadecimal
        System.out.println("MD5 lần 1: " + md5Hash); // In ra kết quả mã hóa lần 1 bằng MD5

        // Mã hóa mật khẩu bằng MD5 lần 2 (với cùng chuỗi mật khẩu)
        md.update(password.getBytes()); // Cập nhật mật khẩu vào MessageDigest
        digest = md.digest(); // Lấy kết quả mã hóa dưới dạng mảng byte
        md5Hash = DatatypeConverter.printHexBinary(digest); // Chuyển đổi mảng byte thành chuỗi hexadecimal
        System.out.println("MD5 lần 2: " + md5Hash); // In ra kết quả mã hóa lần 2 bằng MD5

        // Tạo một instance của BCryptPasswordEncoder với hệ số độ phức tạp là 10
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        // Mã hóa mật khẩu bằng BCrypt lần 1
        System.out.println("BCrypt lần 1: " + passwordEncoder.encode(password)); // In ra kết quả mã hóa lần 1 bằng BCrypt

        // Mã hóa mật khẩu bằng BCrypt lần 2
        System.out.println("BCrypt lần 2: " + passwordEncoder.encode(password)); // In ra kết quả mã hóa lần 2 bằng BCrypt
        // 123
        System.out.println("BCrypt lần 2: " + passwordEncoder.matches("123",  passwordEncoder.encode(password)));
    }

}
