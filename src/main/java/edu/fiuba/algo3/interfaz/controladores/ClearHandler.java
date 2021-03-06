package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.ContenedorBloque;
import edu.fiuba.algo3.interfaz.vista.SectorDibujo;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ClearHandler implements EventHandler<MouseEvent> {

    VBox contenedor;

    public ClearHandler(VBox contenedorAlgoritmo) {
        this.contenedor = contenedorAlgoritmo;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        this.contenedor.getChildren().clear();
    }
}
