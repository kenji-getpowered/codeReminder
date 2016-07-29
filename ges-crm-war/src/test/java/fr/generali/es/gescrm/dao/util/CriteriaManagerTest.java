package fr.generali.es.gescrm.dao.util;

import fr.generali.es.gescrm.common.CriteriaUtils;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;


public class CriteriaManagerTest {

    @Test
    public void generateWhereId(){
        Set<CriteriaField> criterias = new HashSet<CriteriaField>();
        CriteriaUtils.addIgnoreNull(criterias, "id_util",new Long(1234L));
        CriteriaManager criteriaManager = new CriteriaManager(criterias);
        final String where = criteriaManager.generateWhere();
        assertFalse("sould not contains like", where.toLowerCase().contains("like"));
    }
    @Test
    public void generateWhereNomAvecPrenomNull(){

        Set<CriteriaField> criterias = new HashSet<CriteriaField>();
        CriteriaUtils.addIgnoreNull(criterias, "util_prenom",null);
        CriteriaUtils.addIgnoreNull(criterias, "util_nom", "BIDOU");

        CriteriaManager criteriaManager = new CriteriaManager(criterias);
        final String where = criteriaManager.generateWhere();
        assertTrue("should contains like", where.toLowerCase().contains("like"));
        assertTrue("should contains %", where.toLowerCase().contains("%"));
        assertTrue("should contains where", where.toLowerCase().contains("where"));
        assertFalse("should not contains where and", where.toLowerCase().contains("where and"));
        assertFalse("should finish with and", where.toLowerCase().endsWith("and"));
        System.out.println(where);
    }
    @Test
    public void generateWhereNomAvecPrenomVide(){
        Set<CriteriaField> criterias = new HashSet<CriteriaField>();
        CriteriaUtils.addIgnoreNull(criterias, "util_prenom", "");
        CriteriaUtils.addIgnoreNull(criterias, "util_nom", "BIDOU");
        CriteriaManager criteriaManager = new CriteriaManager(criterias);
        final String where = criteriaManager.generateWhere();
        assertTrue("should contains like", where.toLowerCase().contains("like"));
        assertTrue("should contains %", where.toLowerCase().contains("%"));
        assertTrue("should contains where", where.toLowerCase().contains("where"));
        assertFalse("should not contains where and", where.toLowerCase().contains("where and"));
        assertFalse("should finish with and", where.toLowerCase().endsWith("and"));
    }
    @Test
    public void generateWhere(){
        Set<CriteriaField> criterias = new HashSet<CriteriaField>();
        CriteriaUtils.addIgnoreNull(criterias, "util_prenom", "patrice");
        CriteriaUtils.addIgnoreNull(criterias, "util_nom", "BIDOU");
        CriteriaUtils.addIgnoreNull(criterias, "id_util",  new Long(1234L));
        final Long value = 6666L;
        CriteriaUtils.addIgnoreNull(criterias, "id_util", value);
        CriteriaManager criteriaManager = new CriteriaManager(criterias);
        final String where = criteriaManager.generateWhere();
        System.out.println(where);
        assertTrue("should contains "+value, where.toLowerCase().contains(value.toString()));
    }
    @Test
    public void generateWhereMultiCriteria(){
        Set<CriteriaField> criterias = new HashSet<CriteriaField>();
        CriteriaUtils.addIgnoreNull(criterias, "util_prenom", "patrice");
        CriteriaUtils.addIgnoreNull(criterias, "util_nom", "BIDOU");
        CriteriaManager criteriaManager = new CriteriaManager(criterias);
        final String where = criteriaManager.generateWhere();
        assertTrue("should  contains like", where.toLowerCase().contains("patrice"));
        assertTrue("should  contains like", where.toLowerCase().contains("bidou"));
        assertTrue("sould contains %", where.toLowerCase().contains("where"));
        assertTrue("sould contains %", where.toLowerCase().contains("and"));
    }





}