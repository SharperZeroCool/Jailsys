package br.com.jailsys.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Visita extends EntidadeComum implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3652089900090894430L;
	
	@ManyToOne
	@JoinColumn(name="idPreso")
	private Preso preso;
	
	@ManyToOne
	@JoinColumn(name="idPessoa")
	private Pessoa pessoa;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date horaInicio;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date duracao;

	//GETTERS E SETTERS
	public Preso getPreso() {
		return preso;
	}

	public void setPreso(Preso preso) {
		this.preso = preso;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getDuracao() {
		return duracao;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}

}
