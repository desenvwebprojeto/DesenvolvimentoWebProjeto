/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.model.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author a1047817
 */
@Entity
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf")
    private Long cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "enderecorua")
    private String enderecorua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endereconumero")
    private Integer endereconumero;
    @Size(max = 3)
    @Column(name = "enderecocomplemento")
    private String enderecocomplemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "enderecocidade")
    private String enderecocidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "enderecoestado")
    private String enderecoestado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cep")
    private Long cep;
    @Size(max = 50)
    @Column(name = "enderecobairro")
    private String enderecobairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefone")
    private String telefone;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Column(name = "isadmin")
    private Boolean isadmin;

    public Pessoa() {
    }

    public Pessoa(Long cpf) {
        this.cpf = cpf;
    }

    public Pessoa(Long cpf, String nome, String rg, String enderecorua, int endereconumero, String enderecocidade, String enderecoestado, Long cep, String telefone, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.enderecorua = enderecorua;
        this.endereconumero = endereconumero;
        this.enderecocidade = enderecocidade;
        this.enderecoestado = enderecoestado;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEnderecorua() {
        return enderecorua;
    }

    public void setEnderecorua(String enderecorua) {
        this.enderecorua = enderecorua;
    }

    public Integer getEndereconumero() {
        return endereconumero;
    }

    public void setEndereconumero(Integer endereconumero) {
        this.endereconumero = endereconumero;
    }

    public String getEnderecocomplemento() {
        return enderecocomplemento;
    }

    public void setEnderecocomplemento(String enderecocomplemento) {
        this.enderecocomplemento = enderecocomplemento;
    }

    public String getEnderecocidade() {
        return enderecocidade;
    }

    public void setEnderecocidade(String enderecocidade) {
        this.enderecocidade = enderecocidade;
    }

    public String getEnderecoestado() {
        return enderecoestado;
    }

    public void setEnderecoestado(String enderecoestado) {
        this.enderecoestado = enderecoestado;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getEnderecobairro() {
        return enderecobairro;
    }

    public void setEnderecobairro(String enderecobairro) {
        this.enderecobairro = enderecobairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabalho_final.model.persistence.entity.Pessoa[ cpf=" + cpf + " ]";
    }
}
