package edu.fiuba.algo3.interfaz.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class OpcionInstruccionesEventHanlder implements EventHandler<ActionEvent> {
    private ImageView imagen;

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Instrucciones ");
        imagen = new ImageView( "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personaje.png");
        alert.setGraphic(imagen);
        String mensaje = "Este es un nuevo tipo de desafío llamado Artista. Juega con el nivel y dibuja algo divertido.";
        alert.setContentText(mensaje);
        alert.show();
    }
}