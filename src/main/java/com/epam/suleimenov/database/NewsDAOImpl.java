package com.epam.suleimenov.database;


import com.epam.suleimenov.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDAOImpl implements NewsDAO {

    private Connection connection;
    private Logger log = LoggerFactory.getLogger(NewsDAOImpl.class);

    public NewsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<News> getList() {
        String sql = "SELECT * FROM NEWS";
        List<News> newsList = new ArrayList<News>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt("news_id"));
                news.setTitle(resultSet.getString("news_title"));
                news.setDate(resultSet.getString("news_date"));
                news.setBrief(resultSet.getString("news_brief"));
                news.setContent(resultSet.getString("news_content"));
                newsList.add(news);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    @Override
    public News save(News news) {
        String sql = "UPDATE NEWS SET NEWS_TITLE = ?, NEWS_DATE = ?, NEWS_BRIEF = ?, NEWS_CONTENT = ? WHERE NEWS_ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getDate());
            preparedStatement.setString(3, news.getBrief());
            preparedStatement.setString(4, news.getContent());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        log.debug("saved {}", news);
        return news;
    }

    @Override
    public boolean remove(int id) {

        String sql = "DELETE FROM NEWS WHERE NEWS_ID = ?";
        boolean isDeleted = false;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            if(preparedStatement.executeUpdate() > 0)
                isDeleted = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public News fetchById(int id) {
        String sql = "SELECT * FROM NEWS WHERE NEWS_ID = ?";
        News news = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                news = new News();
                news.setId(resultSet.getInt("news_id"));
                news.setTitle(resultSet.getString("news_title"));
                news.setDate(resultSet.getString("news_date"));
                news.setBrief(resultSet.getString("news_brief"));
                news.setContent(resultSet.getString("news_content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.debug("fetched {}", news);
        return news;
    }

    @Override
    public News add(News news) {

        String sql = "INSERT INTO NEWS(NEWS_TITLE, NEWS_DATE, NEWS_BRIEF, NEWS_CONTENT) VALUES(?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"NEWS_ID"})) {
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getDate());
            preparedStatement.setString(3, news.getBrief());
            preparedStatement.setString(4, news.getContent());
            preparedStatement.executeUpdate();
            ResultSet generated_keys = preparedStatement.getGeneratedKeys();
            if(generated_keys != null && generated_keys.next())
            news.setId(generated_keys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        log.debug("added {}", news);
        return news;
    }
}
