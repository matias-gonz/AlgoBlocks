package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.ContenedorBloque;
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
import java.util.Random;

public class BotonGAPersonalizado extends Button {

    private final List<Node> contenedorBloques = new ArrayList<>();
    SectorBloquesDisponibles botonera;

    public BotonGAPersonalizado(TextField texto,  VBox contenedorAlgoritmo, SectorBloquesDisponibles sector) {
        super(texto.getText());

        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        this.setStyle("-fx-base: rgb(" + String.join(",", String.valueOf(r), String.valueOf(g), String.valueOf(b)) + ")");

        ImageView image = new ImageView("file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/guardar.png");
        image.setFitHeight(20);
        image.setFitWidth(20);
        this.setGraphic(image);
        this.setPadding(new Insets(5));
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        contenedorBloques.addAll(contenedorAlgoritmo.getChildren());

        // con esto evitamos que los bloques del algoritmo guardado no se puedan borrar.
        contenedorBloques.forEach( contenedor -> {
            ((ContenedorBloque) contenedor).getChildren().get(0).setOnMouseClicked(null);
        });

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
