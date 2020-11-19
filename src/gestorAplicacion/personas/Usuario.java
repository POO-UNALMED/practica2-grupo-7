package gestorAplicacion.personas;
import java.util.ArrayList;
import gestorAplicacion.productos.*;
import java.io.Serializable;
public class Usuario extends Persona implements Empleado,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int caja;
	public static final int salario_cajero=75000;
	public  ArrayList <Compra> Compras = new ArrayList<Compra>();
	public Usuario(String nombre,String id,String genero,String direccion,String telFijo,String numCelular,int Caja){
		super(nombre,id,genero,direccion,telFijo,numCelular);
		this.caja=Caja;
	}

	public ArrayList<Compra> getCompras() {
		return Compras;
	}
	public void setCompras(ArrayList<Compra> compras) {
		Compras = compras;
	}
	@Override
	//IMPLEMENTA EL METODO DE EMPLEADO
	public String datosEmpleado() {
		return this.nombre+" es un cajero, identificado con "+this.id+
				   ", su direccion es "+this.direccion+", tiene telefono fijo "+
				   this.telFijo+", y numero adicional "+this.numCelular+"atiende en la caja"+
				   this.caja+" y tiene con un sueldo de "+Usuario.salario_cajero;
	}
	//3ERA FUNCIONALIDAD PERMITE AL USUARIO QUEJARSE DE UNA COMPRA EN ESPECIFICO
	public void Quejarse(Compra compra,String queja) {
		for (int i=0;i<Compras.size();i++) {
			if (compra==Compras.get(i)) {
				Compras.get(i).menID.Quejas.add(queja);
			}
		}
	}
		
}
