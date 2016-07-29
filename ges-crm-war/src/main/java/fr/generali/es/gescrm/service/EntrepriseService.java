package fr.generali.es.gescrm.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 * Méthodes spécifiques pour les entreprises
 */
public interface EntrepriseService extends BasicService {

    @Transactional
    void updateAbondements(Long idEntreprise, int annee);
}
