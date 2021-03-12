package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.vista.contenedores.ContenedorAlgoritmo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class SectorAlgoritmo extends VBox {

    public SectorAlgoritmo(SectorBloquesDisponibles sectorBloquesDisponibles){
        Titulo titulo = new Titulo("Espacio de trabajo");
        this.getChildren().add(titulo);

        ContenedorAlgoritmo contenedorAlgoritmo = new ContenedorAlgoritmo(400, 900, Pos.TOP_CENTER, this, sectorBloquesDisponibles );
        contenedorAlgoritmo.setId("Sector");

        this.getChildren().add(contenedorAlgoritmo);

        this.setMinWidth(500);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
