package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.json.JSONArray;

import java.io.File;

public class HabilidadDropHandler /*extends CreadorDeTipoDeBloque*/ implements EventHandler<DragEvent> {

    SectorAlgoritmo sector;
    VBox contenedor;
    SectorBloquesDisponibles sectorBloquesDisponibles;
    BotonAB creador = null;

    public HabilidadDropHandler(SectorAlgoritmo sectorAlgoritmo, VBox contenedorAlgoritmo, SectorBloquesDisponibles sectorBloquesDisponibles) {
        this.sector = sectorAlgoritmo;
        this.contenedor = contenedorAlgoritmo;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
    }

    public HabilidadDropHandler(SectorAlgoritmo sector, VBox contenedorAEjecutar, SectorBloquesDisponibles sectorBloquesDisponibles, BotonAB creadorDeTipoDeBloque) {
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

            BotonAB test = (BotonAB) dragEvent.getGestureSource();

            if( this.creador != null ) // hace un drop en un contenedor
                test.crearBloqueAdentroDeUnContenedor(this.sector, this.contenedor, this.sectorBloquesDisponibles, this.creador);
            else
                test.crearBloqueEnSectorAlgoritmo(this.sector, this.contenedor, this.sectorBloquesDisponibles);
            /*JSONArray salida = new JSONArray(db.getString());

            String nombre = (String) salida.get(0);
            String icono = (String) salida.get(1);

            if( nombre.contains("Repetir") || nombre.contains("Invertir") )
                if( this.creador != null ) // hace un drop en un contenedor
                    crearContenedor(nombre, icono, this.sector, this.contenedor, this.sectorBloquesDisponibles, this.creador);
                else
                    crearContenedor(nombre, icono, this.sector, this.contenedor, this.sectorBloquesDisponibles);
            else
                if( this.creador != null ) // hace un drop en un contenedor
                    crearBloque(nombre, icono, this.sector, this.contenedor, this.sectorBloquesDisponibles, this.creador);
                else
                    crearBloque(nombre, icono, this.sector, this.contenedor, this.sectorBloquesDisponibles);

            */
            success = true;

            String musicFile = "src/main/java/edu/fiuba/algo3/interfaz/musica/soltar_bloque.mp3";     // For example
            Media musica = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(musica);
            mediaPlayer.play();
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }

}
