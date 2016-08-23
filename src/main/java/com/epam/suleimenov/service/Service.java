package com.epam.suleimenov.service;

import com.epam.suleimenov.model.News;

import java.util.List;

public interface Service {

    List<News> getList();
    News save(News news);
    boolean remove(int id);
    News fetchById(int id);
    News add(News news);
}
