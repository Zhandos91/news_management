package com.epam.suleimenov.presentation.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class NewsForm extends ActionForm{

    private static final long serialVersionUID = -3891647670505228833L;
    private String title;
    private String date;
    private String brief;
    private String content;

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

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.setTitle(null);
        this.setDate(null);
        this.setBrief(null);
        this.setContent(null);
        super.reset(mapping, request);
    }
}
