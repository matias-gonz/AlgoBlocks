package edu.fiuba.algo3.interfaz.controladores.botones;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public abstract class ControladorBoton {
    abstract public Bloque obtenerAccion(ObservableList<Node> hijos);
}
