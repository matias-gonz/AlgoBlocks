package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.controladores.BotonABGAClickHandler;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonABGA extends Button implements ObservadorSectorAlgoritmo {

    VBox contenendorAlgoritmo = null;
    SectorBloquesDisponibles sectorBloquesDisponibles;

    public BotonABGA(String nombre, SectorBloquesDisponibles sectorBloquesDisponibles) {
        super(nombre);
        this.setDisable(true);
        this.sectorBloquesDisponibles = sectorBloquesDisponibles;
    }

    @Override
    public void cambios(VBox nuevoContenedor) {
        // esta acción va a ser llamada cuando tenga un bloque, por lo tanto no hay chances de la variable
        // sea null

        this.contenendorAlgoritmo = nuevoContenedor;

        this.setDisable( this.contenendorAlgoritmo.getChildren().size() == 0 ); // no tiene hijos...

        // re-escribimos el handler con el nuevo info del contenedor :)
        this.setOnMouseClicked( new BotonABGAClickHandler(this.contenendorAlgoritmo, this.sectorBloquesDisponibles) );
    }
}
