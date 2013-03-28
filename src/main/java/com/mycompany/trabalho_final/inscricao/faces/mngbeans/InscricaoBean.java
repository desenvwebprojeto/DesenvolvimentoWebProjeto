package com.mycompany.trabalho_final.inscricao.faces.mngbeans;

import com.mycompany.trabalho_final.controller.faces.support.PageBean;
import com.mycompany.trabalho_final.inscricao.faces.converter.CEPConverter;
import com.mycompany.trabalho_final.inscricao.faces.converter.CPFConverter;
import com.mycompany.trabalho_final.model.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
@ManagedBean
@RequestScoped
public class InscricaoBean extends PageBean {

    private Pessoa pessoa = new Pessoa();
    private CPFConverter cpfConverter = new CPFConverter();
    private CEPConverter cepConverter = new CEPConverter();
    private double valor = 100.00;
    private boolean cursoJava = false;
    private boolean cursoRuby = false;
    private boolean cursoPython = false;
    private boolean cursoHtml = false;
    private boolean cursoWebservice = false;

    public InscricaoBean() {
    }

    public void cadastroAction() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public CEPConverter getCepConverter() {
        return cepConverter;
    }

    public CPFConverter getCpfConverter() {
        return cpfConverter;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isCursoJava() {
        return cursoJava;
    }

    public boolean isCursoRuby() {
        return cursoRuby;
    }

    public boolean isCursoPython() {
        return cursoPython;
    }

    public boolean isCursoHtml() {
        return cursoHtml;
    }

    public boolean isCursoWebservice() {
        return cursoWebservice;
    }
}
