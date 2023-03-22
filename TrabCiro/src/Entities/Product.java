package Entities;

import java.io.Serializable;
/**
 * @Authors:
 * Fábio Henrique Cimino Júnior;
 * Lucas Marques Vianna;
 * Beatriz Maria Arakaki;
 * João Gimenes Moura;
 * Richard Miranda Guida;
 * @param args the command line arguments
 */
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String CARGO;
	private Integer NR_SECAO;
    private String NR_VOTAVEL;
    private String NM_VOTAVEL;
    private Integer QT_VOTOS;

    public Product(Integer NR_SECAO, String CARGO, String NR_VOTAVEL, String NM_VOTAVEL, Integer QT_VOTOS) {
        this.NR_SECAO = NR_SECAO;
    	this.CARGO = CARGO;
        this.NR_VOTAVEL = NR_VOTAVEL;
        this.NM_VOTAVEL = NM_VOTAVEL;
        this.QT_VOTOS = QT_VOTOS;
    }

    public String getCARGO() {
        return CARGO;
    }

    public void setCARGO(String CARGO) {
        this.CARGO = CARGO;
    }
    public Integer getNR_SECAO() {
        return NR_SECAO;
    }

    public void setNR_SECAO(Integer NR_SECAO) {
        this.NR_SECAO = NR_SECAO;
    }
    public Integer getQT_VOTOS() {
        return QT_VOTOS;
    }

    public void setQT_VOTOS(Integer QT_VOTOS) {
        this.QT_VOTOS = QT_VOTOS;
    }

    public String getNR_VOTAVEL() {
        return NR_VOTAVEL;
    }

    public void setNR_VOTAVEL(String NR_VOTAVEL) {
        this.NR_VOTAVEL = NR_VOTAVEL;
    }

    public String getNM_VOTAVEL() {
        return NM_VOTAVEL;
    }

    public void setNM_VOTAVEL(String NM_VOTAVEL) {
        this.NM_VOTAVEL = NM_VOTAVEL;
    }

    @Override
    public String toString() {
        return NR_SECAO + ";" + CARGO + ";" + NR_VOTAVEL + ";" + NM_VOTAVEL + ";" + QT_VOTOS + ";";
    }
    
}
