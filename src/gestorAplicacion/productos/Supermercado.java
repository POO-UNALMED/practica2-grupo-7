package gestorAplicacion.productos;
import gestorAplicacion.personas.*;
import java.util.ArrayList;
import java.util.Collections;
import BaseDatos.*;
import java.io.Serializable;
public class Supermercado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String direccion;
	private String tel;
	private ArrayList<Producto> Products = new ArrayList<>();
	public  ArrayList<String> Estadisticas= new ArrayList<>();
	public ArrayList<Mensajero> Empleados;
	public ArrayList<Usuario> Cajero;
	public Supermercado(String nombre, String direccion, String tel,ArrayList<Usuario> Cajeros,ArrayList<Mensajero> Mensajero) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.tel = tel;
		this.Empleados=Mensajero;
		this.Cajero=Cajeros;
		Lector.getListaObjetos().add(this);
	}
    public ArrayList<Producto> getProducts() {
		return Products;
	}
    public void setProducts(ArrayList<Producto> products) {
		Products = products;
	}
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTel() {
		return tel;
	}
	public void Inventario(){
		for(Producto i:Products) {
			System.out.println("hay"+i.stock+"del producto"+i.nom_producto);
		}
	}
	public void AgregarProdLacteo(String id_producto, int precio, String nom_producto, int stock) {
	   Lacteos w=new Lacteos(id_producto,precio,nom_producto,stock,"Lacteo");
	   Products.add(w);
	}
	public void AgregarProdCarnes(String id_producto, int precio, String nom_producto, int stock,int peso) {
		   Carnes w=new Carnes(id_producto,precio,nom_producto,stock,"Carnico",peso);
		   Products.add(w);
	}
	public void AgregarProdVegetales(String id_producto, int precio, String nom_producto, int stock) {
		   Vegetales w=new Vegetales(id_producto,precio,nom_producto,stock,"Vegetal");
		   Products.add(w);
	}
	public void AgregarProdTecnologia(String id_producto, int precio, String nom_producto, int stock) {
		   Tecnologia w=new Tecnologia(id_producto,precio,nom_producto,stock,"Tecnologia");
		   Products.add(w);
	}
	//FUNCIONALIDAD 2 (IMPLEMENTADA) BUSCA MOSTRAR EL PRODUCTO MAS POPULAR A TRAVES DE CONTEO DE LA CANTIDAD DE VECES QUE EL NOMBRE ES GUARDADO EN LA LISTA ESTADISTICA
	public String prodMasPopular(){
		String prodPop="";
		int mayorveces = 0;
		boolean empateProdmas=false;
		for(int i = 0; i < Estadisticas.size(); i++) {
			int veces=Collections.frequency(Estadisticas, Estadisticas.get(i));
			if(veces > mayorveces) {
				empateProdmas=false;
				mayorveces = veces;
				prodPop=Estadisticas.get(i);
			}
			else if(veces==mayorveces) {
				empateProdmas=true;
			}
		}
		if (empateProdmas==true) {
			return null;
		}
		else {
			return prodPop;
		}
		
	}
	// BUSCA MOSTRAR EL PRODUCTO MENOS POPULAR A TRAVES DE CONTEO DE LA CANTIDAD DE VECES QUE EL NOMBRE ES GUARDADO EN LA LISTA ESTADISTICA
	public String prodMenosPopular() {
		String prodNoPop="";
		int menorveces=10000000;
		boolean empateProdmenos=false;
		for(int i = 0; i < Estadisticas.size(); i++) {
			int vecesmenos=Collections.frequency(Estadisticas, Estadisticas.get(i));
			if(vecesmenos<menorveces) {
				empateProdmenos=false;
				menorveces=vecesmenos;
				prodNoPop=Estadisticas.get(i);
			}
			else if(vecesmenos==menorveces) {
				empateProdmenos=true;
			}
		}
		if (empateProdmenos==true) {
			return null;
		}
		else {
			return prodNoPop;
		}
	}
	//5TA FUNCIONALIDAD (IMPLEMENTADA) BUSCA EL MENSAJERO CON MAS FACTURAS EN SU LISTA DE FACTURAS(ESO INDICARIA QUE HA HECHO LA MAYOR CANTIDAD DE ENVIOS)
	public Mensajero MejorMensajero() {
		Mensajero mejorEmpleado=null;
		int mayor=0;
		boolean empate=false;
		for (Mensajero m:Empleados) {
			int cantidadFact=m.facturas.size();
			if (cantidadFact>mayor) {
				empate=false;
				mayor=cantidadFact;
				mejorEmpleado=m;
			}
			else if(cantidadFact==mayor){
			    empate=true;
			}
		}
		if (empate==true) {
			return null;
		}
		else{
			return mejorEmpleado;
		}

	}
	//3ERA FUNCIONALIDAD(IMPLEMENTADA) BUSCA EL MENSAJERO CON EL MAYOR TAMAÑO DE QUEJAS EN SU LISTA DE QUEJAS
	public Mensajero MensajeroConMasQuejas() {
		Mensajero PeorEmpleado=null;
		int mayorquejas=0;
		boolean empateQuejas=false;
		for (Mensajero m:Empleados) {
			int tamañoquejas=m.Quejas.size();
			if (tamañoquejas>mayorquejas) {
				empateQuejas=false;
				mayorquejas=tamañoquejas;
				PeorEmpleado=m;
			}
			else if(tamañoquejas==mayorquejas){
			    empateQuejas=true;
			}
		}
		if (empateQuejas==true) {
			return null;
		}
		else{
			return PeorEmpleado;
		}
		
	}
	//ULTIMA FUNCIONALIDAD QUIERE MOSTRAR CUANTAS PERSONAS GANARON LA RIFA AL COMPRAR UNA ARTICULO DE TECNOLOGIA DE MAS DE 1 MILLON, BUSCA LOS NOMBRES QUE REFIERAN A XIAMI NOTE S(EL PREMIO)
	public void GanadoresRifa() {
		int ganadoresrifa=Collections.frequency(Estadisticas, "Xiami Note S");
		System.out.println(ganadoresrifa+"Personas ganaron un celular Xiamo Note S al tener la suerte de ganar la rifa");
	}
}

