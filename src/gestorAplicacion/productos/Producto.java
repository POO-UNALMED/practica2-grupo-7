package gestorAplicacion.productos;
import java.io.Serializable;
public abstract class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id_producto;
	public int precio;
	public String nom_producto;
	public int stock;
	public String tipo_producto;

	public Producto(String id_producto, int precio, String nom_producto, int stock, String tipo_producto) {
		this.id_producto = id_producto;
		this.precio = precio;
		this.nom_producto = nom_producto;
		this.stock = stock;
		this.tipo_producto = tipo_producto;	
	}
	public String getId_producto() {
		return id_producto;
	}
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNom_producto() {
		return nom_producto;
	}
	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}
	public int getContador() {
		return stock;
	}
	public void setContador(int contador) {
		this.stock = contador;
	}
	public String getTipo_producto() {
		return tipo_producto;
	}
	public void setTipo_producto(String tipo_producto) {
		this.tipo_producto = tipo_producto;
	}	
	
    //METODO PARA AGREGAR MAS ITEMS AL STOCK DE UN PRODUCTO
	public void reStock(int cantidad) {
		this.stock+=cantidad;
	}
	//COMPRUEBA SI LA CANTIDAD A COMPRAR SI ALCANZA DENTRO DEL INVENTARIO QUE ESTE TENGA
	public boolean comprobarStock(Producto pro,int cant) {
		
	    int totalprod=pro.stock-cant;
		if (totalprod>0) {
			return true;	
	}
		else {
			return false;
		}
}
	//METODO ABSTRACTO QUE BUSCA QUE CADA TIPO DE PRODUCTO GENERE SU PROPIA DESCRIPCION
	public abstract String Descripcion();
	//METODO ABSTRACTO QUE BUSCA GENERA EL EQUIVALENTE A VALOR AGREGADO (IVA*PRECIO) DE CADA TIPO DE PRODUCTO
	public abstract double valorAgregado();
	
}
