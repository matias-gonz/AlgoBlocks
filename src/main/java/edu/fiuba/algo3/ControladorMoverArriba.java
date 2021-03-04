package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.bloques.BloqueMovimiento;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;

public class ControladorMoverArriba implements AccionBotones {

    @Override
    public Bloque obtenerAccion() {
        return new BloqueMovimiento( new MovimientoArriba() );
    }
}
