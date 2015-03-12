package br.com.jailsys.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Preso extends Pessoa {

    private static final long serialVersionUID = -6281777558237784113L;

    @Column(length = 26, nullable = false)
    private String codigo;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataPrisao;

    @Temporal(TemporalType.DATE)
    private Date dataSaida;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "presocrime", joinColumns = @JoinColumn(name = "idPreso"), inverseJoinColumns = @JoinColumn(name = "idCrime"))
    private List<Crime> crimes;

    @Override
    public String getDescricaoPesquisa() {
        return super.getNome();
    }

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

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    /**
     * Gera o codigo do preso no seguinte formato: ANO DE NASCIMENTO + MES DE
     * NASCIMENTO + DIA DO ANO DE NASCIMENTO + ANO DE PRISAO + MES DE PRISAO +
     * DIA DO ANO DE PRISAO.
     * 
     * @param preso
     * @return Codigo do preso no formato correto.
     */
    @PrePersist
    public void gerarCodigo() {
        StringBuilder codigo = new StringBuilder();

        // Pega o ano, mes e dia do ano de nascimento do preso
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(super.getDataNasc());
        codigo.append(calendario.get(Calendar.YEAR));
        codigo.append(calendario.get(Calendar.MONTH));
        codigo.append(calendario.get(Calendar.DAY_OF_YEAR));

        // Pega o ano, mes e dia do ano de prisao do preso
        calendario.setTime(this.dataPrisao);
        codigo.append(calendario.get(Calendar.YEAR));
        codigo.append(calendario.get(Calendar.MONTH));
        codigo.append(calendario.get(Calendar.DAY_OF_YEAR));
        this.codigo = codigo.toString();
    }

}
