package com.mycompany.trabalho_final.inscricao.faces.mngbeans;

import com.mycompany.trabalho_final.controller.faces.support.FacesBean;
import com.mycompany.trabalho_final.model.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
@ManagedBean
@RequestScoped
public class InscricaoBean extends FacesBean {

    private Pessoa pessoa = new Pessoa();
    
    public InscricaoBean() {
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }
}
