/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
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
    
}
