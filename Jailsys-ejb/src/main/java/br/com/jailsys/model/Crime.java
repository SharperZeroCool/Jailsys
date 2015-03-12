package br.com.jailsys.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Crime extends EntidadeComum implements Serializable {

    private static final long serialVersionUID = 5936314317616471466L;

    private String nome;
    private String descricao;
    
    @ManyToMany(mappedBy = "crimes")
    private List<Preso> presos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Preso> getPresos() {
        return presos;
    }

    public void setPresos(List<Preso> presos) {
        this.presos = presos;
    }
}
