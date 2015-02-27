package br.com.jailsys.model;

public enum Severidade {
    Baixa("jailsysweb.ambiente.form.label.baixa"),
    Media("jailsysweb.ambiente.form.label.media"),
    Alta("jailsysweb.ambiente.form.label.alta");

    private String descricao;

    private Severidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
