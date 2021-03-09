package edu.fiuba.algo3.interfaz.vista;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ScrollSector extends ScrollPane {

    public ScrollSector(VBox contenedor){
        this.setContent(contenedor);
        this.setFitToWidth(true);
        this.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }
}
