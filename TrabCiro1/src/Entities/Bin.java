package Entities;

import java.io.Serializable;

public class Bin  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String Municipio;
	private String UnidadedeSaúde;
	
	private int ValoresUTI;
	private int ValoresEnf;
	private int leitoUTI = 0;
	private int leitoEnf = 0;
	private int leito = 0;
	
	
	public Bin(String Municipio, String UnidadedeSaúde, int ValoresUTI, int ValoresEnf){
        this.Municipio = Municipio;
        this.UnidadedeSaúde = UnidadedeSaúde;
       
        this.ValoresUTI = ValoresUTI;
        this.ValoresEnf = ValoresEnf;
        
    }
	public String getMunicipio() {
		return Municipio;
	}
	public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }
	public String getUnidadedeSaúde() {
		return UnidadedeSaúde;
	}
	public void setUnidadedeSaúde(String UnidadedeSaúde) {
        this.UnidadedeSaúde = UnidadedeSaúde;
    }
	
	public Integer getValoresUTI() {
		return ValoresUTI;
	}
	public void setValoresUTI(Integer ValoresUTI) {
        this.ValoresUTI = ValoresUTI;
    }
	
	public Integer getValoresEnf() {
		return ValoresEnf;
	}
	public void setValoresEnf(Integer ValoresEnf) {
        this.ValoresEnf = ValoresEnf;
    }
	
	@Override
	public String toString() {
		return Municipio + ";" + UnidadedeSaúde + "; Leitos de UTI Ocupados = " + ValoresUTI + "; Leitos de Enfermagem Ocupados = " + ValoresEnf + "; Leitos Ocupados Totais = " + leito;
	}
	public void addLeito(Integer ValoresUTI, Integer ValoresEnf) {	
		leitoUTI = leitoUTI + ValoresUTI;
		leitoEnf = leitoEnf + ValoresEnf;	
		leito = leitoUTI + leitoEnf;
	}

}
