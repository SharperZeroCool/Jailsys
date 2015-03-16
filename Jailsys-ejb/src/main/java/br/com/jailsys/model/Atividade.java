package br.com.jailsys.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atividade extends EntidadeComum implements Serializable {

	private static final long serialVersionUID = -8005194247258410359L;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioFim;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Severidade severidade;

	@Column(nullable = false)
	private boolean ativo;

	@ManyToMany(mappedBy = "atividades", fetch = FetchType.EAGER)
	private List<Ambiente> ambientes;

	@ManyToMany(mappedBy = "atividades")
	private List<Pessoa> pessoas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Severidade getSeveridade() {
		return severidade;
	}

	public void setSeveridade(Severidade severidade) {
		this.severidade = severidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Ambiente> getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(List<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@Override
	public String toString() {
		return nome;
	}
}
