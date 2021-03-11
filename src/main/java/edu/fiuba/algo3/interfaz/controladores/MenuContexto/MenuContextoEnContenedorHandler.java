package edu.fiuba.algo3.interfaz.controladores.MenuContexto;

import edu.fiuba.algo3.interfaz.vista.contenedores.ContenedorBloque;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MenuContextoEnContenedorHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {
    private final BotonAB boton;
    private final SectorAlgoritmo sector;
    private final ContenedorBloque contenedorBloque;
    private final VBox contenedorMadre;
    private final SectorBloquesDisponibles sectorBloquesDisponibles;

    public MenuContextoEnContenedorHandler(BotonAB boton, SectorAlgoritmo sector, ContenedorBloque contenedorBloque, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles) {
        this.boton = boton;
        this.sector = sector;
        this.contenedorBloque = contenedorBloque;
        this.contenedorMadre = contenedor;
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            resolucionClickDerecho(this.boton, this.sector, this.contenedorBloque, this.contenedorMadre, this.sectorBloquesDisponibles, mouseEvent);
        }
    }

}
