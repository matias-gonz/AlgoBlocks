package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.ContenedorRepeticion;
import edu.fiuba.algo3.ControladorRepeticicion;
import edu.fiuba.algo3.interfaz.ObservableContenedor;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.modelo.bloques.Bloque;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class BotonABRepeticion extends BotonAB implements ObservableContenedor {

    private ContenedorRepeticion bloqueEnSectorAlgoritmo;
    ControladorRepeticicion controladorRepeticicion;
    ContenedorRepeticion contenedorAEjecutar;

    public BotonABRepeticion() {
        super("Repetir algoritmo", "repeticion.png");
    }

    @Override
    public void crearBloqueEnSectorAlgoritmo(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles) {
        contenedorAEjecutar= new ContenedorRepeticion(this, contenedor, sectorBloquesDisponibles, sector);
        this.agregarObservador(contenedorAEjecutar);
        this.notificarObservador( 50, 45, 0);

        sectorBloquesDisponibles.notificarObservador(contenedor);
    }

    @Override
    public void crearBloqueAdentroDeUnContenedor(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles, BotonAB creador) {
        ContenedorRepeticion contenedorAdentroContenedor = new ContenedorRepeticion(creador, contenedor, sectorBloquesDisponibles, sector);


        creador.notificarObservador( 70, 55, 0); // llamamos al padre para que crezca también

        this.agregarObservador(contenedorAdentroContenedor);
        this.notificarObservador(50, 45 , 0); // agrega un contenedor a uno ya existente.

    }

    @Override
    public Bloque obtenerBloque() {
        System.out.println(" contenedorAEjecutar.obtenerHijos() = " +  contenedorAEjecutar.obtenerHijos().size() + " -> " +  contenedorAEjecutar.obtenerHijos());
        /*controladorRepeticicion = new ControladorRepeticicion( contenedorAEjecutar.obtenerHijos() );
        return controladorRepeticicion.obtenerAccion();*/
        return controladorRepeticicion.obtenerAccion();
    }


    @Override
    public void agregarObservador(ContenedorRepeticion obs) {
        this.bloqueEnSectorAlgoritmo = obs;
    }

    @Override
    public void notificarObservador(double x, double y, int hijos) {
        this.bloqueEnSectorAlgoritmo.cambios(x, y, hijos);
    }
}
