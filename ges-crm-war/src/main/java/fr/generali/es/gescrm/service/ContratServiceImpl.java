package fr.generali.es.gescrm.service;

import fr.generali.es.gescrm.dao.ContratDAO;
import fr.generali.es.gescrm.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 * Méthodes spécifiques pour les contrats
 */
@Service
public class ContratServiceImpl<String, Integer> extends BasicServiceImpl implements ContratService {

    @Autowired
    private ContratDAO dao;

    @Override
    public DAO getDao() {
        return dao;
    }
}
