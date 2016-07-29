package fr.generali.es.gescrm.service;

import fr.generali.es.gescrm.dao.util.ICriteriaManager;

import java.util.List;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @param <T> Basic object
 * @param <I> Identifier
 * @date 26/04/2016
 */
public abstract class  BasicServiceImpl<T, I> implements BasicService<T, I> {

    @Override
    public T get(I id) {
        return getDao().get(id);
    }

    @Override
    public List<T> get() {
        return getDao().get();
    }

    @Override
    public List<T> search(ICriteriaManager params) {
        return getDao().search(params);
    }


}
