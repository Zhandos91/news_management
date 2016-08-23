package com.epam.suleimenov.presentation.action;


import com.epam.suleimenov.model.News;
import com.epam.suleimenov.presentation.form.NewsForm;
import com.epam.suleimenov.service.Service;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsAction extends LookupDispatchAction {

    private Logger log = LoggerFactory.getLogger(NewsAction.class);

    private Service service;

    public void setService(Service service) {
        this.service = service;
    }

    public ActionForward list(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {

        log.debug("Listing News");

        List<News> list_news = service.getList();
        NewsForm newsForm = (NewsForm) form;
        newsForm.setNewsList(list_news);


        return mapping.findForward("news-list");
    }


    public ActionForward view(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {

        log.debug("Viewing News");

        String id = request.getParameter("news_id");
        int news_id;
        if (id != null) {
            news_id = Integer.parseInt(id);
            News news = service.fetchById(news_id);
            NewsForm newsForm = (NewsForm) form;
            newsForm.setNewsMessage(news);
            log.debug("Viewed {}", news);

        } else {
            log.debug("news id is not found");
            return mapping.findForward("news-list");
        }

        return mapping.findForward("view-news");
    }


    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {

        log.debug("Editing news");
        String id = request.getParameter("news_id");
        int news_id;
        if (id != null) {
            news_id = Integer.parseInt(id);

            News news = service.fetchById(news_id);
            NewsForm newsForm = (NewsForm) form;
            newsForm.setNewsMessage(news);
            newsForm.setContent(news.getContent());
            newsForm.setBrief(news.getBrief());
            newsForm.setDate(news.getDate());
            newsForm.setTitle(news.getTitle());

            log.debug("Edited {}", news);

        } else {
            log.debug("news id is not found");
            return mapping.findForward("news-list");
        }

        return mapping.findForward("edit-news");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) {
        log.debug("Deleting News");

        NewsForm newsForm = (NewsForm) form;
        if (newsForm.getChecked() == null) {
            String id = request.getParameter("news_id");

            if (id == null) {
                log.debug("At least one news must be checked");
                request.setAttribute("deleteError", "EO4. At least one news must be checked");
            } else {
                log.debug("Deleting single news " + id);
                service.remove(Integer.parseInt(id));
                newsForm.setNewsList(service.getList());

            }
        } else {
            log.debug("Deleting multiple news");

            for (String deleting : newsForm.getChecked()) {
                service.remove(Integer.parseInt(deleting));
            }
            newsForm.setNewsList(service.getList());

        }

        newsForm.setChecked(null);

        return mapping.findForward("news-list");
    }

    public ActionForward cancel(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) {

        log.debug("Cancelling News");

        return mapping.findForward("news-list");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {
        log.debug("Saving news");


        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        news.setDate(newsForm.getDate());
        news.setTitle(newsForm.getTitle());
        news.setId(Integer.parseInt(newsForm.getId()));
        service.save(news);
        newsForm.setNewsMessage(news);

        log.debug("Saved {}" + news);

        return mapping.findForward("view-news");
    }

    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response) {
        log.debug("Adding news");

        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        news.setContent(newsForm.getContent());
        news.setDate(newsForm.getDate());
        news.setTitle(newsForm.getTitle());
        news.setBrief(newsForm.getBrief());

        news = service.add(news);
        newsForm.setNewsMessage(news);
        log.debug("Added {}", newsForm.getNewsMessage());


        return mapping.findForward("view-news");
    }


    @Override
    protected Map getKeyMethodMap() {

        Map keyMap = new HashMap();
        keyMap.put("news_list", "list");
        keyMap.put("view_news", "view");
        keyMap.put("edit_news", "edit");
        keyMap.put("delete_news", "delete");
        keyMap.put("cancel_news", "cancel");
        keyMap.put("save_news", "save");
        keyMap.put("add_news", "add");

        return keyMap;

    }
}