/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.model.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
@Entity
@Table(name = "cursopessoa")
@NamedQueries({
    @NamedQuery(name = "Cursopessoa.findAll", query = "SELECT c FROM Cursopessoa c")})
public class Cursopessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursopessoaPK cursopessoaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cursando")
    private boolean cursando;
    @JoinColumn(name = "curso_id", referencedColumnName = "curso_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;

    public Cursopessoa() {
    }

    public Cursopessoa(CursopessoaPK cursopessoaPK) {
        this.cursopessoaPK = cursopessoaPK;
    }

    public Cursopessoa(CursopessoaPK cursopessoaPK, boolean cursando) {
        this.cursopessoaPK = cursopessoaPK;
        this.cursando = cursando;
    }

    public Cursopessoa(int cursoId, Long cpf) {
        this.cursopessoaPK = new CursopessoaPK(cursoId, cpf);
    }

    public CursopessoaPK getCursopessoaPK() {
        return cursopessoaPK;
    }

    public void setCursopessoaPK(CursopessoaPK cursopessoaPK) {
        this.cursopessoaPK = cursopessoaPK;
    }

    public boolean getCursando() {
        return cursando;
    }

    public void setCursando(boolean cursando) {
        this.cursando = cursando;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursopessoaPK != null ? cursopessoaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursopessoa)) {
            return false;
        }
        Cursopessoa other = (Cursopessoa) object;
        if ((this.cursopessoaPK == null && other.cursopessoaPK != null) || (this.cursopessoaPK != null && !this.cursopessoaPK.equals(other.cursopessoaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabalho_final.model.persistence.entity.Cursopessoa[ cursopessoaPK=" + cursopessoaPK + " ]";
    }
    
}
