package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloques.BloqueAlgoritmoPersonalizado;
import edu.fiuba.algo3.modelo.bloques.BloqueInversion;
import edu.fiuba.algo3.modelo.bloques.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloques.BloqueRepeticion;
import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoIzquierda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BloqueAlgoritmoPersonalizadoTest {

    DBAlgoritmoPersonalizados dbAlgoritmosPersonalizados;
    Dibujo dibujo;
    Personaje personaje;

    BloqueMovimiento bloqueMoverArriba, bloqueMoverAbajo, bloqueMoverIzquierda, bloqueMoverDerecha;

    @BeforeEach
    void setUp() {
        dbAlgoritmosPersonalizados = new DBAlgoritmoPersonalizados();
        dibujo = new Dibujo();
        personaje = new Personaje();

        bloqueMoverAbajo = new BloqueMovimiento( new MovimientoAbajo() );
        bloqueMoverArriba = new BloqueMovimiento( new MovimientoArriba() );
        bloqueMoverIzquierda = new BloqueMovimiento( new MovimientoIzquierda() );
        bloqueMoverDerecha = new BloqueMovimiento( new MovimientoDerecha() );
    }

    @Test
    public void test01SeCreaUnAlgoritmoPersonalizadoALaDerechaySeLoGuarda()
    {
        BloqueAlgoritmoPersonalizado bloqueap = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados, Arrays.asList(bloqueMoverArriba, bloqueMoverDerecha), "test01");

        BloqueAlgoritmoPersonalizado bloqueapCarga = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados, "test01");

        bloqueapCarga.ejecutar(personaje, dibujo);

        Posicion posicionEsperada = new Posicion(1,1);

        assertEquals( posicionEsperada.obtenerCoordenadas() , personaje.obtenerPosicion() );
    }

    @Test
    public void test02SeCreaAlgoritmoPersonalizadoConBloqueRepeticion()
    {
        BloqueRepeticion bloqueRepeticion = new BloqueRepeticion( 2, Arrays.asList( bloqueMoverIzquierda, bloqueMoverArriba ) );

        BloqueAlgoritmoPersonalizado bloqueGuardado = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados,
                Collections.singletonList(bloqueRepeticion), "test02" );

        BloqueAlgoritmoPersonalizado bloqueCarga = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados,
                                                    "test02");

        bloqueCarga.ejecutar(personaje, dibujo);

        Posicion posicionEsperada = new Posicion( -2, 2 );

        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );
    }

    @Test
    public void test03SeCreaAlgoritmoPersonalizadoConBloqueInversion()
    {
        BloqueRepeticion bloqueRepeticion = new BloqueRepeticion( 2, Arrays.asList( bloqueMoverIzquierda, bloqueMoverArriba ) );
        BloqueInversion bloqueInversion = new BloqueInversion(Arrays.asList(bloqueRepeticion));

        BloqueAlgoritmoPersonalizado bloqueGuardado = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados,
                Collections.singletonList(bloqueInversion), "test03" );

        BloqueAlgoritmoPersonalizado bloqueCarga = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados,
                "test03");

        bloqueCarga.ejecutar(personaje, dibujo);

        Posicion posicionEsperada = new Posicion( 2, -2 );

        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );
    }
}