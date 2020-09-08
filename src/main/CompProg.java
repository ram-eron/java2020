package main;
import java.util.Scanner;

import entities.Contrato;
import entities.Trabalhador;

public class CompProg {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
			
		String dept = entradaDados("Departamento");
		String nomeTrab = entradaDados("Nome do Funcionario");
		String nivel = entradaDados("nivel profissional: " 
									+ "\n  JUNIOR"
									+ "\n  MID_LEVEL"
									+ "\n  SENIOR").toUpperCase();
		Double salario = Double.parseDouble(entradaDados("salario"));
		
		Trabalhador trab = new Trabalhador(nomeTrab, nivel, salario, dept);
		
		System.out.println("\n"+trab);
		
		int n = Integer.parseInt(entradaDados("quantidade de contratos:"));
		
		for (int i = 0; i < n; i++) {
			String data = entradaDados("data do contrato " + (i+1));
			Double valorHora = Double.parseDouble(entradaDados("valor da hora"));
			int duracao = Integer.parseInt(entradaDados("duração em horas"));
			
			trab.addContrato(data, valorHora, duracao);
		}
		
		for (Contrato ct : trab.getContratos()) {
			System.out.println(ct);
		}
		
		trab.removeContrato(entradaDados("a data do contrato a ser removido "));
		
		for (Contrato ct : trab.getContratos()) {
					System.out.println(ct);
		}
		
		Double renda = trab.renda(entradaDados("mes para calculo da renda: "));
		System.out.println();
		System.out.println(	"Funcionario: " + trab.getNome() + "\n" +
							"Departamento: " + trab.getDepartamento().getNome() + "\n" +
							"Renda do mês: " + renda
				);
	
	}
	
	
    static private String entradaDados(String dado) {
		System.out.println("\ninforme o " + dado);
		return sc.nextLine();
	}
        
	
}
