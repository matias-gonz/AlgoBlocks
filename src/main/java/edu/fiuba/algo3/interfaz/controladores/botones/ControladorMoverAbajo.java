package edu.fiuba.algo3.interfaz.controladores.botones;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.bloques.BloqueMovimiento;
import edu.fiuba.algo3.modelo.movimiento.MovimientoAbajo;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class ControladorMoverAbajo extends ControladorBoton {

    @Override
    public Bloque obtenerAccion(ObservableList<Node> hijos) {
        return new BloqueMovimiento( new MovimientoAbajo() );
    }
}