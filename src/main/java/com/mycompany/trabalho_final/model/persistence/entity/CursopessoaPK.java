/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.model.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
@Embeddable
public class CursopessoaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "curso_id")
    private int cursoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf")
    private Long cpf;

    public CursopessoaPK() {
    }

    public CursopessoaPK(int cursoId, Long cpf) {
        this.cursoId = cursoId;
        this.cpf = cpf;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cursoId;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursopessoaPK)) {
            return false;
        }
        CursopessoaPK other = (CursopessoaPK) object;
        if (this.cursoId != other.cursoId) {
            return false;
        }
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabalho_final.model.persistence.entity.CursopessoaPK[ cursoId=" + cursoId + ", cpf=" + cpf + " ]";
    }
    
}
