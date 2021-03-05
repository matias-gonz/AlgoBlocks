package edu.fiuba.algo3.interfaz.controladores.botones;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.bloques.BloqueBajarLapiz;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class ControladorBajarLapiz extends ControladorBoton {

    @Override
    public Bloque obtenerAccion(ObservableList<Node> hijos) {
        return new BloqueBajarLapiz();
    }

}