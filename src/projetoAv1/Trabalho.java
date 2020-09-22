package projetoAv1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Trabalho {
	public static void main(String[] args) throws IOException {
		String diretorio = System.getProperty("user.dir") + "\\ProjetoUm.txt";
		System.out.println(diretorio);
		
		Contrato[] contratos = new Contrato[contaLinhas(diretorio)];
		double matriz[][][] = new double[contaLinhas(diretorio)][4][1];
		
		lerArquivo(diretorio, contratos);
		for (Contrato i : contratos) {
			System.out.println(i.toString());
		}
		for(int fornecedora = 0; fornecedora < matriz.length; fornecedora++) {
			for(int mesInicial = 0; mesInicial < 4; mesInicial++) {
				for(int mesFinal = 0; mesFinal < 1; mesFinal++) {
					matriz[fornecedora][mesInicial][mesFinal]=contratos[fornecedora].getValor();
					
				}
			}
		}
		for(int fornecedora = 0; fornecedora < matriz.length; fornecedora++) {
			for(int mesInicial = 0; mesInicial < 4; mesInicial++) {
				for(int mesFinal = 0; mesFinal < 1; mesFinal++) {
					System.out.println(matriz[fornecedora][mesInicial][mesFinal]);
				}
			}
		}
	}

	private static void lerArquivo(String diretorio, Contrato[] contrato) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(diretorio));
		String[] string = null;
		int i = 0;
		while (in.hasNextLine()) {
			String line = in.nextLine();
			string = line.split(" ");
			contrato[i] = new Contrato(converteInt(string[0]), converteInt(string[1]), converteInt(string[2]),
					converteDouble(string[3]));
			i++;
		}

	}

	@SuppressWarnings("unused")
	private static int contaLinhas(String diretorio) throws IOException {
		@SuppressWarnings("resource")
		LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream(diretorio)));
		String nextLine = null;
		while ((nextLine = lineCounter.readLine()) != null) {
			if (nextLine == null)
				break;
		}
		System.out.println("Total number of line in this file " + lineCounter.getLineNumber());
		return lineCounter.getLineNumber();
	}

	private static int converteInt(String string) {
		return Integer.parseInt(string);
	}

	private static double converteDouble(String string) {
		return Double.parseDouble(string);
	}
}
