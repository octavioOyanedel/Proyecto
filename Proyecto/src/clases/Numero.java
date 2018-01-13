package clases;

public class Numero {
	
	private int numero;
	private static final int largoSorteo = 14;
	private static final int largoPatron = 3;
	
	public Numero() {
		
		numero = 0;
		
	}
	
	public Numero(int uno) {
		
		numero = uno;
		
	}
	
	public static int getLargosorteo() {
		
		return largoSorteo;
		
	}

	public int getNumero() {
		
		return numero;
		
	}

	public static int getLargopatron() {
		
		return largoPatron;
		
	}

	public void setNumero(int numero) {
		
		this.numero = numero;
		
	}		

}//fin clase
