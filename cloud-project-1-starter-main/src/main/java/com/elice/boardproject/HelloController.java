package com.elice.boardproject;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// SSR -> 항상 화면 정보를 반환
// CSR -> 화면 정보를 한번만 반환하고 데이터 반환\
@Controller
public class HelloController {
    @GetMapping(path = "/hello")
    public String hello(){
        return "hello";
    }
    //위랑 같은 코드 아래 부분이 생략됨
//    @GetMapping(path = "/hello")
//    public ModelAndView hello(ModelAndView mav){
//        mav.setViewName("hello");
//        return mav;
//    }
}
