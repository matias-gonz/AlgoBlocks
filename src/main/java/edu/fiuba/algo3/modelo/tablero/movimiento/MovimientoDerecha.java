package edu.fiuba.algo3.modelo.tablero.movimiento;

import edu.fiuba.algo3.modelo.tablero.Posicion;

import java.io.Serializable;

public class MovimientoDerecha implements Movimiento, Serializable {

    public void mover(Posicion posicion){
        posicion.desplazarDerecha();
    }

    @Override
    public Movimiento opuesto() {
        return new MovimientoIzquierda();
    }
}
