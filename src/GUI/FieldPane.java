package GUI;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class FieldPane extends Pane {
	GridPane child=new GridPane();
	ArrayList<Label> titulos=new ArrayList<Label>();
	ArrayList<TextField> vals=new ArrayList<TextField>();
	public FieldPane(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
		Label tituloCriterio=new Label(tituloCriterios);
		tituloCriterio.setFont(new Font("TimesNewRoman",15));
		tituloCriterio.setTextFill(Color.GREY);
		titulos.add(tituloCriterio);
		Label tituloValor=new Label(tituloValores);
		tituloValor.setFont(new Font("TimesNewRoman",15));
		tituloValor.setTextFill(Color.GREY);
		titulos.add(tituloValor);
		child.add(titulos.get(0), 0, 0);
		child.add(titulos.get(1), 1, 0);
		child.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null , null)));	
		if (habilitado==null) {
			habilitado=new boolean[criterios.length];
			for(int i=0;i<criterios.length;i++) {
				habilitado[i]=true;
			}
		}
		if (valores==null) {
			for(int i=0;i<criterios.length;i++){
				titulos.add(new Label(criterios[i]));
				child.add(titulos.get(2+i), 0, i+1);
				vals.add(new TextField());
				vals.get(i).setEditable(habilitado[i]);
				child.add(vals.get(i), 1, i+1);
			}
		}else {
			for(int i=0;i<criterios.length;i++){
				if(valores[i]==null) {
					titulos.add(new Label(criterios[i]));
					child.add(titulos.get(2+i), 0, i+1);
					vals.add(new TextField());
					vals.get(i).setEditable(habilitado[i]);
					child.add(vals.get(i), 1, i+1);
				}else {
					titulos.add(new Label(criterios[i]));
					child.add(titulos.get(2+i), 0, i+1);
					vals.add(new TextField(valores[i]));
					vals.get(i).setEditable(habilitado[i]);
					child.add(vals.get(i), 1, i+1);
				}
			}
		}
		child.setAlignment(Pos.CENTER);
		child.setHgap(10);
		child.setVgap(8);
		child.setPadding(new Insets(8,8,8,8));
	}
	public TextField getBox(int i) {
		return vals.get(i);
	}
	public String getValue(int index) {
		return vals.get(index).getText();
	}
	public void setHabilitado(boolean[] habilitado) {
		for(int i=0;i<vals.size();i++) {
			vals.get(i).setEditable(habilitado[i]);
		}
	}
	public void ClearFields() {
		for(int i=0;i<vals.size();i++) {
			vals.get(i).setText("");;
		}
	}
	public GridPane getChild() {
		return child;
	}
}