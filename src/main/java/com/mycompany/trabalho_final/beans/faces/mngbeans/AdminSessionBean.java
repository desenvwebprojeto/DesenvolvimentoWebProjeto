package com.mycompany.trabalho_final.beans.faces.mngbeans;

import com.mycompany.trabalho_final.beans.faces.converter.CEPConverter;
import com.mycompany.trabalho_final.beans.faces.converter.CPFConverter;
import com.mycompany.trabalho_final.beans.faces.validator.AlphaNumericValidator;
import com.mycompany.trabalho_final.beans.faces.validator.CPFValidator;
import com.mycompany.trabalho_final.beans.faces.validator.EmailValidator;
import com.mycompany.trabalho_final.beans.faces.validator.StringValidator;
import com.mycompany.trabalho_final.controller.faces.support.PageBean;
import com.mycompany.trabalho_final.controller.persistence.AdministracaoJpaController;
import com.mycompany.trabalho_final.controller.persistence.CursoPessoaJpaController;
import com.mycompany.trabalho_final.controller.persistence.PessoaJpaController;
import com.mycompany.trabalho_final.model.persistence.entity.Administracao;
import com.mycompany.trabalho_final.model.persistence.entity.Cursopessoa;
import com.mycompany.trabalho_final.model.persistence.entity.CursopessoaPK;
import com.mycompany.trabalho_final.model.persistence.entity.Pessoa;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
@ManagedBean
@SessionScoped
public class AdminSessionBean extends PageBean {

    private Pessoa pessoa;
    private List<Pessoa> inscritos;
    private CPFConverter cpfConverter = new CPFConverter();
    private CEPConverter cepConverter = new CEPConverter();
    private CPFValidator cpfValidator = new CPFValidator();
    private StringValidator stringValidator = new StringValidator();
    private AlphaNumericValidator alphaNumericValidator = new AlphaNumericValidator();
    private EmailValidator emailValidator = new EmailValidator();
    private String username = "";
    private String password = "";
    private String erro = "";
    private boolean cursoJava = false;
    private boolean cursoRuby = false;
    private boolean cursoPython = false;
    private boolean cursoHtml = false;
    private boolean cursoWebservice = false;

    public AdminSessionBean() {
    }

    public String realizaLogin() {
        Administracao admin = new AdministracaoJpaController().findByUsername(username);
        if (admin != null) {
            if (admin.getPassword().equals(this.password)) {
                return "lista_usuarios_admin.xhtml";
            } else {
                erro = "Senha digitada incorreta.";
                return "erro_login_admin.xhtml";
            }
        } else {
            erro = "Nome de usuário digitado incorreto.";
            return "erro_login_admin.xhtml";
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
        inscritos = pjpa.findAll();
        return "/edicao_dados_admin_sucesso.xhtml";
    }

    public void preRender() {
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param = parameterMap.get("cpf");
        Long cpf = Long.parseLong(param);
        pessoa = new PessoaJpaController().findByCpf(cpf);
        CursoPessoaJpaController cpjpa = new CursoPessoaJpaController();
        cursoJava = cpjpa.findByCpf(1, cpf);
        cursoPython = cpjpa.findByCpf(2, cpf);
        cursoRuby = cpjpa.findByCpf(3, cpf);
        cursoHtml = cpjpa.findByCpf(4, cpf);
        cursoWebservice = cpjpa.findByCpf(5, cpf);
    }
    
    public void preRenderList() {
        inscritos = new PessoaJpaController().findAll();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getErro() {
        return erro;
    }

    public List<Pessoa> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Pessoa> inscritos) {
        this.inscritos = inscritos;
    }
}
