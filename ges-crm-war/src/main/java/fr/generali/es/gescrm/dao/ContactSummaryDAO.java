package fr.generali.es.gescrm.dao;

import fr.generali.es.gescrm.dao.util.CriteriaManager;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @param <ContactSummary> Basic object
 * @param <String> Identifier it is identified with the id_util of the user
 * @date 26/04/2016
 */
@Repository
public class ContactSummaryDAO<ContactSummary, String> extends BasicDAO implements DAO {

    private static final java.lang.String SQL_CONTACT_SUMMARY = "SELECT  CONT_CANAL,  CONT_SENS, COUNT(*) as NB FROM CC_CONTACT";

    @Override
    public List<ContactSummary> search(ICriteriaManager criteriaManager) {
        java.lang.String zeQuery =
                SQL_CONTACT_SUMMARY;
        zeQuery += criteriaManager.generateWhere();
        zeQuery += " GROUP BY CONT_CANAL, CONT_SENS";
        Query query = this.getSession().createSQLQuery(zeQuery).addEntity(fr.generali.es.gescrm.bean.ContactSummary.class);
        List<ContactSummary> list = query.list();
        return list;
    }
}