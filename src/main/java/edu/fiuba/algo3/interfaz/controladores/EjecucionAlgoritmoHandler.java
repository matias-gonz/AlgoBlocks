package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.SliderVelocidad;
import edu.fiuba.algo3.interfaz.vista.contenedores.ContenedorBloque;
import edu.fiuba.algo3.interfaz.vista.SectorDibujo;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.bloques.*;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class EjecucionAlgoritmoHandler implements EventHandler<ActionEvent> {

    VBox contenedor;
    Personaje personaje;
    SectorDibujo sectorDibujo;
    Dibujo dibujo;
    SliderVelocidad sliderVelocidad;

    public EjecucionAlgoritmoHandler(VBox contenedorAlgoritmo, Personaje personaje, SectorDibujo sectorDibujo, Dibujo dibujo, SliderVelocidad velocidad) {
        this.contenedor = contenedorAlgoritmo;
        this.personaje = personaje;
        this.sectorDibujo = sectorDibujo;
        this.dibujo = dibujo;
        this.sliderVelocidad = velocidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        sectorDibujo.reset();

        ArrayList<Bloque> bloquesEjecutar = new ArrayList<>();

        for( int i = 0; i < this.contenedor.getChildren().size(); i++ ) {
            ContenedorBloque contenedorBloque = (ContenedorBloque) this.contenedor.getChildren().get(i);
            bloquesEjecutar.add( contenedorBloque.obtenerBloque() );
        }

        Timeline timeline;

        AtomicInteger contador = new AtomicInteger();
        timeline = new Timeline(new KeyFrame(Duration.seconds(sliderVelocidad.obtenerVelocidad()), (ActionEvent event) -> {
            Bloque temp = bloquesEjecutar.get(contador.getAndIncrement());

            temp.ejecutar(personaje, dibujo);
        }));

        timeline.setCycleCount(bloquesEjecutar.size());
        timeline.play();
    }
}
