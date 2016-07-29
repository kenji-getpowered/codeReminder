package fr.generali.es.gescrm.common;

import fr.generali.es.gescrm.dao.util.CriteriaField;

import java.util.Map;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 */
public class CriteriaUtils {

    public static void addIgnoreNull(Set<CriteriaField> params, String paramName, Object paramValue) {
        addIgnoreNull(params, null, paramName, paramValue);
    }

    public static void addIgnoreNull(Set<CriteriaField> params,String tableName, String paramName, Object paramValue) {
        if (params != null && paramName != null && paramValue != null) {
           if(!(paramValue instanceof Long && ((Long) paramValue).equals(0l) )){
               final CriteriaField criteriaField = new CriteriaField(tableName, paramName, paramValue);
               if(!params.add(criteriaField)) {
                   params.remove(criteriaField);
                   params.add(criteriaField);
               }
           }
        }
    }
}
