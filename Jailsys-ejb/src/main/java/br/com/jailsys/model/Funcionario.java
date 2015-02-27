package br.com.jailsys.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario extends Pessoa {

    private static final long serialVersionUID = -2104357455313055533L;
    
    private static final String PONTO = ".";
    

    private static final int REMOVE_PONTO = 1;

    private static final String HIFEN = "-";

    private static  final String VAZIO = "";
    

    @Column(length = 45, nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date cargaHoraria;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horarioEntrada;
    
    /**
     * Gera o codigo do funcionario no seguinte formato: ANO DE NASCIMENTO + 5
     * ULTIMOS DIGITOS DO CPF + ANO DE ENTRADA + MES DE ENTRADA.
     * 
     * @param funcionario
     * @return Codigo do funcionario no formato correto.
     */
    @PrePersist
    public void geraCodigo() {
        StringBuilder codigo = new StringBuilder();

        // Pega o ano de nascimento do funcionario
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(super.getDataNasc());
        codigo.append(calendario.get(Calendar.YEAR));

        // Pega os ultimos 5 digitos do cpf do funcionario
        codigo.append(super.getCpf().substring(super.getCpf().lastIndexOf(PONTO) + REMOVE_PONTO).replace(HIFEN, VAZIO));

        // Pega o ano e mes de entrada do funcionario
        calendario.setTime(this.dataEntrada);
        codigo.append(calendario.get(Calendar.YEAR));
        codigo.append(calendario.get(Calendar.MONTH));
        this.codigo=codigo.toString();
    }

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

}
