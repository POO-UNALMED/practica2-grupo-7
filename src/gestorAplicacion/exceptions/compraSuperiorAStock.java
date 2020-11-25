package gestorAplicacion.exceptions;

import java.io.Serializable;

public class compraSuperiorAStock extends ErrorAplicacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public compraSuperiorAStock() {
		super("wey no");
	}
}
