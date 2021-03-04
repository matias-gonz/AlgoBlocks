package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloques.*;
import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueInversionTest {

    BloqueInversion bloqueInversion;
    Personaje personaje;
    Dibujo dibujo;
    List<Bloque> bloquesAEjecutar;
    Posicion posicionEsperada;

    @BeforeEach
    public void setUp(){
        personaje = new Personaje();
        dibujo = new Dibujo();
        bloquesAEjecutar = new ArrayList<>();
    }

    @Test
    public void test01SeMueveHaciaLaDerechaSeEsperaUnMovimientoOpuesto() {
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento( new MovimientoDerecha() );
        bloqueInversion = new BloqueInversion( Collections.singletonList(bloqueMovimiento) ); // el compilador le gusta mas esto

        bloqueInversion.ejecutar(personaje, dibujo);

        posicionEsperada = new Posicion(-1,0);
        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );
    }

    @Test
    public void test02SeMueveHaciaArribayDerechaSeEsperaMovimientoOpuesto()
    {
        BloqueMovimiento bloqueMovimientoArriba = new BloqueMovimiento( new MovimientoArriba() );
        BloqueMovimiento bloqueMovimientoDerecha = new BloqueMovimiento( new MovimientoDerecha() );

        bloqueInversion = new BloqueInversion( Arrays.asList(bloqueMovimientoArriba, bloqueMovimientoDerecha) );

        bloqueInversion.ejecutar(personaje, dibujo);

        posicionEsperada = new Posicion(-1,-1);
        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion());
    }

    @Test
    public void test03SeLevantaElLapizYSeMueveHaciaAbajoSeEsperaMovimientoOpuesto() {
        // el orden opuesto a este test sería que baja el lapiz, y dibuja hacia arriba (posicion = (0,1))
        BloqueLevantarLapiz bloqueLevantarLapiz = new BloqueLevantarLapiz();
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());

        bloqueInversion = new BloqueInversion(Arrays.asList(bloqueLevantarLapiz, bloqueMoverAbajo));

        bloqueInversion.ejecutar(personaje, dibujo);

        posicionEsperada = new Posicion(0,1);
        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion());
    }

    @Test
    public void test04SeInvierteElMovimientoDeUnBloqueInverso() {
        // si se invierte un bloque inversion, DEBE anular la inversion y realizar el movimiento por default.
        BloqueMovimiento bloqueMovimientoArriba = new BloqueMovimiento( new MovimientoArriba() );
        BloqueInversion primerBloqueInversion = new BloqueInversion( Arrays.asList(bloqueMovimientoArriba) );
        BloqueInversion segundoBloqueInversion = new BloqueInversion( Arrays.asList(primerBloqueInversion) );

        segundoBloqueInversion.ejecutar(personaje, dibujo);

        posicionEsperada = new Posicion(0,1);
        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion());
    }

    @Test
    public void test05SeCreaUnaSecuenciaRepetitiva()
    {
        BloqueMovimiento bloqueMovimientoArriba = new BloqueMovimiento( new MovimientoArriba() );
        BloqueMovimiento bloqueMovimientoDerecha = new BloqueMovimiento( new MovimientoDerecha() );
        BloqueRepeticion bloqueRepeticion = new BloqueRepeticion( 2, Arrays.asList(bloqueMovimientoArriba, bloqueMovimientoDerecha));
        // (0,1) luego (1,1) -> (1,1) a (1,2) y para terminar en (2,2).

        bloqueInversion = new BloqueInversion( Arrays.asList(bloqueRepeticion) );

        bloqueInversion.ejecutar(personaje, dibujo);

        // debería quedar en la coordenada (-2, -2).
        posicionEsperada = new Posicion(-2,-2);
        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );
    }

    @Test
    public void test06SeInvierteAlgoritmoPersonalizado()
    {
        BloqueMovimiento bloqueMovimientoArriba = new BloqueMovimiento( new MovimientoArriba() );
        BloqueMovimiento bloqueMovimientoDerecha = new BloqueMovimiento( new MovimientoDerecha() );
        BloqueRepeticion bloqueRepeticion = new BloqueRepeticion(2, Arrays.asList(bloqueMovimientoArriba, bloqueMovimientoDerecha));
        DBAlgoritmoPersonalizados dbAlgoritmosPersonalizados = new DBAlgoritmoPersonalizados();

        BloqueAlgoritmoPersonalizado bloqueGuardado = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados,
                Collections.singletonList(bloqueRepeticion), "test06" );

        BloqueAlgoritmoPersonalizado bloqueCarga = new BloqueAlgoritmoPersonalizado( dbAlgoritmosPersonalizados,
                "test06");


        bloqueInversion = new BloqueInversion( Arrays.asList(bloqueCarga) );

        bloqueInversion.ejecutar(personaje, dibujo);

        posicionEsperada = new Posicion(-2,-2);
        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion());
    }

    @Test
    public void test07SeInvierteBloqueBajarLapizNoDebeDibujar()
    {
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento( new MovimientoArriba() );

        BloqueInversion bloqueInvertir = new BloqueInversion( Arrays.asList(bloqueBajarLapiz, bloqueMoverArriba,
                                         bloqueMoverArriba, bloqueMoverArriba, bloqueMoverArriba));

        bloqueInvertir.ejecutar(personaje, dibujo);

        Posicion posicionEsperada = new Posicion( 0, -4 );
        assertEquals( new ArrayList<>(), dibujo.obtenerSectorDibujado() ); // no tiene líneas dibujadas ya que se sube el lapiz
        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );
    }
}
