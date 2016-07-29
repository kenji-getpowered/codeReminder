package fr.generali.es.gescrm.common;

import fr.generali.es.gescrm.dao.util.AssureCriteria;
import fr.generali.es.gescrm.dao.util.CriteriaField;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;
import fr.generali.es.gescrm.service.AssureService;
import fr.generali.es.gescrm.service.BasicService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @date 28/04/2016
 */
public final class ControllerUtils {


    /**
     * Basic retrieval of ModelAndView, includes pagination and is requested with any parameter
     *
     * @param page
     * @param session
     * @param service
     * @param criteriaManager
     * @param id
     * @return
     */
    public static ModelAndView getModelAndView(String page,
                                               HttpSession session,
                                               BasicService service,
                                               ICriteriaManager criteriaManager,
                                               Object id) {
        return doGetModelAndView(page, session, service, criteriaManager, id);
    }

    private  static ICriteriaManager emptyCriteriaManager = new AssureCriteria();

    /**
     * Basic retrieval of ModelAndView, includes pagination. All objects are requested
     *
     * @param page
     * @param session
     * @param service
     * @return
     */
    public static ModelAndView getModelAndView(String page,
                                               HttpSession session,
                                               BasicService service
    ) {
        return getModelAndView(page, session, service, emptyCriteriaManager, null);
    }

    private static ModelAndView doGetModelAndView(String page,
                                                  HttpSession session,
                                                  BasicService service,
                                                  ICriteriaManager criteriaManager,
                                                  Object id) {
        ModelAndView mav = new ModelAndView();
        PagedListHolder pagedListHolder = null;
        if (session != null) {
            pagedListHolder = (PagedListHolder) session.getAttribute("pagedListHolder");
        }

        if (pagedListHolder != null && page!=null && (criteriaManager.isEmpty())
                ) {
            if ("next".equals(page)) {
                pagedListHolder.nextPage();
            } else if ("previous".equals(page)) {
                pagedListHolder.previousPage();
            }
        } else {
            List list = Collections.emptyList();
            if (criteriaManager != null && !criteriaManager.isEmpty()) {
                list = service.search(criteriaManager);
            } else if (id != null) {
                list = new ArrayList(1);
                CollectionUtils.addIgnoreNull(list, service.get(id));
            } else {
                list = service.get();
            }
            pagedListHolder = new PagedListHolder(list);
            pagedListHolder.setPage(0);
        }
        int pageSize = 10;
        pagedListHolder.setPageSize(pageSize);
        mav.addObject("pagedListHolder", pagedListHolder);
        if (session != null) {
            session.setAttribute("pagedListHolder", pagedListHolder);
        }
        return mav;
    }


}
