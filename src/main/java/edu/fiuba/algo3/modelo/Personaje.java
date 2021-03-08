package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.lapiz.Lapiz;
import edu.fiuba.algo3.modelo.lapiz.LapizApoyado;
import edu.fiuba.algo3.modelo.lapiz.LapizLevantado;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class Personaje implements Observable{

    private Lapiz lapiz = new LapizLevantado(); // por defecto, el lapiz arranca arriba.
    private Posicion posicion_personaje = new Posicion(0,0);
    private ArrayList<Observador> observador = new ArrayList<>();


    public void ejecutarBloques(List<Bloque> bloques, Dibujo dibujo) {
        bloques.forEach( bloque -> bloque.ejecutar(this, dibujo) );
    }

    public void mover(Movimiento movimiento, Dibujo dibujo) {
        lapiz.dibujar(movimiento, this.posicion_personaje, dibujo);
        notificarObservador();
    }

    public void apoyarLapiz(){
        this.lapiz = new LapizApoyado();
    }

    public void levantarLapiz(){
        this.lapiz = new LapizLevantado();
    }

    public List<Integer> obtenerPosicion() {

        return this.posicion_personaje.obtenerCoordenadas();
    }

    public void reset() {
        this.posicion_personaje = new Posicion(0,0);
        this.levantarLapiz();
        notificarObservador();
    }


    @Override
    public void agregarObservador(Observador observador) {
        this.observador.add(observador);
    }

    @Override
    public void notificarObservador() {
        this.observador.forEach( obs -> obs.update());
    }
}