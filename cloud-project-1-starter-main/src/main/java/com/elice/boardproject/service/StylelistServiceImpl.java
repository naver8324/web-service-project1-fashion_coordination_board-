package com.elice.boardproject.service;

import com.elice.boardproject.entity.Stylelist;
import com.elice.boardproject.repository.StylelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StylelistServiceImpl implements StylelistService {
    @Autowired
    private StylelistRepository sytleStylelistRepository;


    @Override
    public Stylelist getStylelistById(int id) {
        return sytleStylelistRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStylelist(Stylelist stylelist) {
        sytleStylelistRepository.save(stylelist);
    }
}
