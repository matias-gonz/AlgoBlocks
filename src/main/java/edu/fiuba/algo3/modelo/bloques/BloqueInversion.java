package edu.fiuba.algo3.modelo.bloques;

import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.Personaje;

import java.util.ArrayList;
import java.util.List;

public class BloqueInversion implements Bloque {
    List<Bloque> bloques = new ArrayList<>();

    public BloqueInversion(List<Bloque> arreglo_de_bloques){
        bloques.addAll(arreglo_de_bloques);
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo){
        bloques.forEach( bloque -> bloque.ejecutarOpuesto(personaje, dibujo) );
    }

    @Override
    public void ejecutarOpuesto(Personaje personaje, Dibujo dibujo){
        bloques.forEach( bloque -> bloque.ejecutar(personaje, dibujo) );
    }

}
