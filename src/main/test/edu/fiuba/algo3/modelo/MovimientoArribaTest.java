package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tablero.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoArribaTest {
    @Test
    public void  test01seCambiaDePosicionUnaVezHaciaArriba(){
        Posicion posicion = new Posicion(0, 0);
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(0,1));

        MovimientoArriba movimientoArriba = new MovimientoArriba();

        movimientoArriba.mover(posicion);

        assertEquals(coordenadas, posicion.obtenerCoordenadas());
    }
}
