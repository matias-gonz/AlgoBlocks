package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.ContenedorRepeticion;
import edu.fiuba.algo3.ControladorMoverArriba;
import edu.fiuba.algo3.interfaz.controladores.MenuContextoEnContenedorHandler;
import edu.fiuba.algo3.interfaz.controladores.MenuContextoHandler;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.modelo.bloques.Bloque;
import javafx.scene.layout.VBox;

public class BotonABMoverArriba extends BotonAB {

    ControladorMoverArriba controladorMoverArriba;

    // constructor para el sector bloques disponibles.
    public BotonABMoverArriba() {
        super("Mover Arriba", "arriba.png");
        controladorMoverArriba = new ControladorMoverArriba();
    }

    @Override
    public void crearBloqueEnSectorAlgoritmo(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles) {
        BotonABMoverArriba boton = new BotonABMoverArriba();
        boton.setOnDragDetected(null); // no se mueve

        boton.setOnMouseClicked( new MenuContextoHandler(boton, sector, contenedor, sectorBloquesDisponibles) );

        contenedor.getChildren().add(boton);
        sectorBloquesDisponibles.notificarObservador(contenedor);
    }

    @Override
    public void crearBloqueAdentroDeUnContenedor(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles, BotonAB creador) {
        BotonABMoverArriba boton = new BotonABMoverArriba();
        boton.setOnDragDetected(null); // no se mueve
        boton.setOnMouseClicked( new MenuContextoEnContenedorHandler(boton, sector, contenedor, sectorBloquesDisponibles, creador) );

        contenedor.getChildren().add(boton);
        creador.notificarObservador(0, 45, 0); // no es un contenedor.
    }

    @Override
    public Bloque obtenerBloque() {
        return controladorMoverArriba.obtenerAccion();
    }

    // dummy
    @Override
    public void agregarObservador(ContenedorRepeticion obs) {

    }

    @Override
    public void notificarObservador(double x, double y, int hijos) {

    }
}
