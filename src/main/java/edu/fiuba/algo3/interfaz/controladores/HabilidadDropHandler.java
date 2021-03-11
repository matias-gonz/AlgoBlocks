package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonBloque;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class HabilidadDropHandler implements EventHandler<DragEvent> {

    SectorAlgoritmo sector;
    VBox contenedor;
    SectorBloquesDisponibles sectorBloquesDisponibles;
    BotonBloque creador = null;

    public HabilidadDropHandler(SectorAlgoritmo sectorAlgoritmo, VBox contenedorAlgoritmo, SectorBloquesDisponibles sectorBloquesDisponibles) {
        this.sector = sectorAlgoritmo;
        this.contenedor = contenedorAlgoritmo;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
    }

    public HabilidadDropHandler(SectorAlgoritmo sector, VBox contenedorAEjecutar, SectorBloquesDisponibles sectorBloquesDisponibles, BotonBloque creadorDeTipoDeBloque) {
        this.sector = sector;
        this.contenedor = contenedorAEjecutar;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
        this.creador = creadorDeTipoDeBloque;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {

            BotonBloque test = (BotonBloque) dragEvent.getGestureSource();

            if( this.creador != null ) // hace un drop en un contenedor
                test.crearBloqueAdentroDeUnContenedor(this.sector, this.contenedor, this.sectorBloquesDisponibles, this.creador);
            else {
                test.crearBloqueEnSectorAlgoritmo(this.sector, this.contenedor, this.sectorBloquesDisponibles);
            }

            success = true;

            String musicFile = "src/main/java/edu/fiuba/algo3/interfaz/musica/soltar_bloque.mp3";
            Media musica = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(musica);
            mediaPlayer.play();
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }

}
