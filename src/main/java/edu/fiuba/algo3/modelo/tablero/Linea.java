package edu.fiuba.algo3.modelo.tablero;

import java.util.List;

// clase anémica momentaneamente, pero posiblemente deje de serlo cuando se implemente el dibujo en la interfaz gráfica.

public class Linea {
    private final Posicion posInicial;
    private Posicion posFinal;

    public Linea(Posicion posicion) { this.posInicial = new Posicion(posicion.obtenerCoordenadas()); }

    public void setPosFinal(Posicion posFinal) { this.posFinal = new Posicion(posFinal.obtenerCoordenadas()); }

    public List<Integer> obtenerCoordenadasPosicionInicial()
    {
        return this.posInicial.obtenerCoordenadas();
    }

    public List<Integer> obtenerCoordenadasPosicionFinal()
    {
        return this.posFinal.obtenerCoordenadas();
    }

    public void dibujar(){
        //Cuando haya interfaz grafica
    }
}
