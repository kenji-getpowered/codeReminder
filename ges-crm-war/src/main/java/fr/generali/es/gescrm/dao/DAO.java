package fr.generali.es.gescrm.dao;

import fr.generali.es.gescrm.dao.util.CriteriaField;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;

import java.util.List;
import java.util.Set;

/**
 * @param <T> Basic object
 * @param <I> Identifier
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 */
public interface DAO<T, I> {

    /**
     * Basic method for retrieving an object
     * Planned basically to retrieve information for
     * a screen or a table
     *
     * @param id
     * @return
     */
    T get(I id);

    /**
     * Basic method for retrieving all objects
     * Planned basically to retrieve information for
     * a screen or a table
     *
     * @return
     */
    List<T> get();

    /**
     * Method for saving the light object
     *
     * @param object
     */
    void put(T object);

    /**
     * @param id
     */
    void delete(I id);

    /**
     * This methods allows to search the object through SQL criteria
     * The Where clause will be built upon that Map.
     * It allows any kind of type.
     *
     * @return
     * @param criterias
     */
    List<T> search(ICriteriaManager criterias);

}
