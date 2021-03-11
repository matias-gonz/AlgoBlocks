package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.contenedores.ContenedorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonClear;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonEjecutar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class ClearHandler implements EventHandler<ActionEvent> {

    VBox contenedor;
    BotonClear botonClear;
    BotonEjecutar botonEjecutar;

    public ClearHandler(VBox contenedorAlgoritmo, BotonClear botonClear, BotonEjecutar botonEjecutar) {
        this.contenedor = contenedorAlgoritmo;
        this.botonClear = botonClear;
        this.botonEjecutar = botonEjecutar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ((ContenedorAlgoritmo) this.contenedor).limpiarContenedor();

        String musicFile = "src/main/java/edu/fiuba/algo3/interfaz/musica/borrar_bloque.mp3";
        Media musica = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();

        this.botonClear.setDisable(true);
        this.botonEjecutar.setDisable(true);
    }
}
