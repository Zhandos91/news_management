package com.epam.suleimenov.presentation.form;

import com.epam.suleimenov.model.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class NewsForm extends ActionForm {

    private static final long serialVersionUID = -3801647970505428833L;
    private News newsMessage;
    private List<News> newsList;
    private String game;

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public News getNewsMessage() {
        return newsMessage;
    }

    public void setNewsMessage(News newsMessage) {
        this.newsMessage = newsMessage;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        if(newsMessage != null) {
            newsMessage.setTitle(null);
            newsMessage.setDate(null);
            newsMessage.setBrief(null);
            newsMessage.setContent(null);
        }
        super.reset(mapping, request);
    }
}
