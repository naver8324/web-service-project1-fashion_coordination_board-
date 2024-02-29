package com.elice.boardproject.service;

import com.elice.boardproject.entity.Stylelist;
import com.elice.boardproject.entity.User;
import com.elice.boardproject.repository.StylelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StylelistService {
    @Autowired
    private StylelistRepository stylelistRepository;


//    public Stylelist getStylelistById(int id) {
//        return sytleStylelistRepository.findById(id).orElse(null);
//    }

    public void saveStylelist(Stylelist stylelist) {
        stylelistRepository.save(stylelist);
    }

    public Stylelist findByLoginIdAndPassword(String loginId, String password) {
        // 사용자를 아이디와 비밀번호로 조회하여 반환
        return stylelistRepository.findByLoginIdAndPassword(loginId, password);
    }
}
