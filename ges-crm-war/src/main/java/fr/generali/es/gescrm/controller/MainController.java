package fr.generali.es.gescrm.controller;

import fr.generali.ccj.comp.securite.gef2.client.Gef2Client;
import fr.generali.ccj.comp.securite.ihm.gef2.GefAuthenticationToken;
import fr.generali.es.gescrm.bean.Contact;
import fr.generali.es.gescrm.bean.ContactSummary;
import fr.generali.es.gescrm.bean.Contrat;
import fr.generali.es.gescrm.common.ControllerUtils;
import fr.generali.es.gescrm.common.CriteriaUtils;
import fr.generali.es.gescrm.dao.util.AssureCriteria;
import fr.generali.es.gescrm.dao.util.CriteriaField;
import fr.generali.es.gescrm.dao.util.CriteriaManager;
import fr.generali.es.gescrm.form.SearchAssureForm;
import fr.generali.es.gescrm.service.*;
import fr.generali.gef2.to.*;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

/**
 * Basic controller for GES CRM
 */
@Controller
public class MainController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private Gef2Client gef2Client;

    @Autowired
    private AssureService assureService;

    @Autowired
    private EntrepriseService entrepriseService;

    @Autowired
    private ContratService contratService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactSummaryService contactSummaryService;

//    @Autowired
//    private Validator searchAssureValidator;

    /*
     * to prevent uselese overloading of the server if the page index is called
     * a thousand time : premature optimization?
     */
    private static ModelAndView emptyMav = new ModelAndView();
    static{
        emptyMav.addObject("pagedListHolder", new PagedListHolder(Collections.emptyList()));
        emptyMav.setViewName("assure");
    }

    @RequestMapping("/index")
    public ModelAndView index(Map<String, Object> map, HttpSession session) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            logger.info(ReflectionToStringBuilder.toString(authentication));

            if (authentication.getClass().isAssignableFrom(GefAuthenticationToken.class)) {
                GefAuthenticationToken gef2Auth = (GefAuthenticationToken) authentication;
                logger.info(ReflectionToStringBuilder.toString(gef2Auth));
                IUserTOV2 user = gef2Client.searchUserV2(gef2Auth.getName());
                logger.info(ReflectionToStringBuilder.toString(user));
                session.setAttribute("gesUser",user);
            }
        }
        return emptyMav;
    }

    @RequestMapping("/assure")
    public ModelAndView listAssures(Map<String, Object> map,
                                    @RequestParam(value = "page", required = false) String page,
                                    HttpSession session) {
        ModelAndView mav = ControllerUtils.getModelAndView(page, session, assureService);
        return mav;
    }

    @RequestMapping("/assure/get")
    public ModelAndView getAssure(Map<String, Object> map,
                                  @RequestParam(value = "id_util", required = false, defaultValue = "0") Long id_util) {
        ModelAndView mav = new ModelAndView();

        // ASSURE
        mav.addObject("assure", assureService.get(id_util));

        Set<CriteriaField> criterias = new HashSet<CriteriaField>(1);
        CriteriaUtils.addIgnoreNull(criterias, "GC_UTIL","id_util", id_util);
        CriteriaManager cmAss = new CriteriaManager( criterias);

        // CONTRACTS
        List<Contrat> contrats = contratService.search(cmAss);
        mav.addObject("contrats", contrats);

        // CONTACT SUMMARY
        Set<CriteriaField> criteriasContact = new HashSet<CriteriaField>(1);
        CriteriaUtils.addIgnoreNull(criteriasContact, "id_util", id_util);
        CriteriaManager cmContact = new CriteriaManager( criteriasContact);
        List<ContactSummary> contactSummaries = contactSummaryService.search(cmContact);
        mav.addObject("contactSummaries", contactSummaries);

        // ALL CONTACS
        List<Contact>  contacts = contactService.search(cmContact);
        mav.addObject("contacts", contacts);

        mav.setViewName("infoAssure");
        return mav;
    }

    @RequestMapping("/assure/resetmdp")
    public String resetPassword(Map<String, Object> map,
                                @RequestParam(value = "id_util", required = false, defaultValue = "0") Long id_util) {
        assureService.resetPassword(id_util);
        return "assure";
    }

//    @RequestMapping(value = "/assure/search")
//    public ModelAndView searchAssure(Map<String, Object> map,
//                               @RequestParam(value = "page", required = false) String page,
//                               @RequestParam(value = "id_util", required = false, defaultValue = "0") Long id_util,
//                               @RequestParam(value = "util_identifiant", required = false, defaultValue = "0") Long util_identifiant,
//                               @RequestParam(value = "util_nom", required = false) String util_nom,
//                               @RequestParam(value = "util_prenom", required = false) String util_prenom,
//                               @RequestParam(value = "agent", required = false) String agent,
//                               HttpSession session ) {
//        AssureCriteria ac = new AssureCriteria();
//        ac.szIdentifiant = id_util;
//        ac.szIdentifiantCreelia = util_identifiant;
//        ac.szNom = util_nom;
//        ac.szPrenom = util_prenom;
//        ac.szAgent = agent;
//        ModelAndView mav = ControllerUtils.getModelAndView(page, session, assureService, ac, null);
//        mav.setViewName("assure");
//        return mav;
//    }
@RequestMapping(value = "/assure/search")
    public ModelAndView searchAssure(@ModelAttribute("searchAssureForm")  @Valid SearchAssureForm saForm,
                                    BindingResult result,
                                     HttpSession session ) {

        //searchAssureValidator.validate(saForm,result);

        if (result.hasErrors()) {
            PagedListHolder pagedListHolder = null;
            if (session != null) {
                pagedListHolder = (PagedListHolder) session.getAttribute("pagedListHolder");
            }
            if (pagedListHolder == null) {
                pagedListHolder = new PagedListHolder();
            }

            ModelAndView errorMav = new ModelAndView("assure", result.getModel());
            errorMav.addObject("pagedListHolder",pagedListHolder);
            errorMav.addObject("errors",result);
            session.setAttribute("pagedListHolder",pagedListHolder);
            return errorMav;
        }

        AssureCriteria ac = new AssureCriteria();

        String id = StringUtils.defaultIfBlank(saForm.getIdentifiant(),"0");
        String idCreelia = StringUtils.defaultIfBlank(saForm.getIdentifiantCreelia(),"0");
        ac.szIdentifiant = NumberUtils.createLong(id);
        ac.szIdentifiantCreelia =NumberUtils.createLong(idCreelia);
        ac.szNom = saForm.getNom();
        ac.szPrenom = saForm.getPrenom();
        ac.szAgent = saForm.getCodeAgent();
        ModelAndView mav = ControllerUtils.getModelAndView(saForm.getPage(), session, assureService, ac, null);
        mav.setViewName("assure");

    //mav.addAllObjects(saForm.asMap());
 //       mav.addAllObjects(saForm.getFormProperties());
        return mav;
    }


    @RequestMapping(value = "/entreprise/search")
    public ModelAndView searchEntreprise(Map<String, Object> map,
                               @RequestParam(value = "page", required = false) String page,
                               @RequestParam(value = "id_util", required = false) Long id_util,
                               @RequestParam(value = "util_identifiant", required = false) Long util_identifiant,
                               @RequestParam(value = "util_nom", required = false) String util_nom,
                               @RequestParam(value = "util_prenom", required = false) String util_prenom,
                               @RequestParam(value = "agent", required = false) String agent,
                               HttpSession session ) {
        Set<CriteriaField> params = new HashSet<CriteriaField>(5);
        CriteriaManager cm = new CriteriaManager(params);
        ModelAndView mav = ControllerUtils.getModelAndView(page, session, entrepriseService, cm, null);
        mav.setViewName("entreprise");
        return mav;
    }

    @RequestMapping("/entreprise")
    public ModelAndView listEntreprises(Map<String, Object> map,
                                    @RequestParam(value = "page", required = false) String page,
                                    HttpSession session  ) {
        ModelAndView mav = ControllerUtils.getModelAndView(page, session, entrepriseService);
        return mav;
    }

    @RequestMapping("/entreprise/get/{id}")
    public String getEntreprise(Map<String, Object> map, Integer entrepriseId) {
        map.put("entreprise", entrepriseService.get(entrepriseId));
        return "entreprise";
    }

    @RequestMapping("/entreprise/search/{id}")
    public String searchEntreprise(Map<String, Object> map, Integer contactId) {
        return "entreprise";
    }


    @RequestMapping("/contrat/")
    public ModelAndView listContrat(Map<String, Object> map,
                                    @RequestParam(value = "page", required = false) String page,
                                    HttpSession session) {
        ModelAndView mav = ControllerUtils.getModelAndView(page, session, contratService);
        return mav;
    }

    @RequestMapping("/contrat/get")
    public ModelAndView getContrat(Map<String, Object> map,
                                  @RequestParam(value = "id_util", required = false, defaultValue = "0") Long id_util) {
        ModelAndView mav = new ModelAndView();//ControllerUtils.getModelAndViewFromId(null, contratService, null, null, id_util);
        mav.setViewName("contrat");
        return mav;
    }

    @RequestMapping(value = "/contrat/search")
    public ModelAndView searchContrat(Map<String, Object> map,
                                     @RequestParam(value = "page", required = false) String page,
                                     @RequestParam(value = "id_contrat", required = false, defaultValue = "0") Long id_util,
                                     @RequestParam(value = "util_identifiant", required = false, defaultValue = "0") Long util_identifiant,
                                     @RequestParam(value = "util_nom", required = false) String util_nom,
                                     @RequestParam(value = "util_prenom", required = false) String util_prenom,
                                     @RequestParam(value = "agent", required = false) String agent,
                                     HttpSession session ) {
        Set<CriteriaField> params = new HashSet<CriteriaField>(5);
//        CriteriaUtils.addIgnoreNull(params, "id_contrat", id_util);
//        CriteriaUtils.addIgnoreNull(params, "GC_UTIL", "id_util", id_util);
        CriteriaManager cm = new CriteriaManager(params);
        ModelAndView mav = ControllerUtils.getModelAndView(page, session, contratService, cm, null);
        return mav;
    }


    @RequestMapping({"/","/login"})
    public String login(Map<String, Object> map) {

        return "login";
    }

    // Exemple moche de test
    @RequestMapping({"/loginCRM"})
    public RedirectView loginCRM(@RequestParam(value = "identifiant", required = true) String identifiant,
                                 @RequestParam(value = "id_reseau", required = true) String idReseau) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( authentication.getClass().isAssignableFrom(GefAuthenticationToken.class)) {
            GefAuthenticationToken gef2Auth = (GefAuthenticationToken) authentication;
            logger.info(ReflectionToStringBuilder.toString(authentication));
            if (gef2Auth != null) {
                IJetonTO jeton = gef2Auth.getGefToken();
                IAnnuaireTO annuaire = jeton.getAuthentification().getAnnuaire();
                IApplicationTO appli = jeton.getApplication();
                logger.debug(ReflectionToStringBuilder.toString(jeton));
                ITransitionTO transition = gef2Client.creerTransition(jeton, annuaire, appli);
                logger.debug("", ReflectionToStringBuilder.toString(transition));

                // TODO : add Gef2 params as headers instead of query params
//                String redirectUrl = String.format("/perso/loginCRM.do?identifiant=%s&id_reseau=%s&id_agent=%s&GEF2JetonId=%s&GEF2TransitionId=%s" ,
//                        identifiant,idReseau, gef2Auth.getName(), jeton.getJetonId() , transition.getTransitionId());
                String redirectUrl = "/perso/loginCRM.do";
                logger.info("Branchement vers CRM via {}",redirectUrl);
                RedirectView rv = new RedirectView(redirectUrl);
                rv.addStaticAttribute("identifiant",identifiant);
                rv.addStaticAttribute("id_reseau",idReseau);
                rv.addStaticAttribute("id_agent",gef2Auth.getName());
                rv.addStaticAttribute("GEF2JetonId",jeton.getJetonId());
                rv.addStaticAttribute("GEF2TransitionId",transition.getTransitionId());
                return rv;
//                return new RedirectView(redirectUrl);
            }
        }
        return new RedirectView("login");
    }
}
