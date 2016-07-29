package fr.generali.es.gescrm.service;

import fr.generali.es.gescrm.dao.ContactDAO;
import fr.generali.es.gescrm.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mikael KROK (b002ksc)
 * @date 16/05/2016
 * Méthodes spécifiques pour les contrats
 */
@Service
public class ContactServiceImpl<String, Integer> extends BasicServiceImpl implements ContactService{

    @Autowired
    private ContactDAO dao;

    @Override
    public DAO getDao() {
        return dao;
    }

}
