package br.com.jailsys.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.jailsys.util.CriptografiaUtil;

@Entity
public class Usuario extends EntidadeComum implements Serializable {

    private static final long serialVersionUID = 1801799201648626978L;

    @Column(length = 100, nullable = false, unique = true)
    private String login;

    @Column(length = 100, nullable = false)
    private String senha;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "grupo")
    private Grupo grupo;

    @Column(nullable = false)
    private boolean ativo;

    public void criptografarSenha() {
        this.senha = getSenhaCriptografada();
    }

    private String getSenhaCriptografada() {
        return CriptografiaUtil.criptografar(this.getSenha());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
