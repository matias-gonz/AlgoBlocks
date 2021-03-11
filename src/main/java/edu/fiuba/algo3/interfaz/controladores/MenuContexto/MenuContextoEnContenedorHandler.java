package edu.fiuba.algo3.interfaz.controladores.MenuContexto;

import edu.fiuba.algo3.interfaz.vista.contenedores.ContenedorBloque;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MenuContextoEnContenedorHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {
    private final SectorAlgoritmo sector;
    private final ContenedorBloque contenedorBloque;
    private final VBox contenedorMadre;

    public MenuContextoEnContenedorHandler(SectorAlgoritmo sector, ContenedorBloque contenedorBloque, VBox contenedor) {
        this.sector = sector;
        this.contenedorBloque = contenedorBloque;
        this.contenedorMadre = contenedor;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            resolucionClickDerecho(this.sector, this.contenedorBloque, this.contenedorMadre, mouseEvent);
        }
    }

}
