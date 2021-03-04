package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lapiz.Lapiz;
import edu.fiuba.algo3.modelo.lapiz.LapizLevantado;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LapizLevantadoTest {

    Dibujo sectorDibujo;

    @BeforeEach
    public void setUp() {
        sectorDibujo = new Dibujo();
    }

    @Test
    public void test01LapizLevantadoNoPuedeDibujar() {
        Lapiz lapiz = new LapizLevantado();
        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();
        MovimientoArriba movimientoArriba = new MovimientoArriba();

        Posicion posicion = new Posicion(0,0);

        lapiz.dibujar(movimientoDerecha, posicion, sectorDibujo);
        lapiz.dibujar(movimientoArriba, posicion, sectorDibujo);

        assertEquals( 0, sectorDibujo.obtenerSectorDibujado().size() );
    }
}