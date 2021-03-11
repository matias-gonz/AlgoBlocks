package edu.fiuba.algo3.modelo.movimiento;

import edu.fiuba.algo3.modelo.tablero.Posicion;

public class MovimientoIzquierda implements Movimiento {

    @Override
    public void mover(Posicion posicion) {
        posicion.desplazarIzquierda();
    }

    @Override
    public Movimiento opuesto() {
        return new MovimientoDerecha();
    }
}
