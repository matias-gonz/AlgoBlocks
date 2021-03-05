package edu.fiuba.algo3.interfaz.controladores.botones;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.bloques.BloqueBajarLapiz;

public class ControladorBajarLapiz extends ControladorBoton {

    @Override
    public Bloque obtenerAccion() {
        return new BloqueBajarLapiz();
    }

}