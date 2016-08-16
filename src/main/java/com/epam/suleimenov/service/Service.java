package com.epam.suleimenov.service;

import com.epam.suleimenov.database.Connector;
import com.epam.suleimenov.database.NewsDAO;
import com.epam.suleimenov.database.NewsDAOImpl;
import com.epam.suleimenov.model.News;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Service implements AutoCloseable {

    private NewsDAO newsDAO;
    private Connector connector;
    private Connection connection;
    public Service() {
        connector = new Connector();
        try {
            connection = connector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        newsDAO = new NewsDAOImpl(connection);
        }


        public List<News> getList() {
            return newsDAO.getList();
        }

       public News save(News news) {
           return newsDAO.save(news);
       }

   public boolean remove(int id) {
       return newsDAO.remove(id);
   }

    public News fetchById(int id) {
        return newsDAO.fetchById(id);
    }

    /////////

    public News add(News news) {
        return newsDAO.add(news);
    }

    @Override
    public void close() throws Exception {
        if(connector != null) {
            if(connection != null)
            connector.closeConnection(connection);
        }
    }
}
