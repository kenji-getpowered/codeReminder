package fr.generali.es.gescrm.service;

import fr.generali.es.gescrm.dao.util.AssureCriteria;
import fr.generali.es.gescrm.dao.AssureDAO;
import fr.generali.es.gescrm.dao.DAO;
import fr.generali.es.gescrm.dao.util.ICriteriaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 * Méthodes spécifiques pour les assures
 */
@Service
public class AssureServiceImpl<String, Integer> extends BasicServiceImpl implements AssureService {

    @Autowired
    private AssureDAO dao;

    @Override
    public DAO getDao() {
        return dao;
    }

    @Override
    public void resetPassword(Long id) {
        dao.resetPassword(id);
    }

    @Override
    public List search(ICriteriaManager criterias) {
        return dao.search(criterias);
    }

}
