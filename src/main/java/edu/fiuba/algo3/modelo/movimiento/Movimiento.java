package edu.fiuba.algo3.modelo.movimiento;

import edu.fiuba.algo3.modelo.tablero.Posicion;

public interface Movimiento {
    void mover(Posicion posicion);

    Movimiento opuesto();
}
