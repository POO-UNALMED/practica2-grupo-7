package GUI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import gestorAplicacion.productos.*;
import gestorAplicacion.exceptions.empate;
import gestorAplicacion.personas.*;
import BaseDatos.*;
public class GUI extends Application{
	public static int hojaActual;
	public static int Opcionsuper=0;
	Random RNG=new Random();
	private static Producto product;
	private static Label stockLabel=new Label("");
	Compra compra;
	Factura factura;
	Supermercado superm=null;
	ArrayList<Supermercado>supermercados=Lector.getListaObjetos();
	ArrayList<Carnes>listacarnes=new ArrayList<Carnes>();
	ArrayList<Lacteos>listalacteos=new ArrayList<Lacteos>();
	ArrayList<Vegetales>listavegetales=new ArrayList<Vegetales>();
	ArrayList<Tecnologia>listatecnologia=new ArrayList<Tecnologia>();
	Usuario cajero=null;
	public void start(Stage primarystage) {
		
		
		//P3
		Label saludo=new Label("Bienvenido a nuestro programa");
		HBox p3= new HBox(saludo);
		saludo.setTextAlignment(TextAlignment.CENTER);
		saludo.setFont(new Font("TimesNewRoman",15));
		saludo.setTextFill(Color.BLUE);
		saludo.setPrefWidth(125);
		saludo.setWrapText(true);
		ImageView[] Wimg = new ImageView[5];
		
		
		//P4
		try {
			//imagen1
			Image image1 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\relacionada1.jpg"));
			ImageView im1= new ImageView(image1);
			im1.setFitHeight(150);
			im1.setFitWidth(165);
			Wimg[0] = im1;
			
			Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\relacionada2.jpg"));
			ImageView im2= new ImageView(image2);
			im2.setFitHeight(150);
			im2.setFitWidth(165);
			Wimg[1] = im2;
			
			Image image3 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\relacionada3.jpg"));
			ImageView im3= new ImageView(image3);
			im3.setFitHeight(150);
			im3.setFitWidth(165);
			Wimg[2] = im3;
			
			Image image4 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\relacionada4.jpg"));
			ImageView im4= new ImageView(image4);
			im4.setFitHeight(150);
			im4.setFitWidth(165);
			Wimg[3] = im4;
			
			Image image5 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\relacionada5.jpg"));
			ImageView im5= new ImageView(image5);
			im5.setFitHeight(150);
			im5.setFitWidth(165);

			Wimg[4] = im5;
			
		} catch (FileNotFoundException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setHeaderText("Error");
			info.setTitle("No se pudo encontrar la imagen");
			info.setContentText("");
			info.show();
		}
		GridPane p4=new GridPane();
		Button bt4=new Button("Ingresar al Sistema");
		bt4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		p4.setHgap(10);
		p4.setVgap(15);
		p4.setAlignment(Pos.BOTTOM_RIGHT);
		p4.add(bt4, 0, 1);
		p4.add(Wimg[0], 0, 0);
		Wimg[0].setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				p4.getChildren().remove(Wimg[0]);
				p4.add(Wimg[1], 0,0);

			}
		});
		Wimg[1].setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				p4.getChildren().remove(Wimg[1]);
				p4.add(Wimg[2], 0,0);

			}
		});
		Wimg[2].setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				p4.getChildren().remove(Wimg[2]);
				p4.add(Wimg[3], 0,0);

			}
		});
		Wimg[3].setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				p4.getChildren().remove(Wimg[3]);
				p4.add(Wimg[4], 0,0);

			}
		});
		Wimg[4].setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				p4.getChildren().remove(Wimg[4]);
				p4.add(Wimg[0], 0,0);

			}
		});
		//VBOX
		VBox p1=new VBox(p3,p4);
		p1.setAlignment(Pos.CENTER_LEFT);
		BorderPane.setAlignment(p3,Pos.TOP_LEFT);
		//P5
		Label[] hojaVida = new Label[3];
		hojaVida[0] = new Label( "Juan Carlos\n Ocupacion: Estudiante\n Aspiraciones: Ser un gamedev profesional \n Esperanza: Que el profe nos ponga 5");
		hojaVida[0].setPrefWidth(200);
		hojaVida[0].setWrapText(true);
		hojaVida[1] = new Label("Santiago el furro jajajajajajajajajajajajajaja");
		hojaVida[1].setPrefWidth(200);
		hojaVida[1].setWrapText(true);
		hojaVida[2] = new Label("Andres el streamer jajajajajajajajajajajajajajajajajajaja");
		hojaVida[2].setPrefWidth(200);
		hojaVida[2].setWrapText(true);
		HBox p5=new HBox(hojaVida[0]);
		p5.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null , null)));	
		hojaActual = 0;
		
		
		//P6
		ImageView[] fotos = new ImageView[12];
		GridPane p6=new GridPane();
		try {
			//imagen1
			Image image1 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\juan1.jpg"));
			ImageView im1= new ImageView(image1);
			im1.setFitHeight(130);
			im1.setFitWidth(130);
			fotos[0] = im1;
			//imagen2
			Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\juan2.jpg"));
			ImageView im2= new ImageView(image2);
			im2.setFitHeight(130);
			im2.setFitWidth(130);
			fotos[1] = im2;
			//imagen3
			Image image3 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\juan3.jpg"));
			ImageView im3= new ImageView(image3);
			im3.setFitHeight(130);
			im3.setFitWidth(130);
			fotos[2] = im3;
			//imagen4
			Image image4 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\juan4.jpg"));
			ImageView im4= new ImageView(image4);
			im4.setFitHeight(130);
			im4.setFitWidth(130);
			fotos[3] = im4;
			//
			Image image5 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\santi5.jpg"));
			ImageView im5= new ImageView(image5);
			im5.setFitHeight(130);
			im5.setFitWidth(130);
			fotos[4] = im5;
			//
			Image image6 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\santi6.jpg"));
			ImageView im6= new ImageView(image6);
			im6.setFitHeight(130);
			im6.setFitWidth(130);
			fotos[5] = im6;
			Image image7 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\santi7.jpg"));
			ImageView im7= new ImageView(image7);
			im7.setFitHeight(130);
			im7.setFitWidth(130);
			fotos[6] = im7;
			Image image8 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\santi8.jpg"));
			ImageView im8= new ImageView(image8);
			im8.setFitHeight(130);
			im8.setFitWidth(130);
			fotos[7] = im8;
			Image image9 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\andres9.jpg"));
			ImageView im9= new ImageView(image9);
			im9.setFitHeight(130);
			im9.setFitWidth(130);
			fotos[8] = im9;
			Image image10 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\andres10.jpg"));
			ImageView im10= new ImageView(image10);
			im10.setFitHeight(130);
			im10.setFitWidth(130);
			fotos[9] = im10;
			//
			Image image11 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\andres11.jpg"));
			ImageView im11= new ImageView(image11);
			im11.setFitHeight(130);
			im11.setFitWidth(130);
			fotos[10] = im11;
			Image image12 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\andres12.jpg"));
			ImageView im12= new ImageView(image12);
			im12.setFitHeight(130);
			im12.setFitWidth(130);
			fotos[11] = im12;
			//
		} catch (FileNotFoundException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setHeaderText("Error");
			info.setTitle("ERROR");
			info.setContentText("No se pudo encontrar la imagen");
			info.show();
		}
		p6.add(fotos[0], 0, 0);
		p6.add(fotos[1], 0, 1);
		p6.add(fotos[2], 1, 0);
		p6.add(fotos[3], 1, 1);
		p6.setVgap(10);
		p6.setHgap(10);
		p6.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null , null)));
		p6.setAlignment(Pos.BOTTOM_RIGHT);
		//EVENTO CLICK1
		hojaVida[0].setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				p5.getChildren().remove(hojaVida[0]);
				p5.getChildren().add(hojaVida[1]);
				p6.getChildren().remove(fotos[0]);
				p6.add(fotos[4], 0,0);
				p6.getChildren().remove(fotos[1]);
				p6.add(fotos[5], 0,1);
				p6.getChildren().remove(fotos[2]);
				p6.add(fotos[6], 1,0);
				p6.getChildren().remove(fotos[3]);
				p6.add(fotos[7], 1,1);
			}
		});
		hojaVida[1].setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				p5.getChildren().remove(hojaVida[1]);
				p5.getChildren().add(hojaVida[2]);
				p6.getChildren().remove(fotos[4]);
				p6.add(fotos[8], 0,0);
				p6.getChildren().remove(fotos[5]);
				p6.add(fotos[9], 0,1);
				p6.getChildren().remove(fotos[6]);
				p6.add(fotos[10], 1,0);
				p6.getChildren().remove(fotos[7]);
				p6.add(fotos[11], 1,1);
			}
		});
		hojaVida[2].setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				p5.getChildren().remove(hojaVida[2]);
				p5.getChildren().add(hojaVida[0]);
				p6.getChildren().remove(fotos[8]);
				p6.add(fotos[0], 0,0);
				p6.getChildren().remove(fotos[9]);
				p6.add(fotos[1], 0,1);
				p6.getChildren().remove(fotos[10]);
				p6.add(fotos[2], 1,0);
				p6.getChildren().remove(fotos[11]);
				p6.add(fotos[3], 1,1);
			}
		});
		
		
		//P2
		VBox p2=new VBox(p5,p6);
		p2.setAlignment(Pos.CENTER_RIGHT);
		//
		BorderPane main1=new BorderPane();
		main1.setRight(p2);
		main1.setLeft(p1);
		//primarystage
		primarystage.setTitle("Ejemplo1");
		Scene scene1=new Scene(main1,450,450);
		primarystage.setScene(scene1);
		primarystage.show();


		//segunda pagina
		Button btnExito=new Button();
		Button btnD1=new Button();
		Button btnJybueno=new Button();
		Button btnJumbo=new Button();
		Label[] mensajeopcion = new Label[5];
		mensajeopcion[0] = new Label("No has escogido ningun supermercado");
		mensajeopcion[0].setPrefWidth(150);
		mensajeopcion[0].setWrapText(true);
		mensajeopcion[1] = new Label("has escogido supermercados EXITO");
		mensajeopcion[1].setPrefWidth(150);
		mensajeopcion[1].setWrapText(true);
		mensajeopcion[2] = new Label("has escogido supermercados D1");
		mensajeopcion[2].setPrefWidth(150);
		mensajeopcion[2].setWrapText(true);
		mensajeopcion[3] = new Label("has escogido supermercados J&B");
		mensajeopcion[3].setPrefWidth(150);
		mensajeopcion[3].setWrapText(true);
		mensajeopcion[4] = new Label("has escogido supermercados SURTIMAX");
		mensajeopcion[4].setPrefWidth(150);
		mensajeopcion[4].setWrapText(true);
		try {
			//imagen1
			Image image1 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\EXITO.jpg"));
			ImageView im1=new ImageView(image1);
			im1.setFitHeight(120);
			im1.setFitWidth(120);
			Button btn1 = new Button("EXITO", im1);
			btn1.setStyle("-fx-base: yellow;");
			btn1.setContentDisplay(ContentDisplay.TOP);
			btn1.setMaxSize(100, 50);
			btnExito=btn1;

			Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\D1.jpg"));
			ImageView im2=new ImageView(image2);
			im2.setFitHeight(120);
			im2.setFitWidth(120);
			Button btn2 = new Button("D1", im2);
			btn2.setStyle("-fx-base: coral;");
			btn2.setContentDisplay(ContentDisplay.TOP);
			btn2.setMaxSize(120, 50);
			btnD1=btn2;

			Image image3 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\J&B.jpg"));
			ImageView im3=new ImageView(image3);
			im3.setFitHeight(120);
			im3.setFitWidth(120);
			Button btn3 = new Button("J&B", im3);
			btn3.setStyle("-fx-base: mediumaquamarine;");
			btn3.setContentDisplay(ContentDisplay.TOP);
			btn3.setMaxSize(120, 50);
			btnJybueno=btn3;

			Image image4 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\JUMBO.jpg"));
			ImageView im4=new ImageView(image4);
			im4.setFitHeight(120);
			im4.setFitWidth(120);
			Button btn4 = new Button("SURTIMAX", im4);
			btn4.setStyle("-fx-base: greenyellow;");
			btn4.setContentDisplay(ContentDisplay.TOP);
			btn4.setMaxSize(120, 50);
			btnJumbo=btn4;

		} catch (FileNotFoundException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setHeaderText("Error");
			info.setTitle("No se pudo encontrar la imagen");
			info.setContentText("");
			info.show();
		}
		Label label2=new Label("Escoga el supermercado");
		label2.setAlignment(Pos.TOP_CENTER);
		Button btnback=new Button("Regresar");
		BorderPane lbl2wind=new BorderPane();
		lbl2wind.setTop(label2);
		lbl2wind.setCenter(mensajeopcion[0]);
		GridPane btnsuper=new GridPane();
		btnsuper.add(btnExito, 0, 0);
		btnsuper.add(btnD1, 1, 0);
		btnsuper.add(btnJybueno, 0, 1);
		btnsuper.add(btnJumbo, 1, 1);
		Button m2aceptar=new Button("Aceptar");
		HBox m2p2=new HBox(10,btnback,m2aceptar);
		BorderPane main2=new BorderPane();
		m2p2.setAlignment(Pos.CENTER);
		main2.setTop(lbl2wind);
		main2.setCenter(btnsuper);
		main2.setBottom(m2p2);
		Scene scene2=new Scene(main2,275,375);
		BorderPane inicial = new BorderPane();
		GridPane menu_bienvenida = new GridPane();
		menu_bienvenida.setPadding(new Insets(10,10,10,10));
		GridPane.setConstraints(menu_bienvenida, 2, 2);
		menu_bienvenida.setVgap(5);
		menu_bienvenida.setHgap(5);
		inicial.setCenter(menu_bienvenida);
		menu_bienvenida.setAlignment(Pos.CENTER);
		MenuBar barramenu= new MenuBar();
		Menu archivo = new Menu("Archivo");
		Menu procesos_consultas = new Menu("Procesos y consultas");
		Menu ayuda = new Menu("Ayuda");
		barramenu.getMenus().add(archivo);
		barramenu.getMenus().add(procesos_consultas);
		barramenu.getMenus().add(ayuda);
		MenuItem usuario = new MenuItem("Usuario");
		MenuItem salir = new MenuItem("Salir");
		MenuItem facturacion = new MenuItem("Comprar");
		MenuItem mas_facturas = new MenuItem("Mejor empleado");
		MenuItem mas_quejas = new MenuItem("Siguiente despido");
		MenuItem producto_mas_menos = new MenuItem("Producto mas y menos vendido");
		MenuItem salario = new MenuItem("Salarios");
		MenuItem agregar_producto = new MenuItem("Agregar producto");
		MenuItem acerca_de = new MenuItem("Acerca de");
		archivo.getItems().addAll(usuario,salir);
		procesos_consultas.getItems().addAll(facturacion,mas_facturas,mas_quejas,producto_mas_menos,salario,agregar_producto);
		ayuda.getItems().addAll(acerca_de);
		inicial.setTop(barramenu);
		Scene scene3=new Scene(inicial,300,300);
		//INGRESAR
		bt4.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				primarystage.setTitle("prueba2");
				primarystage.setScene(scene2);
				primarystage.show();


			}
		});
		btnback.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				Opcionsuper=0;
				lbl2wind.setCenter(mensajeopcion[0]);
				primarystage.setTitle("prueba1");
				primarystage.setScene(scene1);
				primarystage.show();


			}
		});
		btnExito.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				Opcionsuper=1;
				lbl2wind.setCenter(mensajeopcion[1]);
			}
		});
		btnD1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				Opcionsuper=2;
				lbl2wind.setCenter(mensajeopcion[2]);
			}
		});
		btnJybueno.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				Opcionsuper=3;
				lbl2wind.setCenter(mensajeopcion[3]);
			}
		});
		btnJumbo.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				Opcionsuper=4;
				lbl2wind.setCenter(mensajeopcion[4]);
			}
		});
		m2aceptar.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				try {
					if(Opcionsuper!=0) {
						superm=supermercados.get(Opcionsuper-1);
						for (int x=0;x<superm.getProducts().size();x++) {
							Producto pro=superm.getProducts().get(x);
							if (pro instanceof Carnes) {
								listacarnes.add((Carnes) pro);
							}
							else if(pro instanceof Lacteos) {
								listalacteos.add((Lacteos)pro);
							}
							else if(pro instanceof Vegetales) {
								listavegetales.add((Vegetales)pro);
							}
							else if(pro instanceof Tecnologia) {
								listatecnologia.add((Tecnologia)pro);
							}
						}
						int i=RNG.nextInt(superm.Cajero.size());
						cajero=superm.Cajero.get(i);
						Label bienvenida= new Label("Bienvenido al sistema de servicio del supermercado "+superm.getNombre()+".");
						menu_bienvenida.add(bienvenida,1,1);
						primarystage.setTitle("Usuario: "+cajero.getNombre()+".");
						primarystage.setScene(scene3);
						primarystage.show();
				}
				else {
						throw new Exception();
					}
			} catch (Exception e) {
				Alert info = new Alert(AlertType.ERROR);
				info.setHeaderText("Error");
				info.setTitle("ERROR");
				info.setContentText("No se ha seleccionado un supermercado");
				info.show();
			}


			}
		});
		Alert alerta_informacion = new Alert(AlertType.INFORMATION);
		Alert alerta_error = new Alert(AlertType.ERROR);
		usuario.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				alerta_informacion.setTitle("Informacion del usuario.");
				alerta_informacion.setHeaderText("Esta es la informacion que se tiene acerca del usuario:");
				alerta_informacion.setContentText("ID: "+cajero.getId()+"\n"+"Nombre: "+cajero.getNombre()+"\n"+"Genero: "+cajero.getGenero()+"\n");
				alerta_informacion.show();
			}
		});
		salir.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				primarystage.setTitle("Ventana de bienvenida.");
				menu_bienvenida.getChildren().clear();
				Opcionsuper=0;
				lbl2wind.setCenter(mensajeopcion[0]);
				primarystage.setScene(scene1);
			}
		});
		mas_facturas.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				try {
					superm.MejorMensajero();
					alerta_informacion.setTitle("Mejor empleado.");
					alerta_informacion.setHeaderText("Debido a su numero de facturas procesadas se ha determinado que el mejor empleado del supermercado "+superm.getNombre()+" es:");
					alerta_informacion.setContentText("-> "+superm.MejorMensajero().getNombre());
					alerta_informacion.show();
				} catch (empate e) {
					alerta_error.setTitle("Mejor empleado.");
					alerta_error.setHeaderText("Se ha producido un error a la hora de decidir el mejor empleado.");
					alerta_error.setContentText("Por motivos de empate o falta de ventas de no se ha podido definir al mejor empleado del supermercado "+superm.getNombre()+".");
					alerta_error.show();
				}
			}
		});
		mas_quejas.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				try {
					superm.MensajeroConMasQuejas();
					alerta_informacion.setTitle("Empleado con mas quejas.");
					alerta_informacion.setHeaderText("Debido a su alto numero de quejas se ha determino que el empleado mas deficiente del supermercado "+superm.getNombre()+" es:");
					alerta_informacion.setContentText("-> "+superm.MensajeroConMasQuejas().getNombre());
					alerta_informacion.show();
				} catch (empate e) {
					alerta_error.setTitle("Empleado con mas quejas.");
					alerta_error.setHeaderText("Se ha producido un error a la hora de verificar el empleado con mas quejas.");
					alerta_error.setContentText("Por motivos de empate o insuficientes quejas no se ha podido definir al empleado mas deficiente del supermercado "+superm.getNombre()+".");
					alerta_error.show();
				}
			}
		});
		producto_mas_menos.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				try {
					superm.prodMasPopular();
					try {
						superm.prodMenosPopular();
						alerta_informacion.setTitle("Popularidad de productos.");
						alerta_informacion.setHeaderText("Debido a sus numeros de ventas se ha determinado que el producto mas y menos popular, respectivamente del supermercado "+superm.getNombre()+" son:");
						alerta_informacion.setContentText("+ "+superm.prodMasPopular()+"\n"+"- "+superm.prodMenosPopular());
						alerta_informacion.show();
					} catch (empate e) {
						alerta_informacion.setTitle("Popularidad de productos.");
						alerta_informacion.setHeaderText("Debido a su numero de ventas se ha determinado que el producto mas popular del supermercado "+superm.getNombre()+" es:");
						alerta_informacion.setContentText("+ "+superm.prodMasPopular()+"\n"+"No se ha podido determinar el producto menos popular.");
						alerta_informacion.show();
					}
				} catch (empate e) {
					try {
						superm.prodMenosPopular();
						alerta_informacion.setTitle("Popularidad de productos.");
						alerta_informacion.setHeaderText("Debido a su numero de venta se ha determinado que el producto menos popular del supermercado "+superm.getNombre()+" es:");
						alerta_informacion.setContentText("+ "+superm.prodMenosPopular()+"\n"+"No se ha podido determinar el producto mas popular.");
						alerta_informacion.show();
					} catch (empate i) {
						alerta_error.setTitle("Popularidad de productos.");
						alerta_error.setHeaderText("Se ha producido un error a la hora de verificar el producto mas y menos popular.");
						alerta_error.setContentText("Por motivos de empate o insuficientes ventas no se ha podido definir el producto mas y menos popular del supermercado "+superm.getNombre()+".");
						alerta_error.show();
					}
				}
				}
		});
		salario.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				String salarios="";
				for (int k=0;k<superm.Empleados.size();k++) {
					salarios+=superm.Empleados.get(k).getNombre()+": "+superm.Empleados.get(k).pagoTotal()+" Pesos\n";
				}
				alerta_informacion.setTitle("Salarios.");
				alerta_informacion.setHeaderText("Los siguientes son los nombres de los empleado del supermercado "+superm.getNombre()+" y sus respectivos salarios:");
				alerta_informacion.setContentText(salarios);
				alerta_informacion.show();
			}
		});
		acerca_de.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				alerta_informacion.setTitle("Acerca de:");
				alerta_informacion.setHeaderText("Estos son los creadores de este gran y glorioso programa:");
				alerta_informacion.setContentText("Andres Bañol Casasbuenas \nJuan Carlos Munera Arango \nSantiago Herrera Pineda");
				alerta_informacion.show();
			}
		});
		//ingresar la cantidad a comprar//
		GridPane paisan= new GridPane();
		paisan.setAlignment(Pos.CENTER);
		paisan.setVgap(10); 
		paisan.add(new Label("Stock disponible del producto seleccionado: "), 0, 0);
		paisan.add(stockLabel, 1, 0);
		paisan.add(new Label("Cantidad a comprar: "),0,1);
		TextField text1=new TextField();
		paisan.add(text1, 1, 1);
		Button confirmar= new Button("Confirmar");
		Button nel= new Button("Cancelar");
		HBox feedear= new HBox(10);
		feedear.getChildren().addAll(confirmar,nel);
		paisan.add(feedear, 1, 2);
		
		//Compras 1era Pantalla

		BorderPane lavida=new BorderPane();
		GridPane encabezado=new GridPane();
		encabezado.setAlignment(Pos.CENTER);
		encabezado.setPadding(new Insets(20,20,20,10));
		encabezado.add(new Label("Seleccione el tipo de producto"),0 , 0);
		GridPane pie=new GridPane();
		pie.setAlignment(Pos.CENTER);
		pie.setPadding(new Insets(20,20,20,10));
		Button regresarMenuTipos=new Button("Regresar");
		pie.add(regresarMenuTipos,0 , 0);
		HBox lol=new HBox(20);
		lol.setAlignment(Pos.CENTER);
		lol.setPadding(new Insets(10,10,10,10));
		ImageView[] fotosTipo= new ImageView[4];
		try {
		//Imagenes carne, vegetales, tecnologia y lacteos
		ImageView imagenvegetales = new ImageView(new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\vegetales.jpg")));
		ImageView imagencarne = new ImageView(new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\carne.jpg")));
		ImageView imagentecno = new ImageView(new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\tecnologia.jpg")));
		ImageView imagenlacteos = new ImageView(new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\lacteos.jpg")));
		imagenvegetales.setFitHeight(150);
		imagenvegetales.setFitWidth(165);
		fotosTipo[0]=imagenvegetales;
		imagencarne.setFitHeight(150);
		imagencarne.setFitWidth(165);
		fotosTipo[1]=imagencarne;
		imagentecno.setFitHeight(150);
		imagentecno.setFitWidth(165);
		fotosTipo[2]=imagentecno;
		imagenlacteos.setFitHeight(150);
		imagenlacteos.setFitWidth(165);
		fotosTipo[3]=imagenlacteos;
		}
		catch(FileNotFoundException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setHeaderText("Error");
			info.setTitle("No se pudo encontrar la imagen");
			info.setContentText("");
			info.show();
		}
		Button carnes=new Button("Carnes",fotosTipo[1]);
		carnes.setContentDisplay(ContentDisplay.BOTTOM);
		Button vegetales=new Button("Vegetales",fotosTipo[0]);
		Button tecnologia=new Button("Tecnologia",fotosTipo[2]);
		Button lacteos=new Button("Lacteos",fotosTipo[3]);
		lacteos.setContentDisplay(ContentDisplay.BOTTOM);
		tecnologia.setContentDisplay(ContentDisplay.BOTTOM);
		vegetales.setContentDisplay(ContentDisplay.BOTTOM);
		lol.getChildren().addAll(carnes,vegetales,tecnologia,lacteos);
		lavida.setTop(encabezado);
		lavida.setCenter(lol);
		lavida.setBottom(pie);

		// mostrar los productos disponibles del tipo elegido
		class ComprarHandler implements EventHandler<ActionEvent>{

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Button boton= (Button) event.getSource();
				String text=boton.getText().substring(8);
				for(Producto i: superm.getProducts()) {
					if(i.getNom_producto().equals(text)) {
						product=i;
					}
				}				
				stockLabel.setText(product.getStock()+"");
				inicial.setCenter(paisan);
			}
			
		}
		class RegresarHandler implements EventHandler<ActionEvent>{
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				primarystage.setTitle("Compra");
				inicial.setCenter(lavida);
			}
		}
		
		//Ingresar el Banco//
		String bancosGenericos[]= {"Bancolombia", "Banco Caja Social", "Banco de Bogota", "Davivienda", "Banco Generico 434123"};
		ComboBox bancos= new ComboBox(FXCollections.observableArrayList(bancosGenericos));
		bancos.setPromptText("Escoja su Banco");
		Button confirBanco=new Button("Confirmar");
		HBox botonesBanco=new HBox();
		botonesBanco.setPadding(new Insets(10,10,10,10));
		botonesBanco.getChildren().addAll(confirBanco);
		BorderPane dominion= new BorderPane();
		dominion.setCenter(bancos);
		dominion.setBottom(botonesBanco);
		

		//handlers//
		facturacion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent inicompra) {
				// TODO Auto-generated method stub
				primarystage.setTitle("Compra");
				inicial.setCenter(lavida);
			    Random RNG2=new Random();
			    int y=RNG2.nextInt(superm.Empleados.size());
				compra=new Compra(cajero, null, superm.Empleados.get(y), superm);
			}
			
		});
		regresarMenuTipos.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				inicial.setCenter(menu_bienvenida);
			}
			
		});
				carnes.setOnMouseClicked(new EventHandler<MouseEvent>(){
					//contenido carnes//
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						primarystage.setTitle("Carnes");
						if(listacarnes.isEmpty()) {
							alerta_error.setTitle("Tipo de Producto Agotado");
							alerta_error.setHeaderText("Se ha producido un error a la hora de verificar la existencia de este tipo de producto");
							alerta_error.setContentText("el producto solicitado no se encuentra disponible");
							alerta_error.show();
						}
						else {		
							GridPane tft= new GridPane();
							BorderPane lor= new BorderPane();
							tft.setGridLinesVisible(true);
							tft.setPadding(new Insets(10,10,10,10));
							Label[] encabe=new Label[3];
							encabe[0]=new Label("Nombre");
							encabe[1]=new Label("Cantidad");
							encabe[2]=new Label("Precio");
							RowConstraints row1=new RowConstraints();
							row1.setPercentHeight(10);		
							tft.getRowConstraints().add(row1);
							for(int i=0;i<3;i++) {
								encabe[i].setPrefWidth(100);
								tft.add(encabe[i], i, 0);
								encabe[i].setAlignment(Pos.CENTER);
							}		
							int size=listacarnes.size();
							for(int i=0;i<size;i++) {		
								Carnes producto=listacarnes.get(i);
								Button buy=new Button("comprar "+producto.getNom_producto());
								ComprarHandler comprarh=new ComprarHandler();
								buy.setOnAction(comprarh);
								tft.add(buy, 4, i+1);
								Label[] info=new Label[3];
								info[0]=new Label(producto.getNom_producto());
								info[1]=new Label(""+producto.getStock());
								info[2]=new Label(producto.getPrecio()+"");
								info[0].setPrefWidth(100);
								info[1].setPrefWidth(100);
								info[2].setPrefWidth(100);
								tft.add(info[0], 0, i+1);
								tft.add(info[1], 1, i+1);
								tft.add(info[2], 2, i+1);
								info[0].setAlignment(Pos.CENTER);
								info[1].setAlignment(Pos.CENTER);
								info[2].setAlignment(Pos.CENTER);
								RowConstraints a= new RowConstraints();
								a.setPercentHeight(30);
								tft.getRowConstraints().add(a);
							}
							lor.setCenter(tft);
							GridPane aram= new GridPane();
							aram.setHgap(10);
							aram.setAlignment(Pos.CENTER);
							Button regresar=new Button("Regresar");
							aram.add(regresar,0,0);
							RegresarHandler regreh=new RegresarHandler();
							regresar.setOnAction(regreh);
							lor.setBottom(aram);
							inicial.setCenter(lor);
						}
					}
					
				});
				vegetales.setOnMouseClicked(new EventHandler<MouseEvent>(){
					//contenido/ vegetales/
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						primarystage.setTitle("Vegetales");
						if(listavegetales.isEmpty()) {
							alerta_error.setTitle("Tipo de Producto Agotado");
							alerta_error.setHeaderText("Se ha producido un error a la hora de verificar la existencia de este tipo de producto");
							alerta_error.setContentText("el producto solicitado no se encuentra disponible");
							alerta_error.show();
						}
						else {		
							GridPane tft= new GridPane();
							BorderPane lor= new BorderPane();
							tft.setGridLinesVisible(true);
							tft.setPadding(new Insets(10,10,10,10));
							Label[] encabe=new Label[3];
							encabe[0]=new Label("Nombre");
							encabe[1]=new Label("Cantidad");
							encabe[2]=new Label("Precio");
							RowConstraints row1=new RowConstraints();
							row1.setPercentHeight(10);		
							tft.getRowConstraints().add(row1);
							for(int i=0;i<3;i++) {
								encabe[i].setPrefWidth(100);
								tft.add(encabe[i], i, 0);
								encabe[i].setAlignment(Pos.CENTER);
							}		
							int size=listavegetales.size();
							for(int i=0;i<size;i++) {	
								Vegetales producto=listavegetales.get(i);
								Button buy=new Button("comprar "+producto.getNom_producto());
								ComprarHandler comprarh=new ComprarHandler();
								buy.setOnAction(comprarh);
								tft.add(buy, 4, i+1);
								Label[] info=new Label[3];
								info[0]=new Label(producto.getNom_producto());
								info[1]=new Label(""+producto.getStock());
								info[2]=new Label(producto.getPrecio()+"");
								info[0].setPrefWidth(100);
								info[1].setPrefWidth(100);
								info[2].setPrefWidth(100);
								tft.add(info[0], 0, i+1);
								tft.add(info[1], 1, i+1);
								tft.add(info[2], 2, i+1);
								info[0].setAlignment(Pos.CENTER);
								info[1].setAlignment(Pos.CENTER);
								info[2].setAlignment(Pos.CENTER);
								RowConstraints a= new RowConstraints();
								a.setPercentHeight(30);
								tft.getRowConstraints().add(a);
							}
							lor.setCenter(tft);
							GridPane aram= new GridPane();
							aram.setHgap(10);
							aram.setAlignment(Pos.CENTER);
							Button regresar=new Button("Regresar");
							aram.add(regresar,0,0);
							RegresarHandler regreh=new RegresarHandler();
							regresar.setOnAction(regreh);
							lor.setBottom(aram);
							inicial.setCenter(lor);
						}
					}
				});
				tecnologia.setOnMouseClicked(new EventHandler<MouseEvent>(){
					//contenido tecnologia//
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						primarystage.setTitle("Tecnologia");
						if(listatecnologia.isEmpty()) {
							alerta_error.setTitle("Tipo de Producto Agotado");
							alerta_error.setHeaderText("Se ha producido un error a la hora de verificar la existencia de este tipo de producto");
							alerta_error.setContentText("el producto solicitado no se encuentra disponible");
							alerta_error.show();
						}
						else {		
							GridPane tft= new GridPane();
							BorderPane lor= new BorderPane();
							tft.setGridLinesVisible(true);
							tft.setPadding(new Insets(10,10,10,10));
							Label[] encabe=new Label[3];
							encabe[0]=new Label("Nombre");
							encabe[1]=new Label("Cantidad");
							encabe[2]=new Label("Precio");
							RowConstraints row1=new RowConstraints();
							row1.setPercentHeight(10);		
							tft.getRowConstraints().add(row1);
							for(int i=0;i<3;i++) {
								encabe[i].setPrefWidth(100);
								tft.add(encabe[i], i, 0);
								encabe[i].setAlignment(Pos.CENTER);
							}		
							int size=listatecnologia.size();
							for(int i=0;i<size;i++) {		
								Tecnologia producto=listatecnologia.get(i);
								Button buy=new Button("comprar "+producto.getNom_producto());
								ComprarHandler comprarh=new ComprarHandler();
								buy.setOnAction(comprarh);
								tft.add(buy, 4, i+1);
								Label[] info=new Label[3];
								info[0]=new Label(producto.getNom_producto());
								info[1]=new Label(""+producto.getStock());
								info[2]=new Label(producto.getPrecio()+"");
								info[0].setPrefWidth(100);
								info[1].setPrefWidth(100);
								info[2].setPrefWidth(100);
								tft.add(info[0], 0, i+1);
								tft.add(info[1], 1, i+1);
								tft.add(info[2], 2, i+1);
								info[0].setAlignment(Pos.CENTER);
								info[1].setAlignment(Pos.CENTER);
								info[2].setAlignment(Pos.CENTER);
								RowConstraints a= new RowConstraints();
								a.setPercentHeight(30);
								tft.getRowConstraints().add(a);
							}
							lor.setCenter(tft);
							GridPane aram= new GridPane();
							aram.setHgap(10);
							aram.setAlignment(Pos.CENTER);
							Button regresar=new Button("Regresar");
							aram.add(regresar,0,0);
							RegresarHandler regreh=new RegresarHandler();
							regresar.setOnAction(regreh);
							lor.setBottom(aram);
							inicial.setCenter(lor);
						}
					}
				});
				lacteos.setOnMouseClicked(new EventHandler<MouseEvent>(){
					//contenido lacteos//
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						primarystage.setTitle("Lacteos");
						if(listalacteos.isEmpty()) {
							alerta_error.setTitle("Tipo de Producto Agotado");
							alerta_error.setHeaderText("Se ha producido un error a la hora de verificar la existencia de este tipo de producto");
							alerta_error.setContentText("el producto solicitado no se encuentra disponible");
							alerta_error.show();
						}
						else {		
							GridPane tft= new GridPane();
							BorderPane lor= new BorderPane();
							tft.setGridLinesVisible(true);
							tft.setPadding(new Insets(10,10,10,10));
							Label[] encabe=new Label[3];
							encabe[0]=new Label("Nombre");
							encabe[1]=new Label("Cantidad");
							encabe[2]=new Label("Precio");
							RowConstraints row1=new RowConstraints();
							row1.setPercentHeight(10);		
							tft.getRowConstraints().add(row1);
							for(int i=0;i<3;i++) {
								encabe[i].setPrefWidth(100);
								tft.add(encabe[i], i, 0);
								encabe[i].setAlignment(Pos.CENTER);
							}		
							int size=listalacteos.size();
							for(int i=0;i<size;i++) {		
								Lacteos producto=listalacteos.get(i);
								Button buy=new Button("comprar "+producto.getNom_producto());
								ComprarHandler comprarh=new ComprarHandler();
								buy.setOnAction(comprarh);
								tft.add(buy, 4, i+1);
								Label[] info=new Label[3];
								info[0]=new Label(producto.getNom_producto());
								info[1]=new Label(""+producto.getStock());
								info[2]=new Label(producto.getPrecio()+"");
								info[0].setPrefWidth(100);
								info[1].setPrefWidth(100);
								info[2].setPrefWidth(100);
								tft.add(info[0], 0, i+1);
								tft.add(info[1], 1, i+1);
								tft.add(info[2], 2, i+1);
								info[0].setAlignment(Pos.CENTER);
								info[1].setAlignment(Pos.CENTER);
								info[2].setAlignment(Pos.CENTER);
								RowConstraints a= new RowConstraints();
								a.setPercentHeight(30);
								tft.getRowConstraints().add(a);
							}
							lor.setCenter(tft);
							GridPane aram= new GridPane();
							aram.setHgap(10);
							aram.setAlignment(Pos.CENTER);
							Button regresar=new Button("Regresar");
							aram.add(regresar,0,0);
							RegresarHandler regreh=new RegresarHandler();
							regresar.setOnAction(regreh);
							lor.setBottom(aram);
							inicial.setCenter(lor);
						}
					}
				});
				nel.setOnMouseClicked(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						text1.clear();
						inicial.setCenter(lavida);
					}
				});
				EventHandler<ActionEvent> ev1= new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent f) {
						// TODO Auto-generated method stub
						int cantCompra= Integer.valueOf(text1.getText());						
						compra.agregar(product, cantCompra, superm);
						Alert a = new Alert(AlertType.CONFIRMATION,"Su compra ha sido procesada, desea continuar comprando?"
								,ButtonType.YES,ButtonType.NO);
						a.setTitle("Confirmar Compra");
						a.setHeaderText("Su compra ha sido procesada, desea continuar comprando?");
						a.show();
						text1.clear();
						a.setOnCloseRequest(new EventHandler<DialogEvent>() {

							@Override
							public void handle(DialogEvent no) {
								// TODO Auto-generated method stub
								if(a.getResult().equals(ButtonType.YES)) {
									inicial.setCenter(lavida);
								}
								else{
									inicial.setCenter(dominion);
								};
							}
							
						});;
					}
					
				};
				confirmar.setOnAction(ev1);
				confirBanco.setOnMouseClicked(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						String bancoSelec=(String) bancos.getValue();
						factura=compra.efectuarCompra(bancoSelec);
						compra.setFact(factura);						
						Alert a = new Alert(AlertType.CONFIRMATION,"Compra realizada, tiene alguna queja respecto al servicio?"
								,ButtonType.YES,ButtonType.NO);
						a.setTitle("Reclamos");
						a.show();
						a.setOnCloseRequest(new EventHandler<DialogEvent>() {

							@Override
							public void handle(DialogEvent no) {
								// TODO Auto-generated method stub
								if(a.getResult().equals(ButtonType.YES)) {
								}
								else{
									alerta_informacion.setTitle("Factura");
									alerta_informacion.setHeaderText("La informacion de su factura es:");
									alerta_informacion.setContentText(factura.toString());
									alerta_informacion.show();
									alerta_informacion.setOnCloseRequest(new EventHandler<DialogEvent>() {

										@Override
										public void handle(DialogEvent event) {
											// TODO Auto-generated method stub
											inicial.setCenter(menu_bienvenida);
										}

									});
								};
							}
							
						});
					}

					});
									
				
}

	
public static void main(String[] args) {
	Lector.Leer();
   launch(args);
}
}
