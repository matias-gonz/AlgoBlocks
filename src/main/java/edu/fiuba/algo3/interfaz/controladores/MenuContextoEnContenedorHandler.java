package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.EjecucionClickDerecho;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonABRepeticion;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonBloque;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuContextoEnContenedorHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {

    SectorBloquesDisponibles sectorBloquesDisponibles;
    SectorAlgoritmo sector;
    VBox contenedorMadre;
    HBox contenedor;
    BotonBloque creador;

    //
    BotonBloque boton = null;

    public MenuContextoEnContenedorHandler(VBox contenedor, SectorAlgoritmo sector, HBox item, SectorBloquesDisponibles sectorBloquesDisponibles, BotonAB botonABRepeticion) {
        this.contenedorMadre = contenedor;
        this.sector = sector;
        this.contenedor = item;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
        this.creador = botonABRepeticion;
    }

    public MenuContextoEnContenedorHandler(BotonBloque item, SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles, BotonBloque creador) {
        this.contenedorMadre = contenedor;
        this.sector = sector;
        this.boton = item;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
        this.creador = creador;
    }
/*
    public MenuContextoEnContenedorHandler(VBox contenedorMadre, SectorAlgoritmo sector, HBox item, SectorBloquesDisponibles sectorBloquesDisponibles, CreadorDeTipoDeBloque creador) {
        this.contenedorMadre = contenedorMadre;
        this.sector = sector;
        this.contenedor = item;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
        this.creador = creador;
    }

    public MenuContextoEnContenedorHandler(BotonAB item, SectorAlgoritmo sector, VBox contenedorAlgoritmo, SectorBloquesDisponibles sectorBloquesDisponibles, BotonAB creador) {
        this.sector = sector;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
        this.contenedorMadre = contenedorAlgoritmo;
        this.boton = item;
        this.creador = creador;
    }*/

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            if( this.boton != null )
                resolucionClickDerecho(this.contenedorMadre, this.sector, mouseEvent, this.boton, this.sectorBloquesDisponibles, this.creador);
            else
                resolucionClickDerecho(this.contenedor, this.contenedorMadre, this.sector, mouseEvent, this.sectorBloquesDisponibles, this.creador);
        }
    }

}
