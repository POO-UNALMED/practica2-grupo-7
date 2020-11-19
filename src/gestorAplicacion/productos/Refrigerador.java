package gestorAplicacion.productos;

public interface Refrigerador {
//METODO ABSTRACTO PUBLICO QUE BUSCA VER SI EL PRODUCTO PEUDE PERECER
public boolean esPerecedero();
//PARA MOSTRAR LA TEMPERATURA A LA QUE SE DEBE GUARDAR
public int temperaturaPreferida();
}
