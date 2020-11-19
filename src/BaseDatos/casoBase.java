package BaseDatos;
import java.util.ArrayList;

import gestorAplicacion.personas.*;
import gestorAplicacion.productos.*;
public class casoBase {
// crearObjetos propone un grupo de arreglos con diferentes caracteristicas para llenar los constructores necesarios para los atributos de supermercado y por ende
// de las demas clases como mensajero, usuario y productos.
// Para los 2 primeros se escoge el indice del array usando numeros aleatorios diferentes para cada atributo.
// En los productos se tienen varios arrrays dependiendo de cada tipo de producto (carne, vegetales, tecnologia o lacteos), se elige un solo numero aleatoreamente
// y se recorren todos los arrays necesarios para llenar el constructor usandolo como indice.
// Por ultimo hay 3 arreglos dedicados a ciertos atributos de la clase supermercado, estos se recorren con la variable i del for principal para crear 4 supermercados
// haciendo uso ademas de las listas de productos, mensajeros y cajeros para asi llenar al completo los requerimientos del constructor
// el constructor de supermercado hace que cada objeto de esta clase sea añadido a el array listaObjetos en la clase lector, que es el array usado para serializar los objetos	
	public static void crearObjetos() {
		String[] nombresGenericos= new String[] {"Carlos", "Juan", "Rosa", "Rosalba", "Jorge", "Mariana", "Matilda", "Steven", "Zaratustra","Clara", "Rafael","Clarence"};
		String[] idsGenericos=new String[] {"1000294025", "923135078", "980432808", "997453286", "994395782", "967284910", "945285904", "999123456", "666666666","996734653", "998244075","989234086"};
		String[] generosGenericos=new String[] {"M", "N/A", "F", "F", "M", "F", "N/A", "N/A", "SuperM","F", "M","M"};
		String[] direccionesGenericas=new String[] {"Av 55 No. 13 23", "Calle 35b No 38 94", "Carrera 55 No 13 02", "Av 12 No 09 23", "Calle 13 No 12 10", "Carrera 13 No 12 03", "Calle 43 No 12 53", "Av 75 No 15 32", "Av 09 No 34 65","Calle 53 No 54 09", "Carrera 42 No 54 31","Calle 01 No 01 01"};
		String[] telGenericos=new String[] {"6123982", "8964729", "9472754", "1263585", "2583532", "35725427", "1133525", "56427436", "6666666","1252636", "13585474","2468495"};
		String[] celGenericos=new String[] {"3118640586", "3216784839", "3267653524", "3556458705", "3625673428", "3723458642", "3926542714", "3652376538", "6666666666","3472461423", "3527436235","3864569362"};
		String[] transportesGenericos=new String[] {"Carro", "Camion", "Caballo", "Potro", "Carro", "Deportivo", "Dron", "Caja", "Pie","Escoba", "Carruaje","Otra Persona Viva"};
		String[] nombresCarGenericos=new String[] {"Salchicha Zenu", "Jamon del Campo", "Solomo Salomon", "Carne Generica 323","Carne de Res Monsanto"};
		int[] preciosCarGenericos=new int[] {35, 188, 11, 8, 5};
		int[] pesosCarGenericos=new int[] {240, 34, 500, 500, 100};
		String[] nombresTecnoGenericos=new String[] {"Samsung Galaxy S20", "Xiaomi la mejor relacion calidad precio (Mi Note 10)", "MSI GF95 Thin 9SD", "iPhone 12 Pro", "iPhone 8"};
		int[] preciosTecnoGenericos=new int[] {2900000,2100000, 4900000, 3800000,2800000 };
		String[] nombresLacGenericos=new String[] {"Leche Entera Colanta", "Leche Deslactosada Montefrio", "Yogurt de fresa Alpina", "Alma de una vaca oprimida por el sistema", "Quesito Colantita"};
		int[] preciosLacGenericos=new int[] {2000,3000, 1100, 100, 2500 };
		String[] nombresVegGenericos=new String[] {"Lechuga", "Pimenton", "Pepino", "Zanahoria", "Arracacha"};
		int[] preciosVegGenericos=new int[] {2280,2650, 5900, 1500, 2500 };
		String[] id_prodGenericos= new String[] {"1233245", "9328494", "2938764", "2938574", "9483765", "4850293", "5920482", "2948276", "2291847","5743821", "3728954","3849182"};
		String[] nomSupGenericos= new String[] {"Exito", "D1", "Justo y Bueno","Surtimax"};
		String[] dirSupGenericos= new String[] {"Av 89 No 20 12", "Calle 102 No 10 39", "Carrera 209B No 12 43","Av No 30 28"};
		String[] telSupGenericos= new String[] {"7455444", "6041919", "4891222", "3117979"};
		for(int i=0; i<4;i++) {

			 ArrayList<Mensajero> mensajeros=new ArrayList<>();
			 ArrayList<Usuario> cajeros=new ArrayList<>();
			 ArrayList<Producto> productos= new ArrayList<>();	
			 Supermercado supp=new Supermercado(nomSupGenericos[i],dirSupGenericos[i],telSupGenericos[i],cajeros, mensajeros);
			for(int k=0; k<4;k++) {
				new Mensajero(nombresGenericos[(int) Math.floor(Math.random()*11+1)],idsGenericos[(int) Math.floor(Math.random()*11+1)],generosGenericos[(int) Math.floor(Math.random()*11+1)],direccionesGenericas[(int) Math.floor(Math.random()*11+1)],
						telGenericos[(int) Math.floor(Math.random()*11+1)],celGenericos[(int) Math.floor(Math.random()*11+1)],transportesGenericos[(int) Math.floor(Math.random()*11+1)],0,0,supp);
				supp.Cajero.add(new Usuario(nombresGenericos[(int) Math.floor(Math.random()*11+1)],idsGenericos[(int) Math.floor(Math.random()*11+1)],generosGenericos[(int) Math.floor(Math.random()*11+1)],direccionesGenericas[(int) Math.floor(Math.random()*11+1)],
						telGenericos[(int) Math.floor(Math.random()*11+1)],celGenericos[(int) Math.floor(Math.random()*11+1)],i));			
			}
			for(int k=0;k<5;k++) {
				int rout=(int) Math.floor(Math.random()*4+1);
				switch(rout) {
				case(1):  
					productos.add(new Carnes(id_prodGenericos[(int) Math.floor(Math.random()*11+1)], preciosCarGenericos[k],nombresCarGenericos[k],(int) Math.floor(Math.random()*15+1), "Carnico", pesosCarGenericos[k]));
					break;
				
				case(2):
					productos.add(new Tecnologia(id_prodGenericos[(int) Math.floor(Math.random()*11+1)], preciosTecnoGenericos[k],nombresTecnoGenericos[k],(int) Math.floor(Math.random()*15+1), "Tecnologia"));
					break;
				
				case(3):
					productos.add(new Lacteos(id_prodGenericos[(int) Math.floor(Math.random()*11+1)], preciosLacGenericos[k],nombresLacGenericos[k],(int) Math.floor(Math.random()*15+1), "Lacteo"));
					break;
				case(4):
					productos.add(new Vegetales(id_prodGenericos[(int) Math.floor(Math.random()*11+1)], preciosVegGenericos[k],nombresVegGenericos[k],(int) Math.floor(Math.random()*15+1), "Vegetal"));
					break;
				}
				
			}
			supp.setProducts(productos);
		}
	}
}
