package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the convite database table.
 * 
 */
@Entity
@NamedQuery(name="Convite.findAll", query="SELECT c FROM Convite c")
public class Convite implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConvite;

	private String destinatarios;

	private String mensagem;

	//bi-directional one-to-one association to Casamento
	@OneToOne(mappedBy = "convite", optional = false)
	private Casamento casamento;

        // convite não tem atributo convidado..o relacionamento é unidirecional
           // com lado dominante em convidado
        
	public Convite() {
	}

	public Long getIdConvite() {
		return this.idConvite;
	}

	public void setIdConvite(Long idConvite) {
		this.idConvite = idConvite;
	}

	public String getDestinatarios() {
		return this.destinatarios;
	}

	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Casamento getCasamento() {
		return this.casamento;
	}

	public void setCasamento(Casamento casamento) {
		this.casamento = casamento;
	}

}