
package Leitos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entities.Bin;


/**
 *@author Lucas Claudiano
 *
 */

//https://www.saopaulo.sp.gov.br/wp-content/uploads/2022/06/Dic-dados_leitos-publicos-ocupados.pdf
// para comecar tem esse link, é um guia de como esta organizado o csv, para saber por exemplo
//como se orientar no vetor que divide as colunas para pegar a informação certa do csv.
public class Tpextra{
    
    private String Municipio;
    private String UnidadedeSaúde;
    private String NomesdeMedida;
    private int Valoresdemedida;
    

    //main
    // aqui é so acrescentar os prints e chamar os subprogramas que farao a leitura, pegarão os dados e etc
    
    public static void main(String[] args) {
       
      //  System.out.println("caminho do CSV: ");
        
        Tpextra();
        Scanner in = new Scanner(System.in);
   	 System.out.println("Deseja visualizar a quantidade de leitos separadamente? 1 = Sim; 2 = Não");
        int r = in.nextInt();
        if(r==1) {
        	
        	LeitosBaixada();
        	
        }
        else {
        	 Exit();
        }
       
        
    }
    
    
    
    
    //aqui esta ocorrendo a leitura do csv em formato de input para trabalhar com os dados do csv
    public static void LeitosBaixada() {
    	
    	int leitos = 0;
    	int leitosUTI = 0;
    	int leitosEnf = 0;
    	
    	String file = "leitos.csv";
    	
    	List<Bin> list = new ArrayList<Bin>();
    	
       
           
            	
            
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                
            	

    			String line = br.readLine();
    			line = br.readLine();
    			
    			
                while (br.ready()) {
                   
                    	String[] vetor = line.replaceAll(" Leitos de UTI Ocupados = ", "").replaceAll(" Leitos de Enfermagem Ocupados = ", "").replaceAll(" Leitos Ocupados Totais = ", "").split(";");
                        
                            //acrescentar e atribuir aos objetos os dados que o 
                            //tp pede, de acordo com o vetor (cada posição se refere
                            //a uma coluna do arquivo csv
                        	
                        	
        					String UnidadedeSaúde = vetor[2];
        					//String NomesdeMedida = (vetor[19]);
        					String Municipio = (vetor[1]);
        					Integer ValoresUTI = Integer.parseInt(vetor[3]);
        					Integer ValoresEnf = Integer.parseInt(vetor[4]);

        					Bin b = new Bin(Municipio, UnidadedeSaúde, ValoresUTI, ValoresEnf);
        					
        					b.addLeito(ValoresUTI, ValoresEnf);
        					leitos = leitos + ValoresUTI + ValoresEnf;
        					leitosUTI = leitosUTI + ValoresUTI;
        					leitosEnf = leitosEnf + ValoresEnf;
        					
        					// Com a lista que criamos, adicionamos os dados salvos nela;
        					list.add(b);	
        					
                        	
        					
        					
        					
                        	
                        
                        
                        
         
                    line = br.readLine();
                    
                }
                System.out.println("Leitos ocupados UTI da baixada Santista = " + leitosUTI);
                System.out.println("Leitos ocupados Enfermagem da baixada Santista = " + leitosEnf);
                System.out.println("Leitos ocupados totais da baixada Santista = " + leitos);
               
                
               
                
            }   
            
            catch (IOException e) {
    			System.out.println("Error: " + e.getMessage());
    		}	
            
            Exit();
        
    }
    
    
 public static void Tpextra() {
    	
    	int leitos = 0;
    	
    	String file = "leitoOriginal.csv";
    	
    	List<Bin> list = new ArrayList<Bin>();
    	
       
           
            	
            
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                
            	PrintWriter pw = new PrintWriter(new FileOutputStream("leitos.csv"));

    			String line = br.readLine();
    			line = br.readLine();
    			
    			
                while (br.ready()) {
                
                    	String[] vetor = line.replaceAll("\"", "").split(";");
                        if (vetor[0].equals("Baixada Santista")){
                            //acrescentar e atribuir aos objetos os dados que o 
                            //tp pede, de acordo com o vetor (cada posição se refere
                            //a uma coluna do arquivo csv
                        	
                        	
        					String UnidadedeSaúde = vetor[2];
        					
        					String Municipio = (vetor[1]);
        					Integer ValoresUTI = Integer.parseInt(vetor[3]);
        					Integer ValoresEnf = Integer.parseInt(vetor[4]);

        					Bin b = new Bin(Municipio, UnidadedeSaúde, ValoresUTI, ValoresEnf);
        					
        					b.addLeito(ValoresUTI, ValoresEnf);
        					leitos = leitos + ValoresUTI + ValoresEnf;
        					
        					// Com a lista que criamos, adicionamos os dados salvos nela;
        					list.add(b);	
        					
                        	
        					
        					
        					pw.println(b);
        					pw.flush();
                        	
                        }
                        
                        
                 //   }
                    line = br.readLine();
                    
                }
                
                System.out.println("Total de Leitos Ocupados da Baixada Santista = " + leitos);
                pw.close();
                
               
                
            }   
            
            catch (IOException e) {
    			System.out.println("Error: " + e.getMessage());
    		}	
            
        
    }
    
    
 public static void Exit() {
	 Scanner in = new Scanner(System.in);
	 System.out.println("Deseja fechar o programa? 1 = Sim; 2 = Não");
    int r = in.nextInt();
 	if(r==1) {
 		System.exit(0);
 	}else {
 		Tpextra();
 	}
 }
    
    
}
