package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.controladores.KeyShortcutHandler;
import edu.fiuba.algo3.interfaz.vista.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * JavaFX App
 */

public class App extends Application {

    private static final String TITULO_VENTANA = "AlgoBlocks!";
    private static final String ICONO_VENTANA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personaje.png";
    private static final String RUTA_MUSICA = "src/main/java/edu/fiuba/algo3/interfaz/musica/main.mp3";
    private static final int RES_X = 1280; // default: 640
    private static final int RES_Y = 720;  // default: 480

    @Override
    public void start(Stage stage) {
        
        Media musica = new Media(new File(RUTA_MUSICA).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.4);
        mediaPlayer.play();

        Tablero tablero = new Tablero(mediaPlayer);

        var scene = new Scene(tablero, RES_X, RES_Y);
        scene.setOnKeyPressed(new KeyShortcutHandler(tablero));
        stage.setResizable(false);
        stage.setTitle( TITULO_VENTANA );
        stage.getIcons().add(new Image(ICONO_VENTANA));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}