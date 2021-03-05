package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.ContenedorBloque;
import edu.fiuba.algo3.interfaz.vista.SectorDibujo;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.bloques.*;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoIzquierda;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EjecucionAlgoritmoHandler implements EventHandler<MouseEvent> {

    VBox contenedor;
    Personaje personaje;
    SectorDibujo sectorDibujo;
    Dibujo dibujo;

    public EjecucionAlgoritmoHandler(VBox contenedorAlgoritmo, Personaje personaje, SectorDibujo sectorDibujo, Dibujo dibujo) {
        this.contenedor = contenedorAlgoritmo;
        this.personaje = personaje;
        this.sectorDibujo = sectorDibujo;
        this.dibujo = dibujo;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        sectorDibujo.reset();

        ArrayList<Bloque> bloquesEjecutar = new ArrayList<>();

        System.out.println(this.contenedor.getChildren().size());

        for( int i = 0; i < this.contenedor.getChildren().size(); i++ ) {
            System.out.println(this.contenedor.getChildren().get(i));
            ContenedorBloque contenedorBloque = (ContenedorBloque) this.contenedor.getChildren().get(i);
            bloquesEjecutar.add( contenedorBloque.obtenerBloque() );
        }

        Timeline timeline;

        AtomicInteger contador = new AtomicInteger();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            Bloque temp = bloquesEjecutar.get(contador.getAndIncrement());

            temp.ejecutar(personaje, dibujo);
            sectorDibujo.update();
        }));

        timeline.setCycleCount(bloquesEjecutar.size());
        timeline.play();
    }
}
