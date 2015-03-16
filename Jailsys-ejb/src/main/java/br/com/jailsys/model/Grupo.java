package br.com.jailsys.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Grupo extends EntidadeComum implements Serializable {

	private static final long serialVersionUID = -2924742858034727696L;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 500)
	private String descricao;

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

	@Override
	public String toString() {
		return nome;
	}
}
