package NutriSys;

import java.util.ArrayList;
import java.util.Scanner;
import NutriSys.Inicio;
import NutriSys.Dieta;
import NutriSys.DietaHipertrofia;

//Este � a BASE do projeto, arquivo que roda com o PLAY
public class Main {

	public static void main(String[] args) {

		Inicio inicio = new Inicio(null, 0, null, 0, 0, 0);
		Dieta dieta1 = new DietaHipertrofia(null, 0, null, null, null, null, null);
		Dieta dieta2 = new DietaLowCarb(null, 0, null, null, null, null, null);

		inicio.boasvindas();
		inicio.setDados();
		while (true) {

			Scanner read = new Scanner(System.in); 
			System.out.println(Cor.TEXT_BLACK +  Cor.ANSI_WHITE_BACKGROUND + "\n------------- MENU DE USUÁRIO -------------");
			System.out.println(Cor.TEXT_BLACK +"Digite o que gostaria de fazer: " + Cor.ANSI_WHITE_BACKGROUND + "           ");
			System.out.println(Cor.TEXT_BLACK +"1 - Calcular IMC: " + Cor.ANSI_WHITE_BACKGROUND + "                         ");
			System.out.println(Cor.TEXT_BLACK +"2 - Visualizar Minha dieta" + Cor.ANSI_WHITE_BACKGROUND + "                 ");
			System.out.println(Cor.TEXT_BLACK +"3 - Ver minha Ficha Cadastral" + Cor.ANSI_WHITE_BACKGROUND + "              ");
			System.out.println(Cor.TEXT_BLACK +"4 - Alterar minha Ficha Cadastral" + Cor.ANSI_WHITE_BACKGROUND + "          ");
			System.out.println(Cor.TEXT_BLACK +"5 - Deixar um comentário sobre a sua dieta" + Cor.ANSI_WHITE_BACKGROUND + " ");
			System.out.println(Cor.TEXT_BLACK +"6 - Visualizar comentários" + Cor.ANSI_WHITE_BACKGROUND + "                 ");
			System.out.println(Cor.TEXT_BLACK +"7 - Sair" + Cor.ANSI_WHITE_BACKGROUND + "                                   ");
			System.out.println(Cor.TEXT_RESET);
			int x = read.nextInt();

			if (x == 1) {
				double IMC = inicio.getPeso() / Math.pow(inicio.getAltura(), 2);
				inicio.setIMC(IMC);

				if (IMC < 18.5) {
					System.out.printf("\nVocê está Abaixo do peso! Seu IMC é: %.2f \n", IMC);
				}

				else if (IMC >= 18.5 && IMC < 24) {
					System.out.printf("\nSeu peso está ideal  " + "\nSeu IMC é: %.2f \n", IMC);
				}

				else if (IMC >= 24 && IMC < 30) {
					System.out.printf("\nVocê está Levemente acima do peso " + "\nSeu IMC é: %.2f \n", IMC);
				} else if (IMC >= 30 && IMC < 35) {
					System.out.printf("\nVocê está com Obesidade grau I " + "\nSeu IMC é: %.2f \n", IMC);
				} else if (IMC >= 35 && IMC < 40) {
					System.out.printf("\nVocê está com Obesidade grau II " + "\nSeu IMC é: %.2f \n", IMC);
				} else {
					System.out.printf("\nVocê está com Obesidade grau III" + "\nSeu IMC é: %.2f \n", IMC);
				}

			}

			if (x == 2) {

				if (inicio.getIMC() <= 24) {
					System.out.println("\n-----SUA DIETA IDEAL-----");
					System.out.println("Nome da dieta: " + dieta1.getNome());
					System.out.println("Duração em semanas: " + dieta1.getDuracao());
					System.out.println(dieta1.getRefeicao1());
					System.out.println(dieta1.getRefeicao2());
					System.out.println(dieta1.getRefeicao3());
					System.out.println(dieta1.getRefeicao4());
					System.out.println(dieta1.getDescricao());

				}

				else if (inicio.getIMC() > 25) {
					System.out.println("\n-----SUA DIETA IDEAL-----");
					System.out.println("Nome da dieta: " + dieta2.getNome());
					System.out.println("Duração em semanas: " + dieta2.getDuracao());
					System.out.println(dieta2.getRefeicao1());
					System.out.println(dieta2.getRefeicao2());
					System.out.println(dieta2.getRefeicao3());
					System.out.println(dieta2.getRefeicao4());
					System.out.println(dieta2.getDescricao());
				}

			}

			if (x == 3) {
				inicio.visualizarDados();
			}

			if (x == 4) {
				inicio.alterarDados();
			}

			if (x == 5) {

				String s = inicio.comment();
				inicio.getComentario().add(s + " ---- Escrito por: " + inicio.getNome());
				// System.out.println(inicio.getComentario());
				System.out.println("Muito Obrigado! Sua opinião é muito importante para nós!");
			}

			if (x == 6) {

				for (int j = 0; j < inicio.getComentario().size(); j++) {
					System.out.println(inicio.getComentario().get(j));

				}
			}
			if (x == 7) {
				break;
			}
		}
		/*
		 * System.out.print(inicio.getNome()); System.out.print(inicio.getIdade());
		 * System.out.print(inicio.getSexo()); System.out.print(inicio.getAltura());
		 * System.out.print(inicio.getPeso());
		 */

	}

}
