package edu.fiuba.algo3.modelo.lapiz;

import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.tablero.Posicion;

public class LapizLevantado implements Lapiz {

    @Override
    public void dibujar(Movimiento movimiento, Posicion posicion, Dibujo dibujo){

        movimiento.mover(posicion);
    }
}
