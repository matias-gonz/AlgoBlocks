package edu.fiuba.algo3.modelo;

public interface ObservablePersonaje {
    void agregarObservador(ObservadorPersonaje obs);
    void notificarObservador();
}
