/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_despesa")
@Access(AccessType.FIELD)
public class Despesa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDespesa;
    
    @Column(name = "DBL_despesa_prevista")
    private Double despesaPrevista;
    
    @Column(name = "DBL_despesa_atual")
    private Double despesaAtual;
    
    @Column(name = "DBL_valor_restante")
    private Double valorRestante;
    
    @OneToOne(mappedBy = "despesa", optional = false)
    private Casamento casamento;

    public Despesa() {
    }

    
    public Long getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Long idDespesa) {
        this.idDespesa = idDespesa;
    }

    public Double getDespesaPrevista() {
        return despesaPrevista;
    }

    public void setDespesaPrevista(Double despesaPrevista) {
        this.despesaPrevista = despesaPrevista;
    }

    public Double getDespesaAtual() {
        return despesaAtual;
    }

    public void setDespesaAtual(Double despesaAtual) {
        this.despesaAtual = despesaAtual;
    }

    public Double getValorRestante() {
        return valorRestante;
    }

    public void setValorRestante(Double valorRestante) {
        this.valorRestante = valorRestante;
    }

    public Casamento getCasamento() {
        return casamento;
    }

    public void setCasamento(Casamento casamento) {
        this.casamento = casamento;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idDespesa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Despesa other = (Despesa) obj;
        if (!Objects.equals(this.idDespesa, other.idDespesa)) {
            return false;
        }
        return true;
    }
    
}
