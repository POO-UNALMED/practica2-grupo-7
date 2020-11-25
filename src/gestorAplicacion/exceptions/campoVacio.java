package gestorAplicacion.exceptions;

import java.io.Serializable; 

public class campoVacio extends ErrorAplicacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public campoVacio() {
		super("holi");
	}
}
