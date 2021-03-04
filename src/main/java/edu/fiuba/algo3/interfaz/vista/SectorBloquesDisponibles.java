package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.ObservableSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.controladores.MovimientoEventHandler;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonABGA;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonABMoverArriba;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonABRepeticion;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.bloques.BloqueMovimiento;
import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoIzquierda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;


// le saqué el scrollpane porque no funcionó en this, se puede reimplementar pero ni idea como hacerlo.
public class SectorBloquesDisponibles extends VBox implements ObservableSectorAlgoritmo {

    private final ArrayList<ObservadorSectorAlgoritmo> observadorSA;
    BotonABGA botonGuardarAlgoritmo;
    SectorDibujo sectorDibujo;

    public SectorBloquesDisponibles(SectorDibujo sectorDibujo, Personaje personaje){

        this.sectorDibujo = sectorDibujo;

        //Como se repite codigo en ambos titulos creo que se podría separar en una clase
        Label upper = new Label("Bloques Disponibles");
        upper.setMaxWidth(Double.MAX_VALUE);
        upper.setAlignment(Pos.CENTER);
        upper.setTextFill(Color.WHITE);
        upper.setStyle("-fx-background-color: rgb(85,40,129);");
        upper.setFont(Font.font("Times",20));
        this.getChildren().add(upper);

        this.observadorSA = new ArrayList<>();

        //los metodos setOnAction son temporales aca para probar los movimientos del personaje
        /*BotonAB botonMoverArriba = new BotonAB("Mover Arriba", "arriba.png");
        MovimientoEventHandler movArriba = new MovimientoEventHandler(new BloqueMovimiento(new MovimientoArriba()), sectorDibujo, personaje);
        botonMoverArriba.setOnAction(movArriba);

        BotonAB botonMoverAbajo = new BotonAB("Mover Abajo", "abajo.png");
        MovimientoEventHandler movAbajo = new MovimientoEventHandler(new BloqueMovimiento(new MovimientoAbajo()), sectorDibujo, personaje);
        botonMoverAbajo.setOnAction(movAbajo);

        BotonAB botonMoverIzquierda = new BotonAB("Mover Izquierda", "izquierda.png");
        MovimientoEventHandler movIzquierda = new MovimientoEventHandler(new BloqueMovimiento(new MovimientoIzquierda()), sectorDibujo, personaje);
        botonMoverIzquierda.setOnAction(movIzquierda);

        BotonAB botonMoverDerecha = new BotonAB("Mover Derecha", "derecha.png");
        MovimientoEventHandler botonMovimiento = new MovimientoEventHandler(new BloqueMovimiento(new MovimientoDerecha()), sectorDibujo, personaje);
        botonMoverDerecha.setOnAction(botonMovimiento);

        BotonAB botonBajarLapiz = new BotonAB("Bajar Lapiz", "abajo.png");
        BotonAB botonSubirLapiz = new BotonAB("Subir Lapiz", "arriba.png");

        BotonAB botonRepeticion = new BotonAB("Repetir algoritmo", "repeticion.png");
        BotonAB botonInvertir = new BotonAB("Invertir comportamiento", "personajeUp.png");

        this.getChildren().addAll(botonMoverArriba, botonMoverAbajo, botonMoverIzquierda, botonMoverDerecha,
                botonBajarLapiz, botonSubirLapiz, botonRepeticion, botonInvertir);*/

        BotonABMoverArriba botonMoverArriba = new BotonABMoverArriba();
        BotonABRepeticion botonRepeticion = new BotonABRepeticion();
        this.getChildren().addAll(botonMoverArriba, botonRepeticion);

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

        this.setMaxWidth(300);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void agregarObservador(ObservadorSectorAlgoritmo observador) {
        this.observadorSA.add(observador);
    }

    @Override
    public void notificarObservador(VBox nuevoContenedor) {
        this.observadorSA.forEach( obs -> obs.cambios(nuevoContenedor) );
        this.sectorDibujo.notificarObservador(nuevoContenedor);
        System.out.println("SECTORBLOQUESDISPONIBLES = " + nuevoContenedor.getChildren().size());
    }
}
