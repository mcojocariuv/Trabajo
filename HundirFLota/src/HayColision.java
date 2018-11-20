
public class HayColision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

 /*Utilizando la posicion1 y la posicion2, indicamos la posición del vector
 * y luego comprobamos si en él hay una "B" (que indica que hay un barco), 
 * y en ése caso devuelve un "true".
 */
	public static boolean hayColision(String [][] vector, int posicion1, int posicion2) {
		boolean colision= false;
		
		if(vector[posicion1][posicion2]=="B") {
			colision=true;
		}
		return colision;
	}
}

