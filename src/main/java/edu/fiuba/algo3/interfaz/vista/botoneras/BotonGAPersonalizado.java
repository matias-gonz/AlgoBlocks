package edu.fiuba.algo3.interfaz.vista.botoneras;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BotonGAPersonalizado extends Button {

    private final List<Node> contenedorBloques = new ArrayList<>();

    public BotonGAPersonalizado(TextField texto,  VBox contenedorAlgoritmo) {
        super(texto.getText());
        contenedorBloques.addAll(contenedorAlgoritmo.getChildren());

        System.out.println("CREACION : " + this.contenedorBloques.size());
        contenedorAlgoritmo.getChildren().clear();
        System.out.println("POST CLEAR : " + this.contenedorBloques.size());

        this.setOnMouseClicked(e -> contenedorAlgoritmo.getChildren().addAll(contenedorBloques));
    }
}
