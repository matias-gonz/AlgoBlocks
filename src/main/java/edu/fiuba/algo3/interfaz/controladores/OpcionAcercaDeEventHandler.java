package edu.fiuba.algo3.interfaz.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("AlgoBlocks");
        String mensaje = "TP2 Desarrollado por:  \n" +
                " ☻ Luz M. Diaz\n" +
                " ☻ Lucas Gabriel Torres \n"+
                " ☻ Matias Ignacio Gonzalez";
        alert.setContentText(mensaje);
        alert.show();
    }
}