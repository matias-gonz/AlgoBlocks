package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.controladores.EjecucionAlgoritmoHandler;
import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorDibujo;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonEjecutar extends Button implements ObservadorSectorAlgoritmo {

    VBox contenedorAlgoritmo;
    SectorDibujo sectorDibujo;
    Personaje personaje;
    Dibujo dibujo;

    public BotonEjecutar(Personaje personaje, SectorDibujo sectorDibujo, Dibujo dibujo) {
        super("Ejecutar algoritmo!");
        this.setLayoutX(290);
        this.setLayoutY(510);
        this.dibujo = dibujo;
        this.personaje = personaje;
        this.sectorDibujo = sectorDibujo;

        this.setStyle("-fx-font: 22 arial; -fx-base: #ff9900; -fx-text-fill: #ffffff; ");
        this.setDisable(true);
    }

    @Override
    public void cambios(VBox nuevoContenedor) {
        this.contenedorAlgoritmo = nuevoContenedor;
        System.out.println( "Cambios en botón ejecutar!!: " + this.contenedorAlgoritmo.getChildren().size() + this.contenedorAlgoritmo.getChildren());
        this.setDisable( this.contenedorAlgoritmo.getChildren().size() == 0 );
        this.setOnAction( new EjecucionAlgoritmoHandler( this.contenedorAlgoritmo  , personaje, sectorDibujo, dibujo));
    }

}
