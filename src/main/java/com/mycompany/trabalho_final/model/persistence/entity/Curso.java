/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.model.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
@Entity
@Table(name = "curso")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "curso_id")
    private Integer cursoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "curso_nome")
    private String cursoNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<Cursopessoa> cursopessoaList;

    public Curso() {
    }

    public Curso(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Curso(Integer cursoId, String cursoNome) {
        this.cursoId = cursoId;
        this.cursoNome = cursoNome;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public List<Cursopessoa> getCursopessoaList() {
        return cursopessoaList;
    }

    public void setCursopessoaList(List<Cursopessoa> cursopessoaList) {
        this.cursopessoaList = cursopessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoId != null ? cursoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.cursoId == null && other.cursoId != null) || (this.cursoId != null && !this.cursoId.equals(other.cursoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabalho_final.model.persistence.entity.Curso[ cursoId=" + cursoId + " ]";
    }
    
}
