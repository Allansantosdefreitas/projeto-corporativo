package br.com.tads.ifpe.projetosofwarecasamento.model;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
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
    
    private String sal;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_usuario_grupo", joinColumns = {
        @JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_grupo")})
    private List<Grupo> grupos;

    public Usuario() {
    }
    
     @PrePersist
    public void gerarHash() {
        try {
            gerarSal();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            setSenha(sal + senha);
            digest.update(senha.getBytes(Charset.forName("UTF-8")));
            setSenha(Base64.getEncoder().encodeToString(digest.digest()));
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void gerarSal() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        setSal(Base64.getEncoder().encodeToString(randomBytes));
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
    
    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }
    
    public void setGrupo(Grupo grupo) {
        if (this.grupos == null) {
            this.grupos = new ArrayList<>();
        }

        this.grupos.add(grupo);
    }

    public List<Grupo> getGrupos() {
        return this.grupos;
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
