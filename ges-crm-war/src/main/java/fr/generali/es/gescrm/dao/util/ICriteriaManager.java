package fr.generali.es.gescrm.dao.util;

/**
 * @author Mikael KROK (b002ksc)
 * @date 09/06/2016
 */
public interface ICriteriaManager {

    String generateWhere();

    boolean isEmpty();
}
