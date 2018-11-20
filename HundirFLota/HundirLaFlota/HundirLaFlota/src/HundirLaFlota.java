//import miLibreria.Metodos;

public class HundirLaFlota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] vOrdenador = new String[11][11];
		String[][] vUsuario = new String[11][11];
		int[] barcos = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };

		rellenar(vOrdenador);
		rellenar(vUsuario);
		colocarBarcos(vOrdenador, barcos);
		colocarBarcos(vUsuario, barcos);
		mostrar(vOrdenador);
		mostrar(vUsuario);

	}

	/*
	 * Con éste método indicamos que si en la posicion 1 y la posicion 2 del
	 * tablero hay una "B" ( que indica la posición de un Barco que ya está
	 * colocado), nos diga que hay colisión, y por tanto hay que buscar otra
	 * posición.
	 */
	public static boolean hayColision(String[][] vector, int posicion1, int posicion2) {
		boolean colision;

		if (vector[posicion1][posicion2].compareTo("B") == 0) {

			return colision = true;

		} else {

			return colision = false;

		}
	}

	public static boolean fueraTabla(String[][] vector, int posicion1, int posicion2) {
		boolean fuera;
		if (posicion1 > vector.length - 1 || posicion2 > vector[0].length - 1) {

			return fuera = true;

		} else if (posicion1 <= 0 || posicion2 <= 0) {

			return fuera = true;

		} else {

			return fuera = false;

		}
	}

	/*
	 * 
	 */
	public static void colocarBarcos(String[][] vector, int[] barcos) {

		int barco = 0;
		// posicion1: Entero que almacena .....
		//
		int posicion1, posicion2, orientacion;
		int pbarco1;
		boolean colocar;

		while (barco < barcos.length) {

			colocar = true;
			orientacion = (int) (Math.random() * 4 + 1);
			posicion1 = (int) (Math.random() * vector.length);
			posicion2 = (int) (Math.random() * vector[0].length);
			pbarco1 = 0;

			while (colocar == true && pbarco1 < barcos[barco]) {

				switch (orientacion) {
				case 1:
					if (fueraTabla(vector, posicion1 - pbarco1, posicion2) == true) {
						colocar = false;
					} else if (hayColision(vector, posicion1 - pbarco1, posicion2) == true) {
						colocar = false;
					}
					break;
				case 2:
					if (fueraTabla(vector, posicion1, posicion2 + pbarco1) == true) {
						colocar = false;
					} else if (hayColision(vector, posicion1, posicion2 + pbarco1) == true) {
						colocar = false;
					}
					break;
				case 3:
					if (fueraTabla(vector, posicion1 + pbarco1, posicion2) == true) {
						colocar = false;
					} else if (hayColision(vector, posicion1 + pbarco1, posicion2) == true) {
						colocar = false;
					}
					break;
				case 4:
					if (fueraTabla(vector, posicion1, posicion2 - pbarco1) == true) {
						colocar = false;
					} else if (hayColision(vector, posicion1, posicion2 - pbarco1) == true) {
						colocar = false;
					}
					break;
				}
				pbarco1++;
			}

			if (colocar == true) {
				pbarco1 = 0;
				while (pbarco1 < barcos[barco]) {
					switch (orientacion) {
					case 1:
						vector[posicion1 - pbarco1][posicion2] = "B";
						break;
					case 2:
						vector[posicion1][posicion2 + pbarco1] = "B";
						break;
					case 3:
						vector[posicion1 + pbarco1][posicion2] = "B";
						break;
					case 4:
						vector[posicion1][posicion2 - pbarco1] = "B";
						break;
					}
					pbarco1++;
				}
				barco++;
			}
		}

	}

	public static void rellenar(String[][] vector) {
		vector[0][0] = " ";
		char letra = 'A';
		String simbolo = "-";

		for (int i = 1, j = 0; i < vector[0].length; i++, j++) {
			vector[0][i] = Character.toString((char) (letra + j));
		}

		for (int i = 1; i < vector.length; i++) {
			vector[i][0] = Integer.toString(i - 1);
		}

		for (int i = 1; i < vector.length; i++) {
			for (int j = 1; j < vector[0].length; j++) {
				vector[i][j] = simbolo;
			}
		}

	}

	public static void mostrar(String[][] vector) {
		for (int columna = 0; columna < vector[0].length; columna++) {
			System.out.print(vector[0][columna] + " ");
		}
		System.out.println();

		for (int fila = 1; fila < vector.length; fila++) {
			System.out.print(vector[fila][0] + " ");
			for (int columna = 1; columna < vector[0].length; columna++) {
				System.out.print(vector[fila][columna] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
}