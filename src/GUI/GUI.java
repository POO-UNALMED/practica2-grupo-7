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
	public void start(Stage primarystage) {
		
		
		//P3
		Label saludo=new Label("Bienvenido a nuestro programa");
		HBox p3= new HBox(saludo);
		saludo.setTextAlignment(TextAlignment.CENTER);
		saludo.setFont(new Font("TimesNewRoman",15));
		saludo.setTextFill(Color.BLUE);
		saludo.setPrefWidth(125);
		saludo.setWrapText(true);
		ImageView[] Wimg = new ImageView[8];
		
		
		//P4
		try {
			//imagen1
			Image image1 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara1.jpg"));
			ImageView im1= new ImageView(image1);
			im1.setFitHeight(100);
			im1.setFitWidth(115);

			Wimg[0] = im1;
			Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara2.jpg"));
			ImageView im2= new ImageView(image2);
			im2.setFitHeight(100);
			im2.setFitWidth(115);

			Wimg[1] = im2;
			
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
				p4.add(Wimg[0], 0,0);

			}
		});
		//VBOX
		VBox p1=new VBox(p3,p4);
		p1.setAlignment(Pos.CENTER_LEFT);
		BorderPane.setAlignment(p3,Pos.TOP_LEFT);
		//P5
		Label[] hojaVida = new Label[3];
		hojaVida[0] = new Label( "Juan Carlos el pro jajajajajajajajajajajajajajaja");
		hojaVida[0].setPrefWidth(150);
		hojaVida[0].setWrapText(true);
		hojaVida[1] = new Label("Santiago el furro jajajajajajajajajajajajajaja");
		hojaVida[1].setPrefWidth(150);
		hojaVida[1].setWrapText(true);
		hojaVida[2] = new Label("Andres el streamer jajajajajajajajajajajajajajajajajajaja");
		hojaVida[2].setPrefWidth(150);
		hojaVida[2].setWrapText(true);
		HBox p5=new HBox(hojaVida[0]);
		p5.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null , null)));	
		hojaActual = 0;
		
		
		//P6
		ImageView[] fotos = new ImageView[8];
		GridPane p6=new GridPane();
		try {
			//imagen1
			Image image1 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara1.jpg"));
			ImageView im1= new ImageView(image1);
			im1.setFitHeight(80);
			im1.setFitWidth(80);
			fotos[0] = im1;
			//imagen2
			Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara2.jpg"));
			ImageView im2= new ImageView(image2);
			im2.setFitHeight(80);
			im2.setFitWidth(80);
			fotos[1] = im2;
			//imagen3
			Image image3 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara3.jpg"));
			ImageView im3= new ImageView(image3);
			im3.setFitHeight(80);
			im3.setFitWidth(80);
			fotos[2] = im3;
			//imagen4
			Image image4 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara4.jpg"));
			ImageView im4= new ImageView(image4);
			im4.setFitHeight(80);
			im4.setFitWidth(80);
			fotos[3] = im4;
			//
			Image image5 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\CARRO.jpg"));
			ImageView im5= new ImageView(image5);
			im5.setFitHeight(80);
			im5.setFitWidth(80);
			fotos[4] = im5;
			//
			Image image6 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\CARTA.jpg"));
			ImageView im6= new ImageView(image6);
			im6.setFitHeight(80);
			im6.setFitWidth(80);
			fotos[5] = im6;
			//
			Image image7 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\COPAS11.jpg"));
			ImageView im7= new ImageView(image7);
			im7.setFitHeight(80);
			im7.setFitWidth(80);
			fotos[6] = im7;
			//
			Image image8 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\DOLARES.jpg"));
			ImageView im8= new ImageView(image8);
			im8.setFitHeight(80);
			im8.setFitWidth(80);
			fotos[7] = im8;
		} catch (FileNotFoundException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setHeaderText("Error");
			info.setTitle("No se pudo encontrar la imagen");
			info.setContentText("");
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
				p6.add(fotos[0], 0,0);
				p6.getChildren().remove(fotos[5]);
				p6.add(fotos[1], 0,1);
				p6.getChildren().remove(fotos[6]);
				p6.add(fotos[2], 1,0);
				p6.getChildren().remove(fotos[7]);
				p6.add(fotos[3], 1,1);
			}
		});
		hojaVida[2].setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event){
				p5.getChildren().remove(hojaVida[2]);
				p5.getChildren().add(hojaVida[0]);
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
		Scene scene1=new Scene(main1,310,230);
		primarystage.setScene(scene1);
		primarystage.show();


		//segunda pagina
		Button btnExito=new Button();
		Button btnD1=new Button();
		Button btnJybueno=new Button();
		Button btnJumbo=new Button();
		try {
			//imagen1
			Image image1 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara1.jpg"));
			ImageView im1=new ImageView(image1);
			im1.setFitHeight(80);
			im1.setFitWidth(80);
			Button btn1 = new Button("EXITO", im1);
			btn1.setStyle("-fx-base: yellow;");
			btn1.setContentDisplay(ContentDisplay.TOP);
			btn1.setMaxSize(100, 50);
			btnExito=btn1;

			Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara2.jpg"));
			ImageView im2=new ImageView(image2);
			im2.setFitHeight(80);
			im2.setFitWidth(80);
			Button btn2 = new Button("D1", im2);
			btn2.setStyle("-fx-base: coral;");
			btn2.setContentDisplay(ContentDisplay.TOP);
			btn2.setMaxSize(120, 50);
			btnD1=btn2;

			Image image3 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara3.jpg"));
			ImageView im3=new ImageView(image3);
			im3.setFitHeight(80);
			im3.setFitWidth(80);
			Button btn3 = new Button("J&B", im3);
			btn3.setStyle("-fx-base: mediumaquamarine;");
			btn3.setContentDisplay(ContentDisplay.TOP);
			btn3.setMaxSize(120, 50);
			btnJybueno=btn3;

			Image image4 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\IMAGENES\\cara4.jpg"));
			ImageView im4=new ImageView(image4);
			im4.setFitHeight(80);
			im4.setFitWidth(80);
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
		VBox m2p1=new VBox(label2);
		m2p1.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null , null)));
		m2p1.setAlignment(Pos.CENTER);
		GridPane btnsuper=new GridPane();
		btnsuper.add(btnExito, 0, 0);
		btnsuper.add(btnD1, 1, 0);
		btnsuper.add(btnJybueno, 0, 1);
		btnsuper.add(btnJumbo, 1, 1);
		Button m2aceptar=new Button("Aceptar");
		HBox m2p2=new HBox(10,btnback,m2aceptar);
		BorderPane main2=new BorderPane();
		m2p2.setAlignment(Pos.CENTER);
		main2.setTop(m2p1);
		main2.setCenter(btnsuper);
		main2.setBottom(m2p2);
		Scene scene2=new Scene(main2,193,285);
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
				primarystage.setTitle("prueba1");
				primarystage.setScene(scene1);
				primarystage.show();


			}
		});
	}
	

public static void main(String[] args) {
   launch(args);
}

}
