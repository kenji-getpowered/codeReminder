package fr.generali.es.gescrm.validator;

import fr.generali.es.gescrm.form.SearchAssureForm;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by b010ojm on 29/06/2016.
 */
@Component
public class SearchAssureValidator implements Validator {

    /**
     * This Validator validates *just* Person instances
     */
    public boolean supports(Class clazz) {
        return SearchAssureForm.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        //ValidationUtils.rejectIfEmpty(e, "name", "name.empty");

        SearchAssureForm form = (SearchAssureForm)obj;
        String id = StringUtils.defaultIfBlank(form.getIdentifiant(),"0");
        String idCre = StringUtils.defaultIfBlank(form.getIdentifiantCreelia(),"0");

        if (!NumberUtils.isNumber(id)) {
            e.rejectValue("identifiant", "{javax.validation.constraints.Digits.message}");
        }
        if (!NumberUtils.isNumber(idCre)) {
            e.rejectValue("identifiantCreelia", "{javax.validation.constraints.Digits.message}");
        }
    }
}
