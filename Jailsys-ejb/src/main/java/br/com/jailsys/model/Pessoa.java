package br.com.jailsys.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa extends EntidadeComum implements Serializable {

    private static final long serialVersionUID = -7205815321884922764L;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 20, nullable = false)
    private String cpfCnpj;

    @Column(length = 100, nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dataNasc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
