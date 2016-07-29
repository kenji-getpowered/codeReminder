package fr.generali.es.gescrm.dao;

import fr.generali.es.gescrm.dao.util.CriteriaField;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @author Mikael KROK (b002ksc)
 * @param <T> Basic object
 * @param <I> Identifier
 * @date 26/04/2016
 */
public abstract class BasicDAO<T, I> implements DAO<T, I> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public T get(I id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> get() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void put(T object) {
        this.getSession().save(object);
    }


    @Override
    public void delete(I id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> search(ICriteriaManager criterias) {
        throw new UnsupportedOperationException();
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
