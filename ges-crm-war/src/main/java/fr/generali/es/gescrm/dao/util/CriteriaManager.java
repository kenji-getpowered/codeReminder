package fr.generali.es.gescrm.dao.util;

import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @date 28/04/2016
 * This manager allows to generate the Where part for a request
 */
public class CriteriaManager implements ICriteriaManager {

    private Set<CriteriaField> criteria = null;

    public CriteriaManager(Set<CriteriaField> criteria) {
        this.criteria = criteria;
    }

    /**
     * This method generates a where condition based on the list of criteria
     * passed as constructor parameter
     * <ul>
     *     <li>String are compared in upper case</li>
     *     <li>Other does not receive pre treatment</li>
     * </ul>
     *
     * @return
     */
    public String generateWhere() {
        String where = "";
        if (criteria.size() > 0) {
            where += " WHERE";
            boolean isFirst = true;
            for (CriteriaField criteriaField : criteria) {
                    if (isFirst) {
                        try {
                            final String criteria = getCriteria(criteriaField);
                            if(!"".equals(criteria)){
                                where += criteria;
                                isFirst = false;
                            }
                        } catch (NoCriteriaException e) {
                            // continue
                        }
                    } else {
                        try {
                            final String criteria = getCriteria(criteriaField);
                            if(!"".equals(criteria)){
                                where += " AND" + criteria;
                            }
                        } catch (NoCriteriaException e) {
                            //
                        }
                    }

            }
        }
        return where;
    }

    @Override
    public boolean isEmpty() {
        return(criteria == null || criteria.isEmpty());
    }

    /**
     * return an empty String if anything goes wrong
     * @param criteria
     * @return
     * @throws NoCriteriaException
     */
    private String getCriteria(CriteriaField criteria) throws NoCriteriaException {
        String criteriaQuery = "";
        if (checkCriteria(criteria.getValue())) {
            if (criteria.getValue() instanceof String) {
                criteriaQuery += " UPPER(" + criteria.getFullName() + ") like '%" + ((String) criteria.getValue()).toUpperCase() + "%' ";
            } else {
                criteriaQuery += " " + criteria.getFullName() + " = " + criteria.getValue() + " ";
            }
        }
        return criteriaQuery;
    }

    private boolean checkCriteria(Object criteria) {
        return criteria != null && !"".equals(criteria);
    }
}