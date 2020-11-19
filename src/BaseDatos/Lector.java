package BaseDatos;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import gestorAplicacion.personas.*;
import gestorAplicacion.productos.*;
//Esta clase es la encargada de la serializacion de Objetos
public class Lector implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Path path;
	private static ObjectOutputStream o;
	private static OutputStream f;
	private static InputStream f1;
	private static ObjectInputStream o1; 
	private static ArrayList<Supermercado> listaObjetos=new ArrayList<>();
	public static ArrayList<Supermercado> getListaObjetos() {
		return listaObjetos;
	}
	public static void setListaObjetos(ArrayList<Supermercado> listaObjetos) {
		Lector.listaObjetos = listaObjetos;
	}
// Este bloque estatico se usa para crear el directorio temp y el archivo objetos.txt en donde se hara la serializacion, ademas de crear el caso base para probar el modelo.
// En caso de ya existir se crea el path necesario para llegar al archivo, el cual se usara en los metodos para leer y escribir objetos	
	static{
		File decoy=new File("");
		try {
			path = Files.createDirectory(Paths.get(decoy.getAbsolutePath()+"\\src\\BaseDatos").resolve("temp"));
			path= Files.createFile(path.resolve("Objetos.txt"));
			casoBase.crearObjetos();
			for (Supermercado e:listaObjetos) {
				System.out.println(e.getNombre());
			}
		} catch (IOException e) {
			path=Paths.get(decoy.getAbsolutePath()+"\\src\\BaseDatos\\temp\\Objetos.txt");
		}		
	}
//El metodo Leer() crea el stream necesario conectado al path creado anteriormente, luego crea un apuntador de tipo Supermercado y lo usa para pasar los objetos leidos a
//el arrayList listaObjetos para que el programa pueda usarlos luego.	
	public static void Leer() {
		try {
			f1 = Files.newInputStream(path,StandardOpenOption.READ);
			o1 =new ObjectInputStream(f1);
			Supermercado sup;
			do {
				sup= (Supermercado) o1.readObject();
				listaObjetos.add(sup);
				for(Mensajero i:sup.Empleados) {
					Compra.contadoridf+=i.facturas.size();
				}
			}
			while(o1!=null);
			o1.close();
		} catch (IOException e) {
			System.out.println("");
		}
		catch(ClassNotFoundException e) {
			System.out.println("e");
		}
	}
//El metodo Escribir() crea el stream necesario conectado al path, y despues serializa todos los objetos presentes en el arrayList listaObjetos, esto equivale a todos los
// objetos del sistema ya que cada supermercado tiene listas de cajeros y mensajeros, que a su vez tienen asociados facturas y todos los demas objetos que componen el modelo	
	public static void Escribir() {

		try {
			f = Files.newOutputStream(path,StandardOpenOption.WRITE);
			o= new ObjectOutputStream(f);
			for (Supermercado i: listaObjetos) {
				o.writeObject(i);
			}
			o.close();
		} catch (IOException e) {
			System.out.println("f");
		}

	}
}
