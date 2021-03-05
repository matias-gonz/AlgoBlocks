package edu.fiuba.algo3.interfaz.controladores.botones;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.bloques.BloqueLevantarLapiz;

public class ControladorLevantarLapiz extends ControladorBoton {

    @Override
    public Bloque obtenerAccion() {
        return new BloqueLevantarLapiz();
    }

}