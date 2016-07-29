package fr.generali.es.gescrm.service;

import fr.generali.es.gescrm.dao.DAO;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @param <T> Basic object
 * @param <I> Identifier
 * @date 26/04/2016
 */
public interface BasicService<T, I> {

    /**
     * Basic method for retrieving the information
     *
     * @param id
     * @return
     */
    @Transactional
    T get(I id);

    @Transactional
    List<T> get();

    @Transactional
    List<T> search(ICriteriaManager criteriaManager);

    /**
     * Retrieve the DAO associated to the service
     *
     * @return
     */
    DAO<T, I> getDao();
}
