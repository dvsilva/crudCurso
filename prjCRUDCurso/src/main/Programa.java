package main;

import java.util.Scanner;

import service.CursoService;
import dto.CursoDTO;
import exception.DaoException;
import exception.ServiceException;

public class Programa {
	private static CursoService cursoService = new CursoService();

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int op = 0;

		do {
			System.out.println("Escolha a operação desejada:");
			System.out.println("1-Criar curso");
			System.out.println("2-Buscar curso");
			System.out.println("3-Alterar curso");
			System.out.println("4-Remover curso");
			System.out.println("5-Sair");
			System.out.println("");

			op = teclado.nextInt();

			if (op == 1) {
				System.out.println("Informe o código do curso: ");
				int codigo = teclado.nextInt();
				System.out.println("Informe o nome do curso: ");
				String nome = teclado.next();
				criarCurso(codigo, nome);
			} else if (op == 2) {
				System.out.println("Informe o código do curso: ");
				int codigo = teclado.nextInt();
				buscarCurso(codigo);
			} else if (op == 3) {
				System.out.println("Informe o código do curso: ");
				int codigo = teclado.nextInt();
				System.out.println("Informe o nome do curso: ");
				String nome = teclado.next();
				alterarCurso(codigo, nome);
			} else if (op == 4) {
				System.out.println("Informe o código do curso: ");
				int codigo = teclado.nextInt();
				removerCurso(codigo);
			} else if (op == 5) {
				System.out.println("Aplicação encerrada");
			} else {
				System.out.println("Digite um número válido");
			}

		} while (op != 5);
	}

	public static void criarCurso(int codigo, String nome) {
		CursoDTO cursoDTO = new CursoDTO(codigo, nome);
		try {
			cursoService.cadastrarCurso(cursoDTO);
		} catch (ServiceException e) {
			System.out.println(e.getTipo());
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String buscarCurso(int codigo) {

		try {
			CursoDTO curso = cursoService.buscarCurso(codigo);
			return "Código: " + curso.getCodigo() + " / Nome: "
					+ curso.getNome();
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void alterarCurso(int codigo, String nome) {
		CursoDTO cursoDTO = new CursoDTO(codigo, nome);
		try {
			cursoService.alterarCurso(cursoDTO);
		} catch (ServiceException e) {
			System.out.println(e.getTipo());
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void removerCurso(int codigo) {
		try {
			cursoService.removerCurso(codigo);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}
}
