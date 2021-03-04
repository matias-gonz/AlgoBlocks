package edu.fiuba.algo3.interfaz;

import javafx.scene.layout.VBox;

public interface ObservableSectorAlgoritmo {
    void agregarObservador(ObservadorSectorAlgoritmo observador);
    void notificarObservador(VBox nuevoContenedor);
}