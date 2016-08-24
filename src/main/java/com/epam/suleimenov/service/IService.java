package com.epam.suleimenov.service;

import com.epam.suleimenov.database.NewsDAO;
import com.epam.suleimenov.model.News;

import java.util.List;

public class IService implements Service {

    private NewsDAO newsDAO;

    public void setNewsDAO(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @Override
    public List<News> getList() {
        return newsDAO.getList();
    }

    @Override
    public News save(News news) {
        return newsDAO.save(news);
    }

    @Override
    public boolean remove(int id) {
        return newsDAO.remove(id);
    }

    @Override
    public News fetchById(int id) {
        return newsDAO.fetchById(id);
    }

    @Override
    public News add(News news) {
        return newsDAO.add(news);
    }

}

