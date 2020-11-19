package gestorAplicacion.personas;
import java.io.Serializable;
public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String id;
	protected String genero;
	protected String direccion;
	protected String telFijo;
	protected String numCelular;

		
	public Persona(String nombre, String id, String genero, String direccion, String telFijo, String numCelular) {
		this.nombre = nombre;
		this.id = id;
		this.genero = genero;
		this.direccion = direccion;
		this.telFijo = telFijo;
		this.numCelular = numCelular;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelFijo() {
		return telFijo;
	}
	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}
	public String getNumCalcular() {
		return numCelular;
	}
	public void setNumCalcular(String numCalcular) {
		this.numCelular = numCalcular;
	}

	

}
