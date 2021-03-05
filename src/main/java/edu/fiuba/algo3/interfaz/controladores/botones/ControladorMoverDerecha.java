package edu.fiuba.algo3.interfaz.controladores.botones;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.bloques.BloqueMovimiento;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;

public class ControladorMoverDerecha extends ControladorBoton {

    @Override
    public Bloque obtenerAccion() {
        return new BloqueMovimiento( new MovimientoDerecha() );
    }
}