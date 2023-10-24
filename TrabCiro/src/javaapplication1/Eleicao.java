package javaapplication1;


import Entities.Candidate;
import Entities.Product;
import java.io.*;
import java.util.*;
/**
 * @Authors:
 * Fábio Henrique Cimino Júnior;
 * 
 * 
 * 
 * @param args the command line arguments
 */

public class Eleicao {

	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {		
		
		ListarVotos();
		ListarVotosSec();
		
	}
	public static void ListarVotos() {
		//"teste" é o nome do arquivo "votacao_secao_SP_2022"
		String path = "teste.csv";
		
		List<Product> list = new ArrayList<Product>();
		
		//Foi criada uma lista de objetos com a classe Candidate		
		Candidate tarcisio = new Candidate("GOVERNADOR", "TARCISIO GOMES DE FREITAS", "10");
		Candidate fernando = new Candidate("GOVERNADOR", "FERNANDO HADDAD", "13");
		Candidate nulo = new Candidate("GOVERNADOR", "VOTO NULO", "96");
		Candidate white = new Candidate("GOVERNADOR", "VOTO BRANCO", "95");
		Double tot = (double)0;
					
		System.out.println("Calculando Votos...");
		// Tempo de espera com base no tempo de testes nos nossos computadores
		System.out.println("(Tempo de espera estimado: 4 minutos)");

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {			
			//Aqui o projeto busca pelo arquivo csv criado para exportar as informações de Praia Grande
			PrintWriter pw = new PrintWriter(new FileOutputStream("candidate.csv"));

			String line = br.readLine();
			line = br.readLine();
			
			while (br.ready()) {
				String[] vect = line.replaceAll("\"", "").split(";");
	
				// Usando o if, filtramos as informações de "Governador", "Praia Grande" e "2º turno";
				if (vect[14].equals("PRAIA GRANDE") && vect[18].equals("GOVERNADOR") && vect[5].equals("2") && vect[21] != null) {		
					Integer NR_SECAO = Integer.parseInt(vect[16]);
					String CARGO = vect[18];
					String NR_VOTAVEL = (vect[19]);
					String NM_VOTAVEL = (vect[20]);
					Integer QT_VOTOS = Integer.parseInt(vect[21]);

					Product prod = new Product(NR_SECAO, CARGO, NM_VOTAVEL, NR_VOTAVEL, QT_VOTOS);
					
					// Com a lista que criamos, adicionamos os dados salvos nela;
					list.add(prod);					
					
					// Contador de votos entre os candidatos criados;					 * 
					if(vect[19].equals(tarcisio.getNR_VOTAVEL())) {
						tarcisio.addVote(QT_VOTOS);
						tot += QT_VOTOS;
					} 
					else if(vect[19].equals(fernando.getNR_VOTAVEL())) {
						fernando.addVote(QT_VOTOS);
						tot += QT_VOTOS;
					} 
					else if(vect[19].equals("96")) {
						nulo.addVote(QT_VOTOS);
						tot += QT_VOTOS;
					}
					else if(vect[19].equals("95")) {
						white.addVote(QT_VOTOS);
						tot += QT_VOTOS;
					}
					/*
					 * Por fim, os dados salvos são impressos no arquivo "candidate.csv" ao lado
					 * através dos dados registrados em Product;
					 * Fique à vontade para o abrir e ver os dados;
					 */
					pw.println(prod);
					pw.flush();
				}
				/*
				 * Função para gerar a porcentagem na classe Candidate;	
				 */
				tarcisio.porcVote(tot);
				fernando.porcVote(tot);
				white.porcVote(tot);
				nulo.porcVote(tot);
				
				line = br.readLine();
			}
			/*
			 * Por fim é printado no console o resultado 
			 * final de candidatos e fechado o arquivo de escrita;
			 */
			System.out.println(tarcisio);
			System.out.println(fernando);
			System.out.println(nulo);
			System.out.println(white);	
			pw.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}		
	}
	// Função para filtrar votos por seção (Somados ambas as zonas 317 e 406)
	public static void ListarVotosSec() {
		System.out.println("Digite a seção que deseja visualizar: ");
		Integer sec = in.nextInt();
		String path = "candidate.csv";
		List<Product> list = new ArrayList<Product>();
		// Criação de novos objetos da classe Candidate
		Candidate tarcisio = new Candidate("GOVERNADOR", "TARCISIO GOMES DE FREITAS", "10");
		Candidate fernando = new Candidate("GOVERNADOR", "FERNANDO HADDAD", "13");
		Candidate nulo = new Candidate("GOVERNADOR", "VOTO NULO", "96");
		Candidate white = new Candidate("GOVERNADOR", "VOTO BRANCO", "95");
		Double tot = (double)0;
		
		System.out.println("Calculando Votos...");

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			line = br.readLine();
			// While para exibir as informações filtradas pela seção digitada
			while (br.ready()) {
				String[] vect = line.replaceAll("\"", "").split(";");
				if (Integer.parseInt(vect[0]) == sec) {	
					
					Integer NR_SECAO = Integer.parseInt(vect[0]);
					String CARGO = vect[1];
					String NR_VOTAVEL = (vect[3]);
					String NM_VOTAVEL = (vect[2]);
					Integer QT_VOTOS = Integer.parseInt(vect[4]);

					Product prod = new Product(NR_SECAO, CARGO, NM_VOTAVEL, NR_VOTAVEL, QT_VOTOS);
					list.add(prod);					
						if(vect[3].equals(tarcisio.getNR_VOTAVEL())) {
							tarcisio.addVote(QT_VOTOS);
							tot += QT_VOTOS;			
					}
					else if(vect[3].equals(fernando.getNR_VOTAVEL())) {
						fernando.addVote(QT_VOTOS);
						tot += QT_VOTOS;
					}
					else if(vect[3].equals("96")) {
						nulo.addVote(QT_VOTOS);
						tot += QT_VOTOS;						
					}
					else if(vect[3].equals("95")) {
						white.addVote(QT_VOTOS);
						tot += QT_VOTOS;
					}
				}
				// Processando os votos totais e calculando a porcentagem da função porcVote na classe Candidate
				tarcisio.porcVote(tot);
				fernando.porcVote(tot);
				white.porcVote(tot);
				nulo.porcVote(tot);
				
				line = br.readLine();
			}
			// Caso a seção digitada não existir, irá exibir erro, caso contrario irá exibir as informações da seção desejada
			if(tot == 0) {
				Erro();
			} else {
				System.out.println(tarcisio);
				System.out.println(fernando);
				System.out.println(nulo);
				System.out.println(white);
			}				
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		Close();
	} 
	// Função para exibir Erro
	private static void Erro() {
		System.out.println("Erro: Não há seção com esse número.");
		Close();		
	}
	// Função para continuar o programa ou terminar
	public static void Close() {
		System.out.println("Deseja fechar o programa? 1 = Sim; 2 = Não");
		Integer resp = in.nextInt();
		switch(resp) {
		case 1:
			System.exit(0);
			break;
		case 2:
			ListarVotosSec();
			break;
		default:
			System.out.println("Número não identificado, o programa será fechado. ");
			System.exit(0);
			break;
		}	
	}
}
