package edu.fiuba.algo3.interfaz.vista.botoneras;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BotonGAPersonalizado extends Button {

    ObservableList<Node> nodosAlgoritmoAEjecutar;

    public BotonGAPersonalizado(TextField texto, ObservableList<Node> children) {
        super(texto.getText());
        this.nodosAlgoritmoAEjecutar = children;

        /* acá es cuando tenes que a este botón darle la chance de arrastrarlo al sector algoritmo de nuevo, y se
         repite el bucle. Puede extender de Button, o podes hacerlo extender de BotonABGA y agregarle un icono */
    }
}
