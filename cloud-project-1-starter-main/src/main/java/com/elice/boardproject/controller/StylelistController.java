package com.elice.boardproject.controller;

import com.elice.boardproject.entity.Stylelist;
import com.elice.boardproject.entity.StylelistDto;
import com.elice.boardproject.entity.User;
import com.elice.boardproject.entity.UserDto;
import com.elice.boardproject.mapper.StylelistMapper;
import com.elice.boardproject.service.StylelistService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/stylelist")
public class StylelistController {

    private final StylelistService stylelistService;
    private final StylelistMapper stylelistMapper;

    @GetMapping("/signup")
    public String signupStylelist(){
        return "stylelist/signup";
    }

    @PostMapping("/signup")
    public String signupstylelistPost(@ModelAttribute StylelistDto stylelistDto) {
        Stylelist stylelist = stylelistMapper.stylelistPostDtoToStylelist(stylelistDto);
        stylelistService.saveStylelist(stylelist);

        return "redirect:/stylelist/login";
    }

    @GetMapping("/login")
    public String loginStylelist() {
        return "stylelist/login";
    }

    @PostMapping("/login")
    public String loginUserPost(@ModelAttribute StylelistDto stylelistDto) {
        String loginId = stylelistDto.getLoginId();
        String password = stylelistDto.getPassword();

        // 아이디와 비밀번호를 사용하여 사용자 조회
        Stylelist stylelist = stylelistService.findByLoginIdAndPassword(loginId, password);

        if (stylelist != null) {
            // 사용자가 존재하면 로그인 성공
//            session.setAttribute("userName", stylelist.getNickname()); // 세션에 사용자 아이디 저장
            return "redirect:/boards";
        } else {
            // 사용자가 존재하지 않으면 로그인 실패
            return "stylelist/login";
        }
    }
}
