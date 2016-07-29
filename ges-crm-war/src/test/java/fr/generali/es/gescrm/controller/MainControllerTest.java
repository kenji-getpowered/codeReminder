package fr.generali.es.gescrm.controller;

import fr.generali.ccj.comp.securite.gef2.client.Gef2Client;
import fr.generali.es.gescrm.bean.Assure;
import fr.generali.es.gescrm.bean.Contrat;
import fr.generali.es.gescrm.common.CriteriaUtils;
import fr.generali.es.gescrm.dao.util.CriteriaField;
import fr.generali.es.gescrm.service.AssureService;
import fr.generali.es.gescrm.service.ContactService;
import fr.generali.es.gescrm.service.ContactSummaryService;
import fr.generali.es.gescrm.service.ContratService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class MainControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    @Mock
    Gef2Client gef2Client;

    @Mock
    AssureService assureService;

    @Mock
    ContratService contratService;

    @Mock
    ContactService contactService;

    @Mock
    ContactSummaryService contactSummaryService;

    @InjectMocks
    MainController mainController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        MockitoAnnotations.initMocks(this);
        // If we use this soluion, Spring use its own mocking service
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
        // With this solution : the object mainController is mocked by mockito
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/index/").accept(MediaType.TEXT_PLAIN))
                .andDo(print()) // print the request/response in the console
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("assure"));
    }

    @Test
    public void testListAssures() throws Exception {

    }

    @Test
    public void testGetAssure() throws Exception {
        Long idUtil = Long.parseLong("2002007029");
        Map<String, String> map = new HashMap<String, String>();
        Assure assure = new Assure();
        assure.setCindCodePostal("81000");
        assure.setCindVille("Albi");
        assure.setCodeAgent("agent");
        assure.setIdCivilite("1");
        assure.setIdentifiant(idUtil);
        assure.setNom("nom");
        assure.setPrenom("prenom");

        Contrat contrat = new Contrat();
        contrat.setCindVille("GAILLAC");
        contrat.setAgtCd("agent");
        contrat.setAgtNom("agentNom");
        contrat.setAgtPrenom("setAgtPrenom");
        contrat.setCindCodPostal("81320");

        // WHEN
        when(assureService.get(idUtil)).thenReturn(assure);
        when(contratService.get(idUtil)).thenReturn(contrat);
        when(contactService.get(idUtil)).thenReturn(Collections.emptyList());
        when(contratService.get(idUtil)).thenReturn(Collections.emptyList());

        //THEN
        // 1/  we check that the MVC road lead to the proper view
        final MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/assure/get?id_util=2002007029").accept(MediaType.TEXT_PLAIN))
                .andDo(print()) // print the request/response in the console
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("infoAssure")).andReturn();

        // 2/ We check the content returned in the page - it should be the mocked one
        final Assure assure1 = (Assure) mvcResult.getModelAndView().getModel().get("assure");
        assertNotNull(assure1);
        assertTrue(assure1.getNom().equals("nom"));

        // 3/ We check the contrat associated - it should be the mocked one
        final List<Contrat> list = (List) mvcResult.getModelAndView().getModel().get("contrats");
        assertNotNull(list);
        for (int i = 0; i < list.size() ; i++) {
            list.get(i).getAgtNom().equals("agentNom");
        }
        assertTrue(assure1.getNom().equals("nom"));

    }

    @Test
    public void testResetPassword() throws Exception {

    }

    @Test
    public void testSearchAssure() throws Exception {
        Long idUtil = Long.parseLong("2002007029");
        Set<CriteriaField> map = new HashSet<CriteriaField>();
        CriteriaUtils.addIgnoreNull(map,"GC_UTIL","util_nom", "KRO");
        Assure assure1 = new Assure();
        assure1.setCindCodePostal("81000");
        assure1.setCindVille("Albi");
        assure1.setCodeAgent("agent");
        assure1.setIdCivilite("1");
        assure1.setIdentifiant(idUtil);
        assure1.setNom("KROK");

        Assure assure2 = new Assure();
        assure2.setCindCodePostal("81000");
        assure2.setCindVille("Toulouse");
        assure2.setCodeAgent("agent");
        assure2.setIdCivilite("1");
        assure2.setIdentifiant(idUtil);
        assure2.setNom("KROTAL");

        Assure assure3 = new Assure();
        assure3.setCindCodePostal("81000");
        assure3.setCindVille("Toulouse");
        assure3.setCodeAgent("agent");
        assure3.setIdCivilite("1");
        assure3.setIdentifiant(idUtil);
        assure3.setNom("KROS");

        List<Assure> result = new ArrayList<Assure>();
        result.add(assure1);
        result.add(assure2);
        result.add(assure3);
//
//        when(assureService.search(map)).thenReturn(result);
//
//
//        // 1/  we check that the MVC road lead to the proper view
//        final MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders.get("/assure/search?util_nom=KRO").accept(MediaType.TEXT_PLAIN))
//                .andDo(print()) // print the request/response in the console
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.forwardedUrl("assure")).andReturn();
//
//        // 2/ We check the content returned in the page - it should be the mocked one
//        final PagedListHolder pagedListHolder = (PagedListHolder) mvcResult.getModelAndView().getModel().get("pagedListHolder");
//        final List pageList = pagedListHolder.getPageList();
//
//        assertNotNull(pageList);
//        assertFalse(pageList.isEmpty());
//        assertEquals(3, pageList.size());
//
//        for (Object item : pageList) {
//            assertTrue(item instanceof  Assure);
//            Assure assureItem = (Assure) item;
//            assertTrue(assureItem.getNom().contains("KRO"));
//        }
    }


    @Test
    public void testSearchEntreprise() throws Exception {

    }

    @Test
    public void testListEntreprises() throws Exception {

    }

    @Test
    public void testGetEntreprise() throws Exception {

    }

    @Test
    public void testSearchEntreprise1() throws Exception {

    }

    @Test
    public void testLogin() throws Exception {

    }
}