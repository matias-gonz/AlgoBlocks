package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloques.Bloque;
import edu.fiuba.algo3.modelo.bloques.BloqueBajarLapiz;
import edu.fiuba.algo3.modelo.bloques.BloqueLevantarLapiz;
import edu.fiuba.algo3.modelo.bloques.BloqueMovimiento;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.Linea;
import edu.fiuba.algo3.modelo.tablero.movimiento.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    /* Pruebas unitarias*/
    @Test
    public void test01ElPersonajeSePuedeMoverHaciaArriba(){
        Personaje personaje = new Personaje();
        MovimientoArriba movimientoArriba = new MovimientoArriba();

        personaje.mover(movimientoArriba, new Dibujo());

        assertEquals( Arrays.asList(0, 1), personaje.obtenerPosicion() );
    }

    @Test
    public void test02ElPersonajePuedeRepetirElMomientoHaciaArriba(){
        Personaje personaje = new Personaje();
        MovimientoArriba movimientoArriba = new MovimientoArriba();

        personaje.mover(movimientoArriba, new Dibujo());
        personaje.mover(movimientoArriba, new Dibujo());

        assertEquals( Arrays.asList(0, 2), personaje.obtenerPosicion() );
    }

    @Test
    public void test03ElPersonajeSePuedeMoverHaciaAbajo(){
        Personaje personaje = new Personaje();
        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        personaje.mover(movimientoAbajo, new Dibujo());

        assertEquals( Arrays.asList(0, -1), personaje.obtenerPosicion() );
    }

    @Test
    public void test04ElPersonajePuedeRepetirElMovimientoHaciaAbajo(){
        Personaje personaje = new Personaje();
        MovimientoAbajo movimientoAbajo = new MovimientoAbajo();

        personaje.mover(movimientoAbajo, new Dibujo());
        personaje.mover(movimientoAbajo, new Dibujo());

        assertEquals( Arrays.asList(0, -2), personaje.obtenerPosicion() );
    }

    @Test
    public void test05ElPersonajeSePuedeMoverHaciaLaIzquierda(){
        Personaje personaje = new Personaje();
        MovimientoIzquierda movimientoIzquierda = new MovimientoIzquierda();

        personaje.mover(movimientoIzquierda, new Dibujo());

        assertEquals( Arrays.asList(-1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test06ElPersonajePuedeRepetirElMovimientoHaciaLaIzquierda(){
        Personaje personaje = new Personaje();
        MovimientoIzquierda movimientoIzquierda = new MovimientoIzquierda();

        personaje.mover(movimientoIzquierda, new Dibujo());
        personaje.mover(movimientoIzquierda, new Dibujo());

        assertEquals( Arrays.asList(-2, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test07ElPersonajeSePuedeMoverHaciaLaDerecha(){
        Personaje personaje = new Personaje();
        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();

        personaje.mover(movimientoDerecha, new Dibujo());

        assertEquals( Arrays.asList(1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test08ElPersonajePuedeRepetirElMovimientoHaciaLaDerecha(){
        Personaje personaje = new Personaje();
        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();

        personaje.mover(movimientoDerecha, new Dibujo());
        personaje.mover(movimientoDerecha, new Dibujo());

        assertEquals( Arrays.asList(2, 0), personaje.obtenerPosicion() );
    }


    /*Pruebas de integracion*/
    Personaje personaje;
    Dibujo sectorDibujo;
    Linea lineaTrazada;

    @BeforeEach
    public void setUp() {
        personaje = new Personaje();
        sectorDibujo = new Dibujo();
    }

    private void ejecutarBloque(Personaje personaje, Bloque bloque, int cantidad){
        for(int i = 0; i < cantidad; i++)
            bloque.ejecutar(personaje, new Dibujo());
    }

    @Test
    public void test01SeCreaUnPersonajeYLaPosicionInicialEs0_0(){
        assertEquals( Arrays.asList(0,0), personaje.obtenerPosicion() );
    }

    @Test
    public void test02SeMueveUnPersonajeUnaPosicionALaDerecha(){
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento(new MovimientoDerecha());
        ejecutarBloque(personaje,bloqueMoverDerecha,1);

        assertEquals( Arrays.asList(1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test03SeMueveUnPersonajeTresPosicionesALaDerecha(){
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento(new MovimientoDerecha());
        ejecutarBloque(personaje,bloqueMoverDerecha,3);

        assertEquals( Arrays.asList(3, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test04SeMueveUnPersonajeUnaPosicionALaIzquierda(){
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());
        ejecutarBloque(personaje,bloqueMoverIzquierda,1);

        assertEquals( Arrays.asList(-1, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test05SeMueveUnPersonajeTresPosicionesALaIzquierda(){
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());
        ejecutarBloque(personaje,bloqueMoverIzquierda,3);

        assertEquals( Arrays.asList(-3, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test06SeMueveUnPersonajeUnaPosicionArriba(){
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());
        ejecutarBloque(personaje,bloqueMoverArriba,1);

        assertEquals( Arrays.asList(0, 1), personaje.obtenerPosicion() );
    }

    @Test
    public void test07SeMueveUnPersonajeTresPosicionesArriba(){
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());
        ejecutarBloque(personaje,bloqueMoverArriba,3);

        assertEquals( Arrays.asList(0, 3), personaje.obtenerPosicion() );
    }

    @Test
    public void test08SeMueveUnPersonajeUnaPosicionAbajo(){
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());
        ejecutarBloque(personaje,bloqueMoverAbajo,1);

        assertEquals( Arrays.asList(0, -1), personaje.obtenerPosicion() );
    }

    @Test
    public void test09SeMueveUnPersonajeTresPosicionesAbajo(){
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());
        ejecutarBloque(personaje,bloqueMoverAbajo,3);

        assertEquals( Arrays.asList(0, -3), personaje.obtenerPosicion() );
    }


    @Test
    public void test10SeMueveElPersonajeParaArribaYAbajoDebeTerminarEn0_0() {
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());

        ejecutarBloque(personaje,bloqueMoverArriba,1);
        ejecutarBloque(personaje,bloqueMoverAbajo,1);

        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test11SeMueveElPersonajeParaIzquierdaYDerechaDebeTerminarEn0_0() {
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento(new MovimientoDerecha());

        ejecutarBloque(personaje,bloqueMoverIzquierda,1);
        ejecutarBloque(personaje,bloqueMoverDerecha,1);

        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test12SeMueveElPersonajeHaciaDiferentesSentidos() {
        List<Movimiento> listaDeMovimiento = new ArrayList<>();
        listaDeMovimiento.add(new MovimientoAbajo());
        listaDeMovimiento.add(new MovimientoAbajo());
        listaDeMovimiento.add(new MovimientoDerecha());
        listaDeMovimiento.add(new MovimientoArriba());

        List<List<Integer>> lista_posiciones_esperadas = new ArrayList<>();
        lista_posiciones_esperadas.add( Arrays.asList(0, -1) );
        lista_posiciones_esperadas.add( Arrays.asList(0, -2) );
        lista_posiciones_esperadas.add( Arrays.asList(1, -2) );
        lista_posiciones_esperadas.add( Arrays.asList(1, -1) );

        int i;
        for( i = 0; i < lista_posiciones_esperadas.size( ); i++ )
        {
            BloqueMovimiento bloqueMovimiento = new BloqueMovimiento( listaDeMovimiento.get(i) );
            ejecutarBloque(personaje, bloqueMovimiento, 1); // usamos la misma función creada
            assertEquals( lista_posiciones_esperadas.get(i), personaje.obtenerPosicion() );
        }
    }

    @Test
    public void test13SeMueveElPersonajeConListaDeBloquesMovimientoHaciaIzquierda() {
        BloqueMovimiento bloqueMoverIzquierda = new BloqueMovimiento(new MovimientoIzquierda());
        List<Bloque> bloques = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bloques.add(bloqueMoverIzquierda);
        }

        personaje.ejecutarBloques(bloques, new Dibujo());

        assertEquals( Arrays.asList(-10, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test14SeMueveElPersonajeConListaDeBloquesMovimientoHaciaArribaYAbajo() {
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());
        BloqueMovimiento bloqueMoverAbajo = new BloqueMovimiento(new MovimientoAbajo());
        List<Bloque> bloques = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            bloques.add(bloqueMoverAbajo);
            bloques.add(bloqueMoverArriba);
        }

        personaje.ejecutarBloques(bloques, new Dibujo());

        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }

    @Test
    public void test15PersonajeConLapizApoyadoPuedeDibujarUnaLineaHaciaLaDerecha() {
        List<Bloque> bloques = new ArrayList<>();

        bloques.add(new BloqueBajarLapiz());
        bloques.add(new BloqueMovimiento(new MovimientoDerecha()));

        personaje.ejecutarBloques(bloques, sectorDibujo);
        lineaTrazada = sectorDibujo.obtenerSectorDibujado().get(0);

        //La posicion de personaje coincide con la posFinal del trazo de Linea
        assertEquals(lineaTrazada.obtenerCoordenadasPosicionFinal(), personaje.obtenerPosicion());
    }

    @Test
    public void test16PersonajeConLapizApoyadoDibujaDosLineasSeguidasHaciaLaDerecha(){
        List<Bloque> bloques = new ArrayList<>();

        bloques.add(new BloqueBajarLapiz());
        bloques.add(new BloqueMovimiento(new MovimientoDerecha()));

        personaje.ejecutarBloques(bloques, sectorDibujo);
        lineaTrazada = sectorDibujo.obtenerSectorDibujado().get(0);

        assertEquals(lineaTrazada.obtenerCoordenadasPosicionFinal(), personaje.obtenerPosicion());

        MovimientoDerecha movimientoDerecha = new MovimientoDerecha();
        personaje.mover(movimientoDerecha, sectorDibujo);
        lineaTrazada = sectorDibujo.obtenerSectorDibujado().get(1);

        assertEquals(lineaTrazada.obtenerCoordenadasPosicionFinal(), personaje.obtenerPosicion());
    }

    @Test
    public void test17PersonajeSeMueveTresVecesPeroSoloDibujaDosLineas(){
        List<Bloque> bloques = new ArrayList<>();
        bloques.add(new BloqueBajarLapiz());
        bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        bloques.add(new BloqueLevantarLapiz());
        bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        bloques.add(new BloqueBajarLapiz());
        bloques.add(new BloqueMovimiento(new MovimientoArriba()));

        personaje.ejecutarBloques(bloques, sectorDibujo);

        lineaTrazada = sectorDibujo.obtenerSectorDibujado().get(1);

        assertEquals( 2, sectorDibujo.obtenerSectorDibujado().size() );
        assertEquals(lineaTrazada.obtenerCoordenadasPosicionFinal(), personaje.obtenerPosicion());
    }

    @Test
    public void test18SeMueveElPersonajeLuegoReseteaYTienePosicion00() {
        BloqueMovimiento bloqueMoverArriba = new BloqueMovimiento(new MovimientoArriba());
        BloqueMovimiento bloqueMoverDerecha = new BloqueMovimiento(new MovimientoDerecha());
        List<Bloque> bloques = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            bloques.add(bloqueMoverDerecha);
            bloques.add(bloqueMoverArriba);
        }

        personaje.ejecutarBloques(bloques, new Dibujo());
        personaje.reset();

        assertEquals( Arrays.asList(0, 0), personaje.obtenerPosicion() );
    }
}