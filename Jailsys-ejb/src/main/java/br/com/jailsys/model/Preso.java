package br.com.jailsys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Preso extends Pessoa {


    private static final long serialVersionUID = -6281777558237784113L;

    @Column(length = 26, nullable = false)
    private String codigo;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date dataPrisao;
    
    @Temporal(TemporalType.DATE)
    private Date dataSaida;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataPrisao() {
        return dataPrisao;
    }

    public void setDataPrisao(Date dataPrisao) {
        this.dataPrisao = dataPrisao;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    
   
}
