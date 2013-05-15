package com.mycompany.trabalho_final.beans.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String text = o.toString();
        if (!text.toLowerCase().matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")) {
            throw new ValidatorException(new FacesMessage("O campo \'" + uic.getAttributes().get("label") + "\' é inválido. Verifique e tente novamente."));
        }
    }
}
