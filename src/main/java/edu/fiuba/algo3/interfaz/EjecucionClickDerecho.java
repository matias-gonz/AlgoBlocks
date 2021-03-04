package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonABRepeticion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class EjecucionClickDerecho {

    public void resolucionClickDerecho(HBox contenedor, VBox contenedorMadre, SectorAlgoritmo sector, MouseEvent mouseEvent, SectorBloquesDisponibles sectorBloquesDisponibles, BotonAB creador)
    {
        crearMenu(sector, mouseEvent, actionEvent -> {
            contenedor.getChildren().clear();
            contenedorMadre.getChildren().remove(contenedor);

            // hay cambios, hay que decirle al sector bloques disponibles
            sectorBloquesDisponibles.notificarObservador(contenedorMadre);

            creador.notificarObservador( -50, -45, -1 ); // lo achicamos!!

            this.reproducirSonido();
        });
    }
    /*public void resolucionClickDerecho(HBox contenedor, VBox contenedorMadre, SectorAlgoritmo sector, MouseEvent mouseEvent, SectorBloquesDisponibles sectorBloquesDisponibles, CreadorDeTipoDeBloque creador) {
        crearMenu(sector, mouseEvent, actionEvent -> {
            contenedor.getChildren().clear();
            contenedorMadre.getChildren().remove(contenedor);

            // hay cambios, hay que decirle al sector bloques disponibles
            sectorBloquesDisponibles.notificarObservador(contenedorMadre);

            creador.notificarObservador( -50, -45, -1 ); // lo achicamos!!

            this.reproducirSonido();
        });
    }*/

    public void resolucionClickDerecho(VBox contenedor, SectorAlgoritmo sector, MouseEvent mouseEvent, BotonAB boton, SectorBloquesDisponibles sectorBloquesDisponibles) {
        crearMenu(sector, mouseEvent, actionEvent -> {
            contenedor.getChildren().remove(boton);

            // hay cambios, hay que decirle al sector bloques disponibles
            sectorBloquesDisponibles.notificarObservador(contenedor);

            this.reproducirSonido();
        });

    }

    public void resolucionClickDerecho(VBox contenedor, SectorAlgoritmo sector, MouseEvent mouseEvent, BotonAB boton, SectorBloquesDisponibles sectorBloquesDisponibles, BotonAB creador) {
        crearMenu(sector, mouseEvent, actionEvent -> {
            contenedor.getChildren().remove(boton);
            creador.notificarObservador(0, -45, -1); // lo achicamos .

            // hay cambios, hay que decirle al sector bloques disponibles
            sectorBloquesDisponibles.notificarObservador(contenedor);

            this.reproducirSonido();
        });
    }

    private void reproducirSonido() {
        String musicFile = "src/main/java/edu/fiuba/algo3/interfaz/musica/borrar_bloque.mp3";     // For example
        Media musica = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();
    }

    private void crearMenu(SectorAlgoritmo sector, MouseEvent mouseEvent, EventHandler<ActionEvent> handler) {
        ContextMenu menu = new ContextMenu();
        MenuItem borrar = new MenuItem("BORRAR");
        MenuItem cancelar = new MenuItem("CANCELAR");

        menu.getItems().addAll(borrar, cancelar);
        menu.show(sector, mouseEvent.getScreenX(), mouseEvent.getScreenY());
        cancelar.setOnAction(evento -> menu.hide());
        borrar.setOnAction( handler );
    }
}
