package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tablero.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoDerechaTest {

    @Test
    public void test01seCambiaDePosicionUnaVezHaciaLaDerecha(){
        Posicion posicion = new Posicion(0, 0);
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(1,0));
        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();

        movimientoDerecha.mover(posicion);

        assertEquals(coordenadas, posicion.obtenerCoordenadas());
    }
}
