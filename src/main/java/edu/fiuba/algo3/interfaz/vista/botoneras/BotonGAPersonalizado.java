package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotonGAPersonalizado extends Button {

    private final List<Node> contenedorBloques = new ArrayList<>();
    SectorBloquesDisponibles botonera;

    public BotonGAPersonalizado(TextField texto,  VBox contenedorAlgoritmo, SectorBloquesDisponibles sector) {
        super(texto.getText());
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
