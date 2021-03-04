package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.tablero.movimiento.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    private List<Linea> lineas = new ArrayList<>();

    public void agregarLinea(Movimiento movimiento, Posicion posicion) {
        Linea linea = new Linea(posicion);
        movimiento.mover(posicion);
        linea.setPosFinal(posicion);
        lineas.add(linea);
    }

    public void dibujar(){
        for(Linea i : lineas){
            i.dibujar();
        }
    }

    public List<Linea> obtenerSectorDibujado() {
        return lineas;
    }

    public void reset() {
        this.lineas = new ArrayList<>();
    }
}
