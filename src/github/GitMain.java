package github;

import java.util.Scanner;

public class GitMain {

	private static Scanner sc;

	public static void main(String[] args) {
		System.out.println("GitHub");
		System.out.println("###############################\n");

		int[][] t;
		int x, y,aux = 0;;

		x = Integer.parseInt(entradaDados("colunas"));
		y = Integer.parseInt(entradaDados("linhas"));

		t = new int [x][y];
		
		System.out.println("###############################\n");
		
		
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = aux * 8/3;
				System.out.print(t[i][j] + "\t" );
				aux++;
			}
			System.out.println();
		}


	}

	private static String entradaDados(String var) {
		sc = new Scanner(System.in);
		System.out.println("informe o valor de " + var );
		String x = sc.next(); 
		return x;

	}


}
