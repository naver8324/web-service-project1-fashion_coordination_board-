package com.elice.boardproject.service;

import com.elice.boardproject.entity.Stylelist;

public interface StylelistService {
    Stylelist getStylelistById(int id);
    void saveStylelist(Stylelist stylelist);
}
