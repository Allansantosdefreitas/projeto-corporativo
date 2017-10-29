package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable{

	public static final String CONJUGE = "conjuge";
	public static final String PROFISSIONAL = "profissional";
	public static final String CONVIDADO = "convidado";

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_grupo")
	private Long idGrupo;

	@NotBlank
	@Size(max = 60)
	@Column(name = "nome")
	private String strNome;

	public Grupo() {
	}

	public Grupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getStrNome() {
		return strNome;
	}

	public void setStrNome(String strNome) {
		this.strNome = strNome;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idGrupo != null ? idGrupo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Grupo)) {
			return false;
		}
		Grupo other = (Grupo) object;
		if ((this.idGrupo == null && other.idGrupo != null)
				|| (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.tads.ifpe.projetosoftwarecasamento.model.Grupo[ idGrupo=" + idGrupo + " ]";
	}
        
}
