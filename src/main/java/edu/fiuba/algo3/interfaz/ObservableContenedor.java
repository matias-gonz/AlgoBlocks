package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.ContenedorRepeticion;

public interface ObservableContenedor {
    void agregarObservador(ContenedorRepeticion observador);
    void notificarObservador(double x, double y, int hijos );
}
