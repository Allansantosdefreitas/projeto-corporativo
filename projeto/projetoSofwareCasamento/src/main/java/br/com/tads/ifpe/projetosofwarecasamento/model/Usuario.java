package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 * The persistent class for the usuario database table.
 *
 */
@Entity
@Table(name = "TB_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "disc_usuario", discriminatorType = DiscriminatorType.STRING, length = 4)
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
@Access(AccessType.FIELD)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "disc_usuario")
    private String discUsuario;

    private String email;

    private String login;

    private String nome;

    private String senha;

    public Usuario() {
    }

    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDiscUsuario() {
        return this.discUsuario;
    }

    public void setDiscUsuario(String discUsuario) {
        this.discUsuario = discUsuario;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        return true;
    }

}
