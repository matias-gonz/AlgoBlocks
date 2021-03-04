package edu.fiuba.algo3.modelo.bloques;

import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Personaje;

public class BloqueMovimiento implements Bloque{
    Movimiento movimiento;

    public BloqueMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(movimiento, dibujo);
    }

    @Override
    public void ejecutarOpuesto(Personaje personaje, Dibujo dibujo) {
        personaje.mover(movimiento.opuesto(), dibujo);
    }
}

