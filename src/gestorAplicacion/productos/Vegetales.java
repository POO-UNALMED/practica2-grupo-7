package gestorAplicacion.productos;
import java.io.Serializable;
public class Vegetales extends Producto implements Refrigerador,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final double iva=0.19;
	double valorAgregado;

	public Vegetales(String id_producto, int precio, String nom_producto, int stock, String tipo_producto) {
		super(id_producto,precio,nom_producto,stock,tipo_producto);
		this.valorAgregado();
	}
	//SE IMPLEMENTA EL METODO ABSTRACTO DE PRODUCTO
	public String Descripcion() {
		return "Los vegetales mas frescos que puedas encontrar,un paquete de  "+this.nom_producto;
	}
	//SE IMPLEMENTA EL METODO ABSTRACTO DE PRODUCTO
	public double valorAgregado() {
		valorAgregado=this.precio*iva;
		return valorAgregado;
	}
	//SE IMPLEMENTA EL METODO DE REFRIGERADOR
	public boolean esPerecedero() {
		return true;
	}
	//SE IMPLEMENTA EL METODO DE REFRIGERADOR
	public int temperaturaPreferida() {
		return 5;
	}
	

}
