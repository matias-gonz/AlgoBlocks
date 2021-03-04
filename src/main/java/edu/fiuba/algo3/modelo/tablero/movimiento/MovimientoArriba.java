package edu.fiuba.algo3.modelo.tablero.movimiento;

import edu.fiuba.algo3.modelo.tablero.Posicion;

import java.io.Serializable;

public class MovimientoArriba implements Movimiento, Serializable {

    public void mover(Posicion posicion){
        posicion.desplazarArriba();
    }

    @Override
    public Movimiento opuesto() {
        return new MovimientoAbajo();
    }
}
