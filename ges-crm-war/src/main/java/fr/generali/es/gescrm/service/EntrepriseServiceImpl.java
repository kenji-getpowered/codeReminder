package fr.generali.es.gescrm.service;

import fr.generali.es.gescrm.dao.DAO;
import fr.generali.es.gescrm.dao.EntrepriseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 * Méthodes spécifiques pour les entreprises
 */
@Service
public class EntrepriseServiceImpl<String, Integer> extends BasicServiceImpl implements EntrepriseService {

    @Autowired
    private EntrepriseDAO dao;

    @Override
    public DAO getDao() {
        return dao;
    }

    @Override
    public void updateAbondements(Long idEntreprise, int annee) {
        dao.updateAbondements(idEntreprise, annee);
    }
}
