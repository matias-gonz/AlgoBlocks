package edu.fiuba.algo3.modelo.tablero.movimiento;

import edu.fiuba.algo3.modelo.tablero.Posicion;

import java.io.Serializable;

public class MovimientoAbajo implements Movimiento, Serializable {

    @Override
    public void mover(Posicion posicion) {
        posicion.desplazarAbajo();
    }

    @Override
    public Movimiento opuesto() {
        return new MovimientoArriba();
    }
}
