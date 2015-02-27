package br.com.jailsys.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
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
    
    /**
     * Gera o codigo do preso no seguinte formato: ANO DE NASCIMENTO + ANO DE
     * PRISAO + MES DE PRISAO.
     * 
     * @param preso
     * @return Codigo do preso no formato correto.
     */
    @PrePersist
    public void geradorDeCodigo() {
        StringBuilder codigo = new StringBuilder();

        // Pega o ano de nascimento do preso
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(super.getDataNasc());
        codigo.append(calendario.get(Calendar.YEAR));

        // Pega o ano e mes de prisao do preso
        calendario.setTime(this.dataPrisao);
        codigo.append(calendario.get(Calendar.YEAR));
        codigo.append(calendario.get(Calendar.MONTH));
        this.codigo= codigo.toString();
    }

    
   
}
