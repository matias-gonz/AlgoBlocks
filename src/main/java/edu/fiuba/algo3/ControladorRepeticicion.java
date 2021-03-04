package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.bloques.BloqueRepeticion;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class ControladorRepeticicion implements AccionBotones {

    ObservableList<Node> hijos;
    public ControladorRepeticicion(ObservableList<Node> obtenerHijos) {
        this.hijos = obtenerHijos;
    }

    public Bloque obtenerAccion() {
        return generarBloque();
    }

    private Bloque generarBloque() {
        ComboBox combo = (ComboBox) this.hijos.get(0);
        int repeticiones = (int) combo.getValue();

        ArrayList<Bloque> bloques = new ArrayList<>();

        System.out.println("Debug controlador Repeticion = " + this.hijos);
/*
        for( int i = 1 ; i < this.hijos.size(); i++ )
        {
            bloques.add( (Bloque) this.hijos.get(i) );
        }*/
        return new BloqueRepeticion(repeticiones, bloques);
    }
}
