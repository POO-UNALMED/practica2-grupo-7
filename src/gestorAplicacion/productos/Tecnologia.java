package gestorAplicacion.productos;
import java.util.Random;
import java.io.Serializable;
public class Tecnologia extends Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final double iva=0.19;
	double valorAgregado;
	public Tecnologia() {
		super("12345",550000,"Xiaomi NoteS",10,"Mobil");
		this.valorAgregado();
	}
	public Tecnologia(String id_producto, int precio, String nom_producto, int stock, String tipo_producto) {
		super(id_producto,precio,nom_producto,stock,tipo_producto);
		this.valorAgregado();
	}
	//SE IMPLEMENTA EL METODO ABSTRACTO DE PRODUCTO
	public String Descripcion() {
		return "Lo Ultimo en tecnologia al alcanze,un  "+this.nom_producto+" de ultima tecnologia";
	}
	//SE IMPLEMENTA EL METODO ABSTRACTO DE PRODUCTO
	public double valorAgregado() {
		valorAgregado=this.precio*iva;
		return valorAgregado;
	}
	//METODO QUE DETERMINA LA SUERTE DEL JUGADOR
	public static boolean GirarRuleta() {
		Random RNG=new Random();
		int NumberRolled=RNG.nextInt(101);
		if(NumberRolled<=10) {
			return true;
		}
		else {
			return false;
		}
	}


}
