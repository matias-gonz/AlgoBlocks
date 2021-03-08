package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ContenedorBloque;
import edu.fiuba.algo3.interfaz.EjecucionClickDerecho;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MenuContextoParaContenedores extends EjecucionClickDerecho implements EventHandler<MouseEvent> {

    SectorAlgoritmo sector;
    VBox contenedorMadre;
    SectorBloquesDisponibles sectorBloquesDisponibles;
    ContenedorBloque contenedorBloqueRepeticion;

    public MenuContextoParaContenedores(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles,  ContenedorBloque contenedorBloqueRepeticion) {
        this.sector = sector;
        this.contenedorMadre = contenedor;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
        this.contenedorBloqueRepeticion = contenedorBloqueRepeticion;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            resolucionClickDerecho(this.contenedorMadre, this.sector, mouseEvent, this.sectorBloquesDisponibles, this.contenedorBloqueRepeticion);
        }
    }
}
