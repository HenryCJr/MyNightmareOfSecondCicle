package Entities;
import java.io.*;
/**
 * @Authors:
 * Fábio Henrique Cimino Júnior;
 * Lucas Marques Vianna;
 * Beatriz Maria Arakaki;
 * João Gimenes Moura;
 * Richard Miranda Guida;
 * @param args the command line arguments
 */
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String NM_VOTAVEL;
	private String NR_VOTAVEL;
	private Integer vote = 0;
	private String CARGO;
	private long porc;
	private Integer QT_VOTOS;
	private Integer NR_SECAO;

	public Candidate(String CARGO, String NM_VOTAVEL, String NR_VOTAVEL) {
		this.NM_VOTAVEL = NM_VOTAVEL;
		this.NR_VOTAVEL = NR_VOTAVEL;
		this.CARGO = CARGO;
	}
	public String getNM_VOTAVEL() {
		return NM_VOTAVEL;
	}
	public String getCARGO() {
		return CARGO;
	}
	public String getNR_VOTAVEL() {
		return NR_VOTAVEL;
	}
	public Integer getQT_VOTOS() {
		return QT_VOTOS;
	}
	public Integer getNR_SECAO() {
		return NR_SECAO;
	}
	@Override
	public String toString() {
		return "CARGO=" + CARGO + "; NR_VOTAVEL=" + NR_VOTAVEL + "; NM_VOTAVEL=" + NM_VOTAVEL + "; Votes= " + vote + "; Porcentagem= " + porc + "% ]";
	}
	public void addVote(Integer QT_VOTOS) {	
		vote += QT_VOTOS;			
	}
	public void porcVote(Double tot) {
		porc = Math.round((double)(vote*100)/tot);
	}
}
