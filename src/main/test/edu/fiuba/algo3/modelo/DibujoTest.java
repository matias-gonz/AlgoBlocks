package edu.fiuba.algo3.modelo;

//No se me ocurre como testear sin la interfaz grafica y sin agregar getters

import edu.fiuba.algo3.modelo.bloques.*;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.Linea;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    Dibujo sectorDibujo;
    Personaje personaje;
    List<Bloque> lista_de_bloques = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        sectorDibujo = new Dibujo();
        personaje = new Personaje();
    }

    @Test
    public void test01ElDibujoIniciaVacio()
    {
        List<Linea> lineas = new ArrayList<>(); // lista de lineas vacia, por ende debería dar true.

        assertEquals( lineas, sectorDibujo.obtenerSectorDibujado() );
    }

    @Test
    public void test02MovimientoHaciaDerechaNoDebeDibujarPeroSiCambiarSuUbicacion()
    {
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento( new MovimientoDerecha() );

        bloqueMovimiento.ejecutar( personaje, sectorDibujo );

        Posicion posicionEsperada = new Posicion(1,0 );

        assertEquals( posicionEsperada.obtenerCoordenadas(), personaje.obtenerPosicion() );

        List<Linea> lineas = new ArrayList<>(); // lista de lineas vacia, se movió hacia la derecha, pero no dibujó.

        assertEquals( lineas, sectorDibujo.obtenerSectorDibujado() );
    }

    @Test
    public void test03SeVerificaLaCantidadDeLineasDibujadasEnElSectorDibujo()
    {
        lista_de_bloques.add( new BloqueBajarLapiz() );
        lista_de_bloques.add( new BloqueMovimiento( new MovimientoDerecha() ) );
        lista_de_bloques.add( new BloqueMovimiento( new MovimientoArriba()  ) );

        for( Bloque bloque : lista_de_bloques )
        {
            bloque.ejecutar(personaje, sectorDibujo);
        }

        // debe quedar dibujado los puntos (0,0) -> (1,0) -> (1,1) por ende son 2 lineas.
        assertEquals( 2, sectorDibujo.obtenerSectorDibujado().size() );
    }

    @Test
    public void test04SeBajaElLapizYSeDibuja1Vez()
    {
        lista_de_bloques.add( new BloqueBajarLapiz() );
        lista_de_bloques.add( new BloqueMovimiento( new MovimientoDerecha() ));
        // resumen, baja el lapiz, luego se mueve hacia la derecha 1 vez por ende queda en (1,0) ese es el sector dibujado.

        for( Bloque bloque : lista_de_bloques)
        {
            bloque.ejecutar(personaje, sectorDibujo);
        }

        // La linea dibujada en el sector Dibujo va desde (0,0) a (0,1), por ende, hacemos una linea para poder comparar
        Linea lineaComparacion = new Linea( new Posicion(0,0) ); // Linea arranca en (0,0)
        lineaComparacion.setPosFinal( new Posicion( 1,0) ); // se corta la linea en el (1,0).

        Linea trazoDibujado = sectorDibujo.obtenerSectorDibujado().get(0); // sabemos que solo existe 1 línea en el sector dibujo

        assertEquals( lineaComparacion.obtenerCoordenadasPosicionInicial(), trazoDibujado.obtenerCoordenadasPosicionInicial() );
        assertEquals( lineaComparacion.obtenerCoordenadasPosicionFinal(), trazoDibujado.obtenerCoordenadasPosicionFinal() );
    }

    @Test
    public void test05SeCreaUnaSecuenciaYSeCuentaLaCantidadDeLineasDibujadasMientrasLapizEstabaApoyado() {
        lista_de_bloques.add(new BloqueBajarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoArriba()));
        lista_de_bloques.add(new BloqueLevantarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueBajarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        // Mientras el lapiz estuvo bajado, solo se hicieron 6 líneas.

        for (Bloque bloque : lista_de_bloques) {
            bloque.ejecutar(personaje, sectorDibujo);
        }

        assertEquals( 6, sectorDibujo.obtenerSectorDibujado().size() );
    }

    @Test
    public void test06SeCreaUnaSecuenciaYSeVerificaQueLaSecuenciaEsteDibujada() {
        // Analisis del movimiento:
        // 10 movimientos total, solo 2 fueron con el lapiz apoyado.
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoArriba()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueBajarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));

        // lineas dibujadas (3,3) a (4,-3) - (4,-3) a (5,-3)
        List<Linea> trazosDibujados = new ArrayList<>();
        List<List<Integer>> coordenadas_esperadas = new ArrayList<>();
        coordenadas_esperadas.add(Arrays.asList(3, -3));
        coordenadas_esperadas.add(Arrays.asList(4, -3));
        coordenadas_esperadas.add(Arrays.asList(4, -3));
        coordenadas_esperadas.add(Arrays.asList(5, -3));

        for (Bloque bloque : lista_de_bloques) { // ejecutamos bloques
            bloque.ejecutar(personaje, sectorDibujo);
        }

        // generamos el array de lineas a comparar
        for (int k = 0; k < coordenadas_esperadas.size() ; k += 2) // saltando de a 2 ;
        {
            Linea temp_linea = new Linea(new Posicion(coordenadas_esperadas.get(k)));
            temp_linea.setPosFinal(new Posicion(coordenadas_esperadas.get(k + 1)));
            trazosDibujados.add(temp_linea);
        }

        // aquí hacemos la comparación entre las lineas en el dibujo vs las generadas para hacer la comparación.
        for( int i = 0; i < sectorDibujo.obtenerSectorDibujado().size() ; i++ )
        {
            Linea lineaCreadaParaComparar = trazosDibujados.get(i);
            Linea trazoDibujado = sectorDibujo.obtenerSectorDibujado().get(i);

            // aquí, las lineas dentro del dibujo como las creadas para comparar deben tener igual punto de inicio como final.
            assertEquals( lineaCreadaParaComparar.obtenerCoordenadasPosicionInicial(), trazoDibujado.obtenerCoordenadasPosicionInicial() );
            assertEquals( lineaCreadaParaComparar.obtenerCoordenadasPosicionFinal() , trazoDibujado.obtenerCoordenadasPosicionFinal() );
        }
    }

    @Test
    public void test07SeCreaUnaSecuenciaIncorporandoUnBloqueDeRepeticion() {
        lista_de_bloques.add(new BloqueBajarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoArriba()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        // hasta acá, bajamos el lapiz, dibujamos la línea desde (0,0) a (0,1) y luego de (0,1) a (1,1).


        List<Bloque> lista_bloques_repetir = new ArrayList<>();
        lista_bloques_repetir.add( new BloqueMovimiento( new MovimientoArriba() ));
        lista_bloques_repetir.add( new BloqueMovimiento( new MovimientoArriba() ));
        /* se mueve hacia arriba 2 veces, es decir:
            - dibuja en la primera etapa desde (1,1) a (1,2) y luego (1,2) -> (1,3)
            - dibuja en la seugjnda etapa desde (1,3) a (1,4) y luego (1,4) -> (1,5)
        */

        lista_de_bloques.forEach( bloque -> bloque.ejecutar(personaje, sectorDibujo) ); // ejecutamos los bloque previos
        BloqueRepeticion bloqueRepeticion = new BloqueRepeticion(2, lista_bloques_repetir);
        bloqueRepeticion.ejecutar(personaje, sectorDibujo);

        // ahora, a crear las lineas para comparar.
        List<Linea> trazosDibujados = new ArrayList<>();
        List<List<Integer>> coordenadas_esperadas = new ArrayList<>();
        coordenadas_esperadas.add(Arrays.asList(0, 0));
        coordenadas_esperadas.add(Arrays.asList(0, 1));
        coordenadas_esperadas.add(Arrays.asList(0, 1));
        coordenadas_esperadas.add(Arrays.asList(1, 1));
        coordenadas_esperadas.add(Arrays.asList(1, 1));
        coordenadas_esperadas.add(Arrays.asList(1, 2));
        coordenadas_esperadas.add(Arrays.asList(1, 2));
        coordenadas_esperadas.add(Arrays.asList(1, 3));
        coordenadas_esperadas.add(Arrays.asList(1, 3));
        coordenadas_esperadas.add(Arrays.asList(1, 4));
        coordenadas_esperadas.add(Arrays.asList(1, 4));
        coordenadas_esperadas.add(Arrays.asList(1, 5));

        // generamos el array de lineas a comparar
        for (int k = 0; k < coordenadas_esperadas.size() ; k += 2) // saltando de a 2 ;
        {
            Linea temp_linea = new Linea(new Posicion(coordenadas_esperadas.get(k)));
            temp_linea.setPosFinal(new Posicion(coordenadas_esperadas.get(k + 1)));
            trazosDibujados.add(temp_linea);
        }

        // aquí hacemos la comparación entre las lineas en el dibujo vs las generadas para hacer la comparación.
        for( int i = 0; i < sectorDibujo.obtenerSectorDibujado().size() ; i++ )
        {
            Linea lineaCreadaParaComparar = trazosDibujados.get(i);
            Linea trazoDibujado = sectorDibujo.obtenerSectorDibujado().get(i);

            // aquí, las lineas dentro del dibujo como las creadas para comparar deben tener igual punto de inicio como final.
            assertEquals( lineaCreadaParaComparar.obtenerCoordenadasPosicionInicial(), trazoDibujado.obtenerCoordenadasPosicionInicial() );
            assertEquals( lineaCreadaParaComparar.obtenerCoordenadasPosicionFinal() , trazoDibujado.obtenerCoordenadasPosicionFinal() );
        }
    }

    @Test
    public void test08SeCreaUnaSecuenciaDibujaLuegoReseteaYNoHayLineas() {
        lista_de_bloques.add(new BloqueBajarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoArriba()));
        lista_de_bloques.add(new BloqueLevantarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoAbajo()));
        lista_de_bloques.add(new BloqueBajarLapiz());
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        lista_de_bloques.add(new BloqueMovimiento(new MovimientoDerecha()));
        // Mientras el lapiz estuvo bajado, solo se hicieron 6 líneas.

        for (Bloque bloque : lista_de_bloques) {
            bloque.ejecutar(personaje, sectorDibujo);
        }

        sectorDibujo.reset();
        assertEquals( 0, sectorDibujo.obtenerSectorDibujado().size() );
    }
}
