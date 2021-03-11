package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.vista.contenedores.ContenedorAlgoritmo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class SectorAlgoritmo extends VBox {

    public SectorAlgoritmo(SectorBloquesDisponibles sectorBloquesDisponibles){
        Label text = new Label("Espacio de Trabajo");
        text.setMaxWidth(Double.MAX_VALUE);
        text.setAlignment(Pos.CENTER);
        text.setTextFill(Color.WHITE);
        text.setStyle("-fx-background-color: rgb(85,40,129);");
        text.setFont(Font.font("Times",20));
        this.getChildren().add(text);

        ContenedorAlgoritmo contenedorAlgoritmo = new ContenedorAlgoritmo(400, 900, Pos.TOP_CENTER, this, sectorBloquesDisponibles );

        this.getChildren().add(contenedorAlgoritmo);

        this.setMinWidth(500);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
