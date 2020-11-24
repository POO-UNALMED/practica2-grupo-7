package gestorAplicacion.productos;
import gestorAplicacion.personas.*;
import java.util.ArrayList;
import java.io.Serializable;
public class Compra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario user;
	private Factura fact;
	public Mensajero menID;
	public Supermercado superm;
	public static int contadoridf=0;
	public boolean propinabool=false;
	private double sumValorAgregado=0;
	private ArrayList<DetalleFactura>DetalleFacturaList=new ArrayList<>();
	public double subtotal_fact;
	public double total;
	public Compra(Usuario user,Factura fac,Mensajero menID,Supermercado superm){
		this.user=user;
		this.fact=fac;
		this.menID=menID;
		this.superm=superm;
	}
	public Usuario getUser() {
		return user;
	}
	public Mensajero getMenID() {
		return menID;
	}
	public void setMenID(Mensajero menID) {
		this.menID = menID;
	}
	public Supermercado getSuperm() {
		return superm;
	}
	public void setSuperm(Supermercado superm) {
		this.superm = superm;
	}
	public static int getContadoridf() {
		return contadoridf;
	}
	public static void setContadoridf(int contadoridf) {
		Compra.contadoridf = contadoridf;
	}
	public boolean isPropinabool() {
		return propinabool;
	}
	public void setPropinabool(boolean propinabool) {
		this.propinabool = propinabool;
	}
	public double getSumValorAgregado() {
		return sumValorAgregado;
	}
	public void setSumValorAgregado(double sumValorAgregado) {
		this.sumValorAgregado = sumValorAgregado;
	}
	public ArrayList<DetalleFactura> getDetalleFacturaList() {
		return DetalleFacturaList;
	}
	public void setDetalleFacturaList(ArrayList<DetalleFactura> detalleFacturaList) {
		DetalleFacturaList = detalleFacturaList;
	}
	public double getSubtotal_fact() {
		return subtotal_fact;
	}
	public void setSubtotal_fact(double subtotal_fact) {
		this.subtotal_fact = subtotal_fact;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Factura getFact() {
		return fact;
	}
	public void setFact(Factura fact) {
		this.fact = fact;
	}
	//EL METODO QUE SUMA LOS PRECIOS,REDUCE LA CANTIDAD,CREA EL DETALLE DE FACTURA CORRESPONDIENTE Y VERIFICA LA RIFA DE UN PRODUCTO AL SER PEDIDO
	public void agregar(Producto pro,int cant,Supermercado superm) {	
		if (pro.comprobarStock(pro,cant)==true) {
			for (int i=0;i<cant;i++) {
				superm.Estadisticas.add(pro.nom_producto);
			}
			subtotal_fact+=pro.precio*cant;
			sumValorAgregado+=pro.valorAgregado()*cant;
			pro.stock-=cant;
			Factura facteje=null;
			DetalleFactura item=new DetalleFactura(facteje,pro,cant,pro.precio*cant);
			DetalleFacturaList.add(item);
		}
		else {
			System.out.println("El producto se encuentra agotado");
		}
	}
	//ESTE METODO CREA LA FACTURA CON LOS DATOS MODIFICADOS POR EL METODO AGREGAR, ADEMAS VERIFICA EL TOTAL PARA DAR PROPINAS,ASIGNA UNA FACTURA A LOS DETALLES DE LA FACTURA,GUARDA LA INFORMACION DE ESTA COMPRA EN LA LISTA DE COMPRAS DEL CAJERO Y ASIGNA UN OBJETO FACTURA A EL OBJETO COMPRA
	public Factura efectuarCompra(String banco) {
		contadoridf++;
		//1ERA FUNCIONALIDAD(IMPLEMENTADA)
		if (subtotal_fact<20000) {
			menID.propina+=10000;
			propinabool=true;
		}
		total=sumValorAgregado+subtotal_fact;
		if (propinabool=true) {
			total+=10000;
			propinabool=false;
		}
		user.Compras.add(this);
		Factura fact_id=new Factura(menID,contadoridf,user,total,sumValorAgregado,subtotal_fact,banco,this,DetalleFacturaList);
		menID.facturas.add(fact_id);
		for (int i=0;i<DetalleFacturaList.size();i++) {
			DetalleFacturaList.get(i).setId_factura(fact_id);
		}
		return fact_id ;	
		}
	}
	
	
	


