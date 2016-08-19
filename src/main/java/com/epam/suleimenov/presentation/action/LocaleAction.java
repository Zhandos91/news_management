package com.epam.suleimenov.presentation.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocaleAction extends LookupDispatchAction {


    private final Locale ENGLISH = Locale.ENGLISH;
    private final Locale RUSSIAN = new Locale("ru", "RU");
    private final String LOCALE = "org.apache.struts.action.LOCALE";

    public ActionForward english(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {

        request.getSession().setAttribute(LOCALE, ENGLISH);

        return mapping.findForward("success");

    }

    public ActionForward russian(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        request.getSession().setAttribute(LOCALE, RUSSIAN);

        return mapping.findForward("success");

    }

    @Override
    protected Map getKeyMethodMap() {
        Map keyMap = new HashMap();
        keyMap.put("lang_ru", "russian");
        keyMap.put("lang_en", "english");

        return keyMap;
    }
}
