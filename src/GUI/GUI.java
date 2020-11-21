package GUI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
public class GUI extends Application{
	public static int hojaActual;
	public static int Opcionsuper=0;
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
		mensajeopcion[4] = new Label("has escogido supermercados JUMBO");
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
			Button btn4 = new Button("JUMBO", im4);
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
		BorderPane main3=new BorderPane();
		Scene scene3=new Scene(main3,300,300);
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
						primarystage.setTitle("prueba3");
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
		
	}
	

public static void main(String[] args) {
   launch(args);
}
}
