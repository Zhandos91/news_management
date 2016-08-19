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
    private String id;
    private String title;
    private String date;
    private String brief;
    private String content;
    private String[] checked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getChecked() {
        return checked;
    }

    public void setChecked(String[] checked) {
        this.checked = checked;
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
        this.setTitle(null);
        this.setDate(null);
        this.setBrief(null);
        this.setContent(null);
        if(newsMessage != null) {
            newsMessage.setTitle(null);
            newsMessage.setDate(null);
            newsMessage.setBrief(null);
            newsMessage.setContent(null);
        }
        super.reset(mapping, request);
    }

//    @Override
//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//
//        ActionErrors errors = new ActionErrors();
//
//        if(getTitle() == null || getTitle().equals("")) {
//            errors.add("title", new ActionMessage("error.title.missing"));
//
//        }
//        return errors;
//    }
}
