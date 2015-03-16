package br.com.jailsys.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends EntidadeComum implements Serializable {

	private static final long serialVersionUID = -7205815321884922764L;

	@Column(length = 100, nullable = false)
	private String nome;

	@CPF
	@Column(length = 20, nullable = false, unique = true)
	private String cpf;

	@Email
	@Column(length = 100, nullable = false)
	private String email;

	@Temporal(TemporalType.DATE)
	private Date dataNasc;

	@Column(length = 20)
	private String celular;

	private boolean ativo;

	@ManyToMany
	@JoinTable(name = "pessoaatividade", joinColumns = @JoinColumn(name = "idPessoa"), inverseJoinColumns = @JoinColumn(name = "idAtividade"))
	private Set<Atividade> atividades;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Atividade> getAtividades() {
		return new ArrayList<Atividade>(this.atividades);
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = new HashSet<Atividade>(atividades);
	}

	@Override
	public String toString() {
		return nome;
	}
}
