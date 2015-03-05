package br.com.jailsys.model;

public enum Severidade {
    Baixa("jailsysweb.ambiente.form.severidade.baixa"),
    Media("jailsysweb.ambiente.form.severidade.media"),
    Alta("jailsysweb.ambiente.form.severidade.alta");

    private String descricao;

    private Severidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
