package fr.generali.es.gescrm.service;

import fr.generali.es.gescrm.dao.ContactSummaryDAO;
import fr.generali.es.gescrm.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mikael KROK (b002ksc)
 * @date 16/05/2016
 * Méthodes spécifiques pour les sommaires de contacts
 */
@Service
public class ContactSummaryServiceImpl<String, Integer> extends BasicServiceImpl implements ContactSummaryService {

    @Autowired
    private ContactSummaryDAO dao;

    @Override
    public DAO getDao() {
        return dao;
    }
}
