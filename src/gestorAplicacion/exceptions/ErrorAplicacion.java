package gestorAplicacion.exceptions;

import java.io.Serializable;

public class ErrorAplicacion extends Exception implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public ErrorAplicacion(String complemento) {
			super("Manejo de errores de la Aplicacion: "+complemento);
		}
}
