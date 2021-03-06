package com.example.board.controller;

import com.example.board.config.security.JwtTokenProvider;
import com.example.board.entity.UserToken;
import com.example.board.entity.User;
import com.example.board.params.UserParam;
import com.example.board.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;

@RequestMapping(value = "/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @RequestMapping(value = "/registration", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public User registration(UserParam userParam) {
        return userRepo.save(User.builder()
                .userId(userParam.getUserId())
                .username(userParam.getUsername())
                .password(passwordEncoder.encode(userParam.getPassword()))
                .roles(Collections.singletonList("ROLE_USER"))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public UserToken login(UserParam userParam) throws Exception {
        UserToken userToken = new UserToken();

        User user = userRepo.findByUserId(userParam.getUserId()).orElseThrow(() -> new Exception("가입되지 않은 아이디 입니다."));
        if (!passwordEncoder.matches(userParam.getPassword(), user.getPassword())) {
            throw new Exception("잘못된 비밀번호입니다.");
        }

        userToken.setUser(user);
        userToken.setToken(jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));

        return userToken;
    }
}
