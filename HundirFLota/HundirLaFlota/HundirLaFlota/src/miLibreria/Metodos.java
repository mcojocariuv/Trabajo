package miLibreria;

import java.util.Scanner;

public class Metodos {

	private Scanner entrada = new Scanner(System.in);

	public int obtenerEntero(String mensaje) {
		int valor = 0;
		String teclado;
		boolean loop = true;

		do {
			try {
				System.out.println(mensaje);
				teclado = entrada.next();
				valor = Integer.parseInt(teclado);
				loop = false;
			} catch (Exception e) {
				System.out.println("Introduce un numero entero [1..10]");
			}
		} while (loop);

		return valor;
	}

	public String obtenerString(String mensaje) {
		String palabra = "";
		boolean loop = true;

		do {
			try {
				System.out.println(mensaje);
				palabra = entrada.next();
				loop = false;
			} catch (Exception e) {
				System.out.println("Palabras porfavor");
			}
		} while (loop);

		return palabra;
	}

	public char letraMayuscula(String mensaje) {
		char letra = 0;
		String teclado;
		boolean loop = true;

		do {
			try {
				System.out.print(mensaje);
				teclado = entrada.next();
				letra = teclado.charAt(0);
				if (letra < 'A' || letra > 'F' || teclado.length() > 1) {
					throw new Exception();
				}
				loop = false;
			} catch (Exception e) {
				System.out.println("¡Error! Letra no valida");
			}
		} while (loop);

		return letra;

	}

	public float obtenerFloat(String mensaje) {
		float valor = 0;
		String teclado;
		boolean loop = true;

		do {
			try {
				System.out.println(mensaje);
				teclado = entrada.next();
				valor = Float.parseFloat(teclado);
				loop = false;
			} catch (Exception e) {
				System.out.println("Introduce un numero con decimales [1..1.1..5.5]");
			}
		} while (loop);

		return valor;
	}

}