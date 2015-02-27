package br.com.jailsys.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atividade extends EntidadeComum {

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioFim;

	@Column(nullable = false)
	private boolean ativo;

	@ManyToMany(mappedBy = "atividades")
	private List<Ambiente> ambientes;

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
}
