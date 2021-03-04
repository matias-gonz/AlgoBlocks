package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tablero.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoAbajoTest {

    @Test
    public void test01seCambiaDePosicionUnaVezHaciaAbajo(){
        Posicion posicion = new Posicion(0, 0);
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(0,-1));
        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        movimientoAbajo.mover(posicion);

        assertEquals(coordenadas, posicion.obtenerCoordenadas());

    }

    @Test
    public void test02SeCambiaDePosicionDosVecesHaciaAbajo(){
        Posicion posicion = new Posicion(0, 0);
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(0,-2));
        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        movimientoAbajo.mover(posicion);

        movimientoAbajo.mover(posicion);

        assertEquals(coordenadas, posicion.obtenerCoordenadas());

    }

}
