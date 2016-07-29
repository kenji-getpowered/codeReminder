package fr.generali.es.gescrm.common;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CriteriaUtilsTest {

    @Test
    public void testAddIgnoreNull() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        String param1Name = "param1";
        String param1Value = "param1Value";
        String param2Name = "param2";
        Long param2Value = 3l;

        // 0 is a default value and should not be added
        String param0Name = "param3";
//        Long param0Value = 0l;
//        CriteriaUtils.addIgnoreNull(map,param1Name,param1Value);
//        assertEquals("only one parameter is expected", 1, map.size());
//        CriteriaUtils.addIgnoreNull(map, param2Name, param2Value);
//        assertEquals("exactly 2 parameters are expected", 2, map.size());
//        assertEquals("3 is expected", "3", map.get("param2"));
//
//        // Special case when inserting a   default value for long => 0 means null
//        CriteriaUtils.addIgnoreNull(map, param0Name, param0Value);
//        assertEquals("yet exactly 2 parameters are expected", 2, map.size());
//        assertEquals("3 is expected", "3", map.get("param2"));
//
//        map = new HashMap<String, String>();
//        String param3Name = "param3";
//        CriteriaUtils.addIgnoreNull(map,param3Name,null);
//        assertTrue("nothing has been added", map.isEmpty());
//        CriteriaUtils.addIgnoreNull(map,null,"test");
//        assertTrue("nothing has been added", map.isEmpty());
//        CriteriaUtils.addIgnoreNull(null, param3Name, null);
//        assertTrue("nothing has been added", map.isEmpty());
    }
}