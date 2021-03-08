package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class BotonGAPersonalizado extends Button {

    private final List<Node> contenedorBloques = new ArrayList<>();
    SectorBloquesDisponibles botonera;

    public BotonGAPersonalizado(TextField texto,  VBox contenedorAlgoritmo, SectorBloquesDisponibles sector) {
        super(texto.getText());
        this.setStyle("-fx-base: rgba(25,208,214)");
        ImageView image = new ImageView("file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/guardar.png");
        image.setFitHeight(20);
        image.setFitWidth(20);
        this.setGraphic(image);
        this.setPadding(new Insets(5));
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        contenedorBloques.addAll(contenedorAlgoritmo.getChildren());
        this.botonera = sector;

        System.out.println("CREACION : " + this.contenedorBloques.size());
        contenedorAlgoritmo.getChildren().clear();
        System.out.println("POST CLEAR : " + this.contenedorBloques.size());

        this.setOnMouseClicked(e -> {
            contenedorAlgoritmo.getChildren().clear();
            contenedorAlgoritmo.getChildren().addAll(contenedorBloques);
            this.botonera.notificarObservador(contenedorAlgoritmo);
        });
    }
}
