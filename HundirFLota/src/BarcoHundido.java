
public class BarcoHundido {
//Con éste método indicamos que si hemos tocado un barco, que lea si todas las posiciones de ese barco estan tocadas,
//y si lo están, decir que hemos hundido el barco.
	
	public static void barcoHundido (int [] vector, int barco) {
		int numero = vector[barco] -1;
		vector[barco]=numero;
		
		if (vector [barco]==0) {
			
			switch(barco) {
			
			case 0:
			System.out.println("Has hundido el acorazado");
			break;
			
			case 1:case 2:
			System.out.println("Has hundido un buque");
			break;
			
			case 3:case 4:case 5:
			System.out.println("Has hundido un destructor");
			break;
			
			case 6:case 7:case 8:case 9:
			System.out.println("Has hundido una lancha");
			break;
			
			
			}
			
		}else {
			System.out.println("Has tocado un barco ");
		}
	}

}