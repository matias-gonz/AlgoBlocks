package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.controladores.ClearHandler;
import edu.fiuba.algo3.interfaz.controladores.EjecucionAlgoritmoHandler;
import edu.fiuba.algo3.interfaz.vista.SectorDibujo;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonClear extends Button implements ObservadorSectorAlgoritmo {

    VBox contenedorAlgoritmo;


    public BotonClear() {
        super("Limpiar Bloques");
        this.setLayoutX(290);
        this.setLayoutY(560);
        this.setStyle("-fx-font: 22 arial; -fx-base: #ff9900; -fx-text-fill: #ffffff; ");
        this.setDisable(true);
    }

    @Override
    public void cambios(VBox nuevoContenedor) {
        this.contenedorAlgoritmo = nuevoContenedor;
        this.setDisable( this.contenedorAlgoritmo.getChildren().size() == 0 );
        this.setOnMouseClicked( new ClearHandler( this.contenedorAlgoritmo));
    }

}