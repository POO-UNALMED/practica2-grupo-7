package gestorAplicacion.personas;
import gestorAplicacion.productos.*;
import java.io.Serializable;

import java.util.*;
public class Mensajero extends Persona implements Empleado,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String transporte;
	public int contador;
	public int gan_adicional;
	public int propina=0;
	public int salario_mensajero=0;
	public Supermercado superm;
	public boolean salarioregistrado=false;
	public ArrayList <Factura> facturas=new ArrayList <Factura>();
	public ArrayList<String> Quejas=new ArrayList<>();
	public Mensajero(String nombre, String id,String genero,String direccion,String telFijo,String numCelular,String transporte, int contador, int gan_adicional,Supermercado superm) {
		super(nombre,id,genero,direccion,telFijo,numCelular);
		this.transporte = transporte;
		this.contador = contador;
		this.gan_adicional = gan_adicional;
		this.superm=superm;
		superm.Empleados.add(this);
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	public int getGan_adicional() {
		return gan_adicional;
	}
	public void setGan_adicional(int gan_adicional) {
		this.gan_adicional = gan_adicional;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	//BUSCA MOSTRAR EL SALARIO TOTAL DEL MENSAJERO
	public int pagoTotal() {
		if (salarioregistrado==false) {
			for (int i=0;i<facturas.size();i++) {
				salario_mensajero=0;
				salario_mensajero+=facturas.get(i).total*0.05;
			}
			salarioregistrado=true;
			return salario_mensajero+=propina+bonoFactura();
		}
		else {
			return salario_mensajero;
		}
	}
	//SOBRECARGA METODO 1 (BUSCA MOSTRAR EL SALARIO DEL MENSAJERO, Y SI ESTE ES EL MENSAJERO DEL MES SE LE DA UN BONO)
	public int pagoTotal(Mensajero mensajero) {
		if (mensajero==superm.MejorMensajero()) {
			return mensajero.pagoTotal()+100000;
		}
		else {
			return mensajero.pagoTotal();
		}
	}
	//GENERA EL TOTAL DE BONO SEGUN LA CANTIDAD DE FACTURAS
	public int bonoFactura() {
		int bonomult=this.facturas.size()/5;
		int bono=5000*bonomult;
		return bono;
	}
	@Override
	//IMPLEMENTA EL METODO DE EMPLEADO
	public String datosEmpleado() {
		return this.nombre+" es un mensajero, identificado con "+this.id+
			   ", su direccion es "+this.direccion+", tiene telefono fijo "+
			   this.telFijo+", y numero adicional "+this.numCelular+" utiliza "+this.transporte
			   +" y tiene con un sueldo de "+this.salario_mensajero;
	}

}
