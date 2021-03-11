package edu.fiuba.algo3.modelo.movimiento;

import edu.fiuba.algo3.modelo.tablero.Posicion;

public class MovimientoArriba implements Movimiento {

    public void mover(Posicion posicion){
        posicion.desplazarArriba();
    }

    @Override
    public Movimiento opuesto() {
        return new MovimientoAbajo();
    }
}
