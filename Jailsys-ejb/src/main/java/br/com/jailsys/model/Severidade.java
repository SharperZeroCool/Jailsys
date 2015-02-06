package br.com.jailsys.model;

public enum Severidade {
    Baixa("Baixa"),
    Media("Média"),
    Alta("Alta");

    private String descricao;

    private Severidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
