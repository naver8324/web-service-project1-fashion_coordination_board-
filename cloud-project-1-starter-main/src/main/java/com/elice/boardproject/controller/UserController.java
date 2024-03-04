package com.elice.boardproject.controller;

import com.elice.boardproject.entity.User;
import com.elice.boardproject.entity.UserDto;
import com.elice.boardproject.mapper.UserMapper;
import com.elice.boardproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/signup")
    public String signupUser() {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signupUserPost(@ModelAttribute UserDto userDto) {
        User user = userMapper.userPostDtoToUser(userDto);
        userService.saveUser(user);

        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String loginUser() {
        return "user/login";
    }

    @PostMapping("/login")
    public String loginUserPost(@ModelAttribute UserDto userDto, HttpSession session) {
        String loginId = userDto.getLoginId();
        String password = userDto.getPassword();

        // 아이디와 비밀번호를 사용하여 사용자 조회
        User user = userService.findByLoginIdAndPassword(loginId, password);

        if (user != null) {
            // 사용자가 존재하면 로그인 성공
            session.setAttribute("userName", user.getName()); // 세션에 사용자 아이디 저장
            return "redirect:/boards";
        } else {
            // 사용자가 존재하지 않으면 로그인 실패
            return "user/login";
        }
    }
}
