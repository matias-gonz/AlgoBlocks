package edu.fiuba.algo3.interfaz.controladores.botones;

import edu.fiuba.algo3.interfaz.ContenedorBloque;
import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.bloques.BloqueInversion;
import edu.fiuba.algo3.modelo.bloques.BloqueRepeticion;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ControladorInvertir extends ControladorBoton {

    @Override
    public Bloque obtenerAccion(ObservableList<Node> hijos) {
        VBox contenedorAEjecutar = (VBox) hijos.get(1);

        ArrayList<Bloque> bloquesEjecutar = new ArrayList<>();
        for(int i = 0; i < contenedorAEjecutar.getChildren().size(); i++){
            ContenedorBloque contenedorBloque = (ContenedorBloque) contenedorAEjecutar.getChildren().get(i);
            bloquesEjecutar.add( contenedorBloque.obtenerBloque() );
        }

        return new BloqueInversion(bloquesEjecutar);
    }
}