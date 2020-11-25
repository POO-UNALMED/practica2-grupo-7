package gestorAplicacion.exceptions;

import java.io.Serializable;

public class empate extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public empate() {
		super("Ha ocurrido un empate");
	}
}