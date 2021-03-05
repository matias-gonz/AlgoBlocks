package edu.fiuba.algo3.interfaz.vista;

public class Rango {
    private double ancho;
    private double altura;

    public void setAltura(double altura){ this.altura = altura; }

    public void setAncho(double ancho) { this.ancho = ancho; }

    public boolean esExcedido(double x, double y){
        return ( x >= ancho|| y >= altura || x <= 0 || y <= 0);
    }
}
