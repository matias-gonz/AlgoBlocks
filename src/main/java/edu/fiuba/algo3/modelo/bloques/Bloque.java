package edu.fiuba.algo3.modelo.bloques;

import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.Personaje;

public interface Bloque {
    void ejecutar(Personaje personaje, Dibujo dibujo);
    void ejecutarOpuesto(Personaje personaje, Dibujo dibujo);
}
