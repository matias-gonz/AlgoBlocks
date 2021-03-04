package edu.fiuba.algo3.modelo.tablero;

import java.util.ArrayList;
import java.util.List;

public class Posicion {
    private int posHorizontal;
    private int posVertical;

    public Posicion(int posHorizontal, int posVertical) {
        this.posHorizontal = posHorizontal;
        this.posVertical = posVertical;
    }

    public Posicion(List<Integer> coordenadas){
        this.posHorizontal = coordenadas.get(0);
        this.posVertical = coordenadas.get(1);
    }

    public List<Integer> obtenerCoordenadas(){
        List<Integer> coordenadas = new ArrayList<>();
        coordenadas.add(posHorizontal);
        coordenadas.add(posVertical);
        return coordenadas;
    }

    public void desplazarAbajo() {
        this.posVertical = this.posVertical - 1;
    }

    public void desplazarArriba() {
        this.posVertical = this.posVertical + 1;
    }

    public void desplazarDerecha() {
        this.posHorizontal = this.posHorizontal + 1;
    }

    public void desplazarIzquierda() {
        this.posHorizontal = this.posHorizontal - 1;
    }
}
