package edu.fiuba.algo3.modelo.tablero.movimiento;

import edu.fiuba.algo3.modelo.tablero.Posicion;

public interface Movimiento {
    void mover(Posicion posicion);

    Movimiento opuesto();
}
