package br.com.jailsys.model;

public enum Severidade {
    Baixa("jailsysweb.atividade.form.severidade.baixa"),
    Media("jailsysweb.atividade.form.severidade.media"),
    Alta("jailsysweb.atividade.form.severidade.alta");

    private String descricao;

    private Severidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
