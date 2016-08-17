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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsAction extends LookupDispatchAction {

    private Logger log = LoggerFactory.getLogger(NewsAction.class);

    public ActionForward list(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {

        log.debug("In news_list action");

        try (Service service = new Service()) {
            List<News> list_news = service.getList();
            request.getSession().setAttribute("list_news", list_news);
            NewsForm newsForm = (NewsForm) form;
            newsForm.setNewsList(list_news);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try (Service service = new Service()) {
//            News news = new News();
//            news.setContent("This content is ");
//            news.setBrief("brieflyy fff");
//            news.setDate("12-12-2003");
//            news.setTitle("title");
//            service.add(news);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        return mapping.findForward("news-list");
    }


    public ActionForward view(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {

        log.debug("In view action");

        String id = request.getParameter("news_id");
        int news_id;
        if(id != null) {
            news_id = Integer.parseInt(id);

            try(Service service = new Service()){

                News news = service.fetchById(news_id);
                NewsForm newsForm = (NewsForm) form;
                newsForm.setNewsMessage(news);

                request.getSession().setAttribute("news", news);

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else{
            log.debug("news id is not found");
            return mapping.findForward("failure");
        }



        return mapping.findForward("view-news");
    }


    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {
        log.debug("Editing News");

        return mapping.findForward("success");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) {
        log.debug("Deleting News");

        return mapping.findForward("success");
    }

    public ActionForward cancel(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) {
        log.debug("Cancelling News");

        return mapping.findForward("success");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {

        NewsForm newsForm = (NewsForm) form;
        News newsMessage = new News();
        newsMessage.setTitle(newsForm.getTitle());
        newsMessage.setDate(newsForm.getDate());
        newsMessage.setBrief(newsForm.getBrief());
        newsMessage.setContent(newsForm.getContent());

        try(Service service = new Service()) {
            newsMessage = service.add(newsMessage);
            newsForm.setNewsMessage(newsMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }


        log.debug("Saving News");

        return mapping.findForward("success");
    }


    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response) {
        log.debug("Adding news");

        return mapping.findForward("add-news");
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
