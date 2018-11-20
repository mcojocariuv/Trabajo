import miLibreria.Metodos;

public class HundirLaFlota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] vOrdenador = new String[11][11];
		String[][] vUsuario = new String[11][11];
		String[][] vDisparos = new String[11][11];
		int[] barcos = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };
		int[] vidaBarcos = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };
		int turnos = 50;

		rellenar(vOrdenador);
		rellenar(vUsuario);
		rellenar(vDisparos);
		colocarBarcos(vOrdenador, barcos);
		colocarBarcos(vUsuario, barcos);
		// mostrar(vOrdenador);

		mostrar(vUsuario);
		mostrar(vDisparos);

		do {
			System.out.println("Turno " + turnos);
			System.out.println();
			disparoUsuario(vOrdenador, vDisparos);
			disparoAleatorio(vUsuario);
			mostrar(vOrdenador);
			mostrar(vUsuario);
			mostrar(vDisparos);
			turnos--;
		} while (turnos > 0);
//		System.out.println("¡HAS GANADO!");
//
//		System.out.println("¡Has perdido!");
	}

//	Con este metodo comprobamos si en esta posicion hay un barco, en caso de que tengamos
//	algun caracter distinto de el "-" que representa el agua significa que hay agua.
	public static boolean hayColision(String[][] vector, int posicion1, int posicion2) {
		boolean colision = false;

		// En caso de haber barco devolvera un true en caso de que no devolvera un
		// false.
		if (vector[posicion1][posicion2].compareTo("-") != 0) {

			return colision = true;

		} else {

			return colision = false;

		}
	}

//	Con este metodo comprobamos si la posicion en la que vamos a colocar el barco esta
//	fuera de la tabla de juego.
	public static boolean fueraTabla(String[][] vector, int posicion1, int posicion2) {
		boolean fuera;

		// Primero se comprueba si sale por el borde derecho o inferior de la tabla
		// comparando con lo largo de los vectores.
		if (posicion1 > vector.length - 1 || posicion2 > vector[0].length - 1) {

			return fuera = true;

			// Luego compara las posiciones con 0 porque en los vectores son el limite
			// superior y el izquierdo.
		} else if (posicion1 <= 0 || posicion2 <= 0) {

			return fuera = true;

		} else {

			return fuera = false;

		}
	}

//	Con este metodo y utilizando los metodos de comprobacion "hayColision" y "fueraTabla"
//	colocaremos los barcos en el tablero.
	public static void colocarBarcos(String[][] vector, int[] barcos) {
		// Con esta variable podremos indicar la posicion del vector que indica como de
		// largo es cierto barco.
		int barco = 0;

		// Este String se usara para cuando pintemos los barcos saber a cual nos
		// referimos.
		String numeroBarco;

		// Con estas tres variables se elegira la posicion y su orientacion.
		int posicion1, posicion2, orientacion;

		// Esta variable se usara para realizar una cuenta.
		int pbarco1;

		// Con este valor boolean se indicara si se puede colocar el barco segun lo que
		// devuelvan los metodos de comprobar.
		boolean colocar;

		while (barco < barcos.length) {

			numeroBarco = Integer.toString(barco);
			colocar = true;
			orientacion = (int) (Math.random() * 4 + 1);
			posicion1 = (int) (Math.random() * vector.length);
			posicion2 = (int) (Math.random() * vector.length);
			pbarco1 = 0;

			while (colocar == true && pbarco1 < barcos[barco]) {

				// En este bucle utilizamos los metodos de comprobacion para comprobar que se
				// puede colocar el barco segun la posicion y su orientacion.
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

			// Segun el resultado de bucle anterior este if se realizara o no, en caso de
			// hacerse pintara el barco.
			if (colocar == true) {
				pbarco1 = 0;
				while (pbarco1 < barcos[barco]) {
					switch (orientacion) {
					case 1:
						vector[posicion1 - pbarco1][posicion2] = numeroBarco;
						break;
					case 2:
						vector[posicion1][posicion2 + pbarco1] = numeroBarco;
						break;
					case 3:
						vector[posicion1 + pbarco1][posicion2] = numeroBarco;
						break;
					case 4:
						vector[posicion1][posicion2 - pbarco1] = numeroBarco;
						break;
					}
					pbarco1++;
				}
				barco++;
			}
		}

	}

//	Utilizando este metodo comrpobamos si ya se ha echo un disparo en cierta
//	cordenada.
	public static boolean comprobarDisparo(String[][] vector, int posicion1, int posicion2) {
		boolean tocado = false;

		if (vector[posicion1][posicion2].compareTo("T") == 0 || vector[posicion1][posicion2].compareTo("X") == 0) {
			return tocado = true;
		} else {
			return tocado = false;
		}

	}

//	Con este metodo el usuario selecciona la casilla donde el usuario quiere realizar un
//	"disparo".
	public static void disparoUsuario(String[][] vector1, String[][] vector2) {
		Metodos entrada = new Metodos();

		// En estas dos variables se guardaran la cordenada del disparo.
		int posicion1, posicion2 = 0;
		// Gracias a estas variables podremos luego averiguar la posicion que ocupa la
		// letra de la cordenada en el vector.
		char posicionLetra;
		String Letra;
		// Con esta variable podremos seguir o acabar el siguiente bucle segun sea
		// necesario.
		boolean disparar = false;

		// En este bucle se utiliza los metodos de comprobarDisparo y hayColision para
		// saber si se puede disparar y de si damos a un barco o no, en caso de dar a un
		// barco se marcara una "T", en caso de fallar se marcara con una "X".
		do {
			posicion1 = entrada.obtenerEntero("Escribe un numero del 0 al 9");
			posicionLetra = entrada.letraMayuscula("Escribe una letra de la A a la J");
			for (int i = 0; i < vector1.length; i++) {
				Letra = Character.toString(posicionLetra);
				if (vector1[0][i].compareTo(Letra) == 0) {
					posicion2 = i;
				}
			}

			if (comprobarDisparo(vector2, posicion1 + 1, posicion2) == true) {
				System.out.println("Estas cordenadas no son validas");
				System.out.println();
			} else {
				disparar = true;
			}

			if (disparar = true) {
				if (hayColision(vector1, posicion1 + 1, posicion2) == true) {
					vector1[posicion1 + 1][posicion2] = "T";
					vector2[posicion1 + 1][posicion2] = "T";
				} else {
					vector1[posicion1 + 1][posicion2] = "X";
					vector2[posicion1 + 1][posicion2] = "X";
				}
			}
		} while (disparar == false);

	}

//  Este metodo al igual que disparoUsuario es para marcar la casilla de "disparo" pero para
//	que lo haga el Ordenador.
	public static void disparoAleatorio(String[][] vector1) {

		int posicion1, posicion2;
		boolean disparar = false;

		do {

			posicion1 = (int) (Math.random() * vector1.length - 1);
			posicion2 = (int) (Math.random() * vector1[0].length);
			if (fueraTabla(vector1, posicion1 + 1, posicion2) != true
					|| comprobarDisparo(vector1, posicion1 + 1, posicion2) != true) {
				disparar = true;
			}

			if (disparar = true) {
				if (hayColision(vector1, posicion1 + 1, posicion2) == true) {
					vector1[posicion1 + 1][posicion2] = "T";
				} else {
					vector1[posicion1 + 1][posicion2] = "X";
				}
			}
		} while (disparar == false);

	}

// En este metodo se crea el tablero.
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

// Con este metodo mostramos los tableros.
	public static void mostrar(String[][] vector) {
		for (int columna = 0; columna < vector[0].length; columna++) {
			System.out.print(vector[0][columna] + " ");
		}
		System.out.println();

		for (int fila = 1; fila < vector.length; fila++) {
			System.out.print(vector[fila][0] + " ");
			for (int columna = 1; columna < vector[0].length; columna++) {
				if (vector[fila][columna].compareTo("-") != 0 && vector[fila][columna].compareTo("T") != 0
						&& vector[fila][columna].compareTo("X") != 0) {
					System.out.print("B ");
				} else {
					System.out.print(vector[fila][columna] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();

	}
}