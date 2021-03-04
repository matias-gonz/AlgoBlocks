package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.EjecucionClickDerecho;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MenuContextoHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {
    SectorBloquesDisponibles sectorBloquesDisponibles;
    SectorAlgoritmo sector;
    VBox contenedor;
    BotonAB boton;

    public MenuContextoHandler(BotonAB item, SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles) {
        this.sector = sector;
        this.contenedor = contenedor;
        this.boton = item;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            resolucionClickDerecho(this.contenedor, this.sector, mouseEvent, this.boton, this.sectorBloquesDisponibles);
        }
    }
}
