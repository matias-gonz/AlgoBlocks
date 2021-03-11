package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.movimiento.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class Dibujo implements Observable {
    private List<Linea> lineas = new ArrayList<>();
    private final ArrayList<Observador> observador = new ArrayList<>();


    public void agregarLinea(Movimiento movimiento, Posicion posicion) {
        Linea linea = new Linea(posicion);
        movimiento.mover(posicion);
        linea.setPosFinal(posicion);
        lineas.add(linea);
        notificarObservador();
    }


    public List<Linea> obtenerSectorDibujado() {
        return lineas;
    }

    public void reset() {
        this.lineas = new ArrayList<>();
        notificarObservador();
    }

    @Override
    public void agregarObservador(Observador obs) {
        this.observador.add(obs);
    }

    @Override
    public void notificarObservador() {
        this.observador.forEach(Observador::update);
    }
}
