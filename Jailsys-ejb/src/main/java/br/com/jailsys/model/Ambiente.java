package br.com.jailsys.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ambiente extends EntidadeComum implements Serializable {

	private static final long serialVersionUID = -304908605604137308L;

	@Column(length = 45, nullable = false)
	private String nome;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private int lotacaoPessoas;

	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date horarioInicio;

	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date horarioFim;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Severidade severidade;

	@Column(nullable = false)
	private boolean ativo;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "atividadeambiente", joinColumns = @JoinColumn(name = "idAmbiente"), inverseJoinColumns = @JoinColumn(name = "idAtividade"))
	private List<Atividade> atividades;

	@Override
	public String getDescricaoPesquisa() {
		return nome;
	}

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

	public int getLotacaoPessoas() {
		return lotacaoPessoas;
	}

	public void setLotacaoPessoas(int lotacaoPessoas) {
		this.lotacaoPessoas = lotacaoPessoas;
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

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

}
