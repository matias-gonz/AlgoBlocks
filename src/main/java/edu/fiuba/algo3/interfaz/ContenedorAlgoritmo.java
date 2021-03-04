package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.controladores.HabilidadAceptarDragHandler;
import edu.fiuba.algo3.interfaz.controladores.HabilidadDropHandler;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import javafx.geometry.Pos;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class ContenedorAlgoritmo extends VBox {

    public ContenedorAlgoritmo(int sizeX, int sizeY, Pos posicion, SectorAlgoritmo sectorAlgoritmo, SectorBloquesDisponibles sectorBloquesDisponibles) {
        super();
        this.setPrefSize( sizeX, sizeY );
        this.setAlignment( posicion );

        this.setOnDragOver( new HabilidadAceptarDragHandler(TransferMode.ANY) );

        this.setOnDragDropped( new HabilidadDropHandler(sectorAlgoritmo, this, sectorBloquesDisponibles) );
    }

}
