/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.inscricao.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Wilson
 */
public class CPFValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String cpf = String.format("%011d", (Long) o);
        if (!cpf.matches("\\d{11}")) {        
            throw new ValidatorException(new FacesMessage("CPF \'" + cpf + "\' em formato incorreto."));
        } else {
            
            if (!this.isValidCpf(cpf)) {
                throw new ValidatorException(new FacesMessage("CPF \'" + cpf + "\' inválido"));
            }
        }
    }
    
    private boolean isValidCpf(String cpf) {
        int[] a = new int[cpf.length()];
        int b = 0;
        int c = 11;

        for (int i = 0; i < cpf.length(); i++) {
            a[i] = Integer.parseInt(cpf.substring(i, i + 1));
            if (i < 9) {
                c--;
                b += a[i] * c;
            }
        }
        if ((b % 11) < 2) {
            a[9] = 0;
        } else {
            a[9] = 11 - (b % 11);
        }
        b = 0;
        c = 11;
        for (int i = 0; i < cpf.length() - 1; i++) {
            b += a[i] * c;
            c--;
        }
        if ((b % 11) < 2) {
            a[10] = 0;
        } else {
            a[10] = 11 - (b % 11);
        }

        if ((cpf.charAt(9) != String.valueOf(a[9]).charAt(0) || (cpf.charAt(10) != String.valueOf(a[10]).charAt(0)))) {
            return false;
        } else {
            return true;
        }
    }
}
