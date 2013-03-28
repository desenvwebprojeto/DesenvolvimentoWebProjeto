package com.mycompany.trabalho_final.inscricao.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
public class StringValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String text = o.toString();
        if (!text.toLowerCase().matches("^[a-zA-ZéúíóáÉÚÍÓÁèùìòàÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ\\s]*$")) { 
            throw new ValidatorException(new FacesMessage("O campo \'" + uic.getAttributes().get("label") + "\' contém caracteres não permitidos."));
        } 
    }
}
