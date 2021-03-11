package edu.fiuba.algo3.interfaz.controladores.menuOpciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;

public class OpcionActivarMusicaHandler implements EventHandler<ActionEvent> {
    private final MenuItem opcion;
    private final MediaPlayer reproductor;
    public OpcionActivarMusicaHandler(MediaPlayer mediaPlayer, MenuItem opcionToggle) {
        reproductor = mediaPlayer;
        opcion = opcionToggle;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        reproductor.setVolume(0.4);
        opcion.setOnAction(new OpcionDesactivarMusicaHandler(reproductor,opcion));
        opcion.setText("Apagar Musica");
    }
}
