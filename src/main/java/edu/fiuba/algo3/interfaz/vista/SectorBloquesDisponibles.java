package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.ObservableSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.controladores.botones.*;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonABGA;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonInversion;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonRepeticion;
import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;


public class SectorBloquesDisponibles extends VBox implements ObservableSectorAlgoritmo {

    private final ArrayList<ObservadorSectorAlgoritmo> observadorSA;
    BotonABGA botonGuardarAlgoritmo;
    SectorDibujo sectorDibujo;

    public SectorBloquesDisponibles(SectorDibujo sectorDibujo){

        this.sectorDibujo = sectorDibujo;
        Titulo titulo = new Titulo("Bloques Disponibles");
        this.getChildren().add(titulo);

        this.observadorSA = new ArrayList<>();

        BotonAB botonMoverArriba = new BotonAB("Mover Arriba","arriba.png",new ControladorMoverArriba());
        BotonAB botonMoverAbajo = new BotonAB("Mover Abajo","abajo.png",new ControladorMoverAbajo());
        BotonAB botonMoverDerecha = new BotonAB("Mover Derecha","derecha.png",new ControladorMoverDerecha());
        BotonAB botonMoverIzquierda = new BotonAB("Mover Izquierda","izquierda.png",new ControladorMoverIzquierda());
        BotonAB botonLevantarLapiz = new BotonAB("Levantar Lapiz","noLapiz.png",new ControladorLevantarLapiz());
        BotonAB botonBajarLapiz = new BotonAB("Apoyar Lapiz","lapiz.png",new ControladorBajarLapiz());
        BotonRepeticion botonRepeticion = new BotonRepeticion("Repetir","repeticion.png",new ControladorRepetir());
        BotonInversion botonInversion = new BotonInversion("Invertir","personajeUp.png",new ControladorInvertir());

        this.getChildren().addAll(botonMoverArriba,botonMoverAbajo,botonMoverDerecha,botonMoverIzquierda,botonBajarLapiz,botonLevantarLapiz,botonRepeticion,botonInversion);

        botonGuardarAlgoritmo = new BotonABGA("Guardar algoritmo", this );

        this.agregarObservador(botonGuardarAlgoritmo);

        Separator separador = new Separator();

        this.getChildren().addAll(botonGuardarAlgoritmo, separador);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        DBAlgoritmoPersonalizados db = new DBAlgoritmoPersonalizados();
        List<List<?>> info_algoritmos_personalizados = db.cargar_todos_algoritmos();

        info_algoritmos_personalizados.forEach( info -> this.getChildren().add( new Button( (String) info.get(0))));

        this.setAlignment( Pos.TOP_CENTER );
        this.setSpacing( 2 );

        this.setMinWidth(240);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void agregarObservador(ObservadorSectorAlgoritmo observador) {
        this.observadorSA.add(observador);
    }

    @Override
    public void notificarObservador(VBox nuevoContenedor) {
        this.observadorSA.forEach( obs -> obs.cambios(nuevoContenedor) );
        // notificamos al sector dibujo.
        this.sectorDibujo.notificarObservador(nuevoContenedor);
    }

    public void guardarAlgoritmo() {
        ((BotonABGA)this.getChildren().get(9)).fire();
    }
}
