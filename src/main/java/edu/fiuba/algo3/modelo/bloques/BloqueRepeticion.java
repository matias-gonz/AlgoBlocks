package edu.fiuba.algo3.modelo.bloques;

import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.excepciones.NumeroVecesInvalidoException;
import edu.fiuba.algo3.modelo.Personaje;

import java.util.ArrayList;
import java.util.List;

public class BloqueRepeticion implements Bloque {
    List<Bloque> bloques = new ArrayList<>();
    private final double veces_repeticion;

    public BloqueRepeticion(double veces, List<Bloque> arreglo_de_bloques) throws NumeroVecesInvalidoException {
        if(veces < 2 || veces > 3) throw new NumeroVecesInvalidoException();
        this.veces_repeticion = veces;
        bloques.addAll(arreglo_de_bloques);
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo){
        for( int j = 0; j < this.veces_repeticion; j++ ) {
            bloques.forEach( bloque -> bloque.ejecutar(personaje, dibujo) );
        }
    }

    @Override
    public void ejecutarOpuesto(Personaje personaje, Dibujo dibujo){
        for( int j = 0; j < this.veces_repeticion; j++ ) {
            bloques.forEach( bloque -> bloque.ejecutarOpuesto(personaje, dibujo) );
        }
    }
}
