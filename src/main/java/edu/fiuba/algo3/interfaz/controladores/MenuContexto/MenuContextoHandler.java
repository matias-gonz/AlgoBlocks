package edu.fiuba.algo3.interfaz.controladores.MenuContexto;

import edu.fiuba.algo3.interfaz.vista.contenedores.ContenedorBloque;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MenuContextoHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {
    private final VBox contenedorMadre;
    SectorBloquesDisponibles sectorBloquesDisponibles;
    SectorAlgoritmo sector;
    ContenedorBloque contenedor;

    public MenuContextoHandler(SectorAlgoritmo sector, ContenedorBloque contenedorBloque, SectorBloquesDisponibles sectorBloquesDisponibles, VBox contenedorMadre) {
        this.sector = sector;
        this.contenedor = contenedorBloque;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
        this.contenedorMadre = contenedorMadre;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            resolucionClickDerecho(this.contenedor, this.sector, mouseEvent, this.sectorBloquesDisponibles, this.contenedorMadre);
        }
    }
}
