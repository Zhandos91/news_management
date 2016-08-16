package com.epam.suleimenov.presentation.action;


import com.epam.suleimenov.database.NewsDAO;
import com.epam.suleimenov.model.News;
import com.epam.suleimenov.service.Service;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class NewsAction extends LookupDispatchAction {

    private NewsDAO newsDAO;

    void setNewsDao(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }




        public ActionForward list(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

            System.out.println("In news_list action");
            try(Service service = new Service()) {
                News news = new News();
                news.setContent("This content is ");
                news.setBrief("brieflyy fff");
                news.setDate("12-12-2003");
                news.setTitle("title");
                service.add(news);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


            return mapping.findForward("success");
        }





//    void view();
//    void edit();
//    void delete();
//    void cancel();
//    void save();
//    void add();


    public ActionForward add(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {

        System.out.println("In add news action");


        return mapping.findForward("success");
    }


    @Override
    protected Map getKeyMethodMap() {

        Map keyMap = new HashMap();
        keyMap.put("news_list", "list");
        keyMap.put("add_news", "add");
        //keyMap.put("editKey", "edit");
       // keyMap.put("deleteKey", "delete");
        return keyMap;

    }

}
