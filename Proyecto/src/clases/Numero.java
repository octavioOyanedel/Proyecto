package clases;

public class Numero {
	
	private int numero;
	private static final int largoTotal = 25;
	private static final int largoSorteo = 15;
	private static final int largoFila = 5;
	private static final int largoSorteoSinId = 14;
	private static final int largoPatron = 7;
	
	public Numero() {
		
		numero = 0;
		
	}

	public static int getLargototal() {
		
		return largoTotal;
		
	}

	public static int getLargosorteo() {
		
		return largoSorteo;
		
	}

	public static int getLargofila() {
		
		return largoFila;
		
	}

	public static int getLargosorteosinid() {
		
		return largoSorteoSinId;
		
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
