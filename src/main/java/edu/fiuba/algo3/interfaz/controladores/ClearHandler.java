package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.ContenedorAlgoritmo;
import edu.fiuba.algo3.interfaz.ContenedorBloque;
import edu.fiuba.algo3.interfaz.vista.SectorDibujo;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonClear;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonEjecutar;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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
