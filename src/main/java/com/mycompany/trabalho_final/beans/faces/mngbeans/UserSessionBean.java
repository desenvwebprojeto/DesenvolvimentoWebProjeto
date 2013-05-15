package com.mycompany.trabalho_final.beans.faces.mngbeans;

import com.mycompany.trabalho_final.beans.faces.converter.CEPConverter;
import com.mycompany.trabalho_final.beans.faces.converter.CPFConverter;
import com.mycompany.trabalho_final.beans.faces.validator.AlphaNumericValidator;
import com.mycompany.trabalho_final.beans.faces.validator.CPFValidator;
import com.mycompany.trabalho_final.beans.faces.validator.EmailValidator;
import com.mycompany.trabalho_final.beans.faces.validator.StringValidator;
import com.mycompany.trabalho_final.controller.faces.support.PageBean;
import com.mycompany.trabalho_final.controller.persistence.CursoPessoaJpaController;
import com.mycompany.trabalho_final.controller.persistence.PessoaJpaController;
import com.mycompany.trabalho_final.model.persistence.entity.Cursopessoa;
import com.mycompany.trabalho_final.model.persistence.entity.CursopessoaPK;
import com.mycompany.trabalho_final.model.persistence.entity.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
@ManagedBean
@RequestScoped
public class UserSessionBean extends PageBean {

    private Pessoa pessoa = new Pessoa();
    private CPFConverter cpfConverter = new CPFConverter();
    private CEPConverter cepConverter = new CEPConverter();
    private CPFValidator cpfValidator = new CPFValidator();
    private StringValidator stringValidator = new StringValidator();
    private AlphaNumericValidator alphaNumericValidator = new AlphaNumericValidator();
    private EmailValidator emailValidator = new EmailValidator();
    private Long cpf;
    private String email = "";
    private String erro = "";
    private boolean cursoJava = false;
    private boolean cursoRuby = false;
    private boolean cursoPython = false;
    private boolean cursoHtml = false;
    private boolean cursoWebservice = false;

    public UserSessionBean() {
    }

    public String realizaLogin() {
        pessoa = new PessoaJpaController().findByCpf(cpf);
        if (pessoa != null) {
            if (pessoa.getEmail().equals(this.email)) {
                CursoPessoaJpaController cpjpa = new CursoPessoaJpaController();
                cursoJava = cpjpa.findByCpf(1, cpf);
                cursoPython = cpjpa.findByCpf(2, cpf);
                cursoRuby = cpjpa.findByCpf(3, cpf);
                cursoHtml = cpjpa.findByCpf(4, cpf);
                cursoWebservice = cpjpa.findByCpf(5, cpf);
                return "edicao_dados.xhtml";
            } else {
                erro = "E-Mail digitado incorreto";
                return "erro_login_user";
            }
        } else {
            erro = "CPF digitado incorreto.";
            return "erro_login_user";
        }
    }

    public String update() {
        PessoaJpaController pjpa = new PessoaJpaController();
        CursoPessoaJpaController cpjpa = new CursoPessoaJpaController();
        pjpa.update(pessoa);
        Cursopessoa cp1 = new Cursopessoa(new CursopessoaPK(1, pessoa.getCpf()), cursoJava);
        Cursopessoa cp2 = new Cursopessoa(new CursopessoaPK(2, pessoa.getCpf()), cursoPython);
        Cursopessoa cp3 = new Cursopessoa(new CursopessoaPK(3, pessoa.getCpf()), cursoRuby);
        Cursopessoa cp4 = new Cursopessoa(new CursopessoaPK(4, pessoa.getCpf()), cursoHtml);
        Cursopessoa cp5 = new Cursopessoa(new CursopessoaPK(5, pessoa.getCpf()), cursoWebservice);
        cpjpa.update(cp1);
        cpjpa.update(cp2);
        cpjpa.update(cp3);
        cpjpa.update(cp4);
        cpjpa.update(cp5);
        return "/edicao_dados_sucesso.xhtml";
    }

    public CPFConverter getCpfConverter() {
        return cpfConverter;
    }

    public CPFValidator getCpfValidator() {
        return cpfValidator;
    }

    public EmailValidator getEmailValidator() {
        return emailValidator;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getErro() {
        return erro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public CEPConverter getCepConverter() {
        return cepConverter;
    }

    public StringValidator getStringValidator() {
        return stringValidator;
    }

    public AlphaNumericValidator getAlphaNumericValidator() {
        return alphaNumericValidator;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isCursoJava() {
        return cursoJava;
    }

    public void setCursoJava(boolean cursoJava) {
        this.cursoJava = cursoJava;
    }

    public boolean isCursoRuby() {
        return cursoRuby;
    }

    public void setCursoRuby(boolean cursoRuby) {
        this.cursoRuby = cursoRuby;
    }

    public boolean isCursoPython() {
        return cursoPython;
    }

    public void setCursoPython(boolean cursoPython) {
        this.cursoPython = cursoPython;
    }

    public boolean isCursoHtml() {
        return cursoHtml;
    }

    public void setCursoHtml(boolean cursoHtml) {
        this.cursoHtml = cursoHtml;
    }

    public boolean isCursoWebservice() {
        return cursoWebservice;
    }

    public void setCursoWebservice(boolean cursoWebservice) {
        this.cursoWebservice = cursoWebservice;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
