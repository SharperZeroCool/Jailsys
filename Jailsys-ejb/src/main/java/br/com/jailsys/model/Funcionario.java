package br.com.jailsys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario extends Pessoa {

    private static final long serialVersionUID = -2104357455313055533L;

    @Column(length = 45, nullable = false)
    private String codigo;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date cargaHoraria;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataEntrada;

    @Temporal(TemporalType.TIME)
    private Date horarioEntrada;

    @Column(nullable = false)
    private boolean ativo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Date cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
