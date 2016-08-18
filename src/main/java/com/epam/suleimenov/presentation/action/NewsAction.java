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
                log.debug("News View {}", news);

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




        log.debug("Editing news");
        log.debug("Editing news", ((NewsForm)form).getNewsMessage());
        String id = request.getParameter("news_id");
        int news_id;
        if(id != null) {
            news_id = Integer.parseInt(id);

            try(Service service = new Service()){
                News news = service.fetchById(news_id);
                NewsForm newsForm = (NewsForm) form;
                newsForm.setNewsMessage(news);
                log.debug("News Edit {}", news);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            log.debug("news id is not found");
            return mapping.findForward("failure");
        }

        return mapping.findForward("edit-news");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) {
        log.debug("Deleting News");

//        try(Service service = new Service()) {
//            NewsForm newsForm = (NewsForm) form;
//            for(String deleting: newsForm.getChecked()) {
//                service.remove(Integer.parseInt(deleting));
//            }
//            newsForm.setNewsList(service.getList());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return mapping.findForward("success");
    }

    public ActionForward cancel(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) {


        log.debug("Cancelling News");


        return mapping.findForward("news-list");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {

        try(Service service = new Service()) {
            NewsForm newsForm = (NewsForm) form;
            News news = new News();
            news.setBrief(newsForm.getBrief());
            news.setContent(newsForm.getContent());
            news.setDate(newsForm.getDate());
            news.setId(Integer.parseInt(newsForm.getId()));
            service.save(news);
            newsForm.setNewsMessage(news);

            log.debug("Saving {}" + news);
        } catch (Exception e) {
            e.printStackTrace();
        }




        return mapping.findForward("view-news");
    }


    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response) {
        log.debug("Adding news");

        NewsForm newsForm =(NewsForm) form;
        News news = new News();
        news.setContent(newsForm.getContent());
        news.setDate(newsForm.getDate());
        news.setTitle(newsForm.getTitle());
        news.setBrief(newsForm.getBrief());

        try(Service service = new Service()) {
            news = service.add(news);
            newsForm.setNewsMessage(news);
        } catch (Exception e) {
            e.printStackTrace();
        }


        log.debug("newsFrom in add {}", newsForm.getNewsMessage());

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
