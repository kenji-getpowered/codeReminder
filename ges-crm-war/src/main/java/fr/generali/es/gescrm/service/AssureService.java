package fr.generali.es.gescrm.service;

import fr.generali.es.gescrm.dao.util.AssureCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mikael KROK (b002ksc)
 * @date 26/04/2016
 * Méthodes spécifiques pour les assures
 */
public interface AssureService extends BasicService {

    @Transactional
    void resetPassword(Long id);

}
