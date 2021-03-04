package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// en vez de comparar contra Arrays.asList, podriamos armar instanciar Posicion y hacer comparaciones entre Posiciones, quedaría mas bonito.
public class PosicionTest {

    Posicion posicion;

    @BeforeEach
    public void setUp() {
        posicion = new Posicion(0,0);
    }

    @Test
    public void test01SeDesplazaUnaUnidadHaciaLaDerecha(){
        posicion.desplazarDerecha();
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(1,0));

        assertEquals(coordenadas,posicion.obtenerCoordenadas());
    }

    @Test
    public void test02SeDesplazaUnaUnidadHaciaLaIzquierda(){
        posicion.desplazarIzquierda();
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(-1,0));

        assertEquals(coordenadas,posicion.obtenerCoordenadas());
    }

    @Test
    public void test03SeDesplazaUnaUnidadHaciaArriba(){
        posicion.desplazarArriba();
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(0,1));

        assertEquals(coordenadas,posicion.obtenerCoordenadas());
    }

    @Test
    public void test04SeDesplazaUnaUnidadHaciaAbajo(){
        posicion.desplazarAbajo();
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(0,-1));

        assertEquals(coordenadas,posicion.obtenerCoordenadas());
    }

    @Test
    public void test05SeDesplazaArribaYAbajoSigueEnElOrigen(){
        posicion.desplazarAbajo();
        posicion.desplazarArriba();
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(0,0));

        assertEquals(coordenadas,posicion.obtenerCoordenadas());
    }

    @Test
    public void test06SeDesplazaDerechaEIzquierdaSigueEnElOrigen(){
        posicion.desplazarDerecha();
        posicion.desplazarIzquierda();
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(0,0));

        assertEquals(coordenadas,posicion.obtenerCoordenadas());
    }

    @Test
    public void test07SeDesplazaUnaUnidadTodasLasDireccionesSigueEnElOrigen(){
        posicion.desplazarDerecha();
        posicion.desplazarIzquierda();
        posicion.desplazarAbajo();
        posicion.desplazarArriba();
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(0,0));

        assertEquals(coordenadas,posicion.obtenerCoordenadas());
    }

    @Test
    public void test08SeDesplazaEnTodasLasDirecciones(){
        for(int i = 0; i < 5 ; i++){
            posicion.desplazarDerecha();
        }
        for(int i = 0; i < 6 ; i++){
            posicion.desplazarAbajo();
        }
        posicion.desplazarIzquierda();
        posicion.desplazarArriba();
        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(4,-5));

        assertEquals(coordenadas,posicion.obtenerCoordenadas());
    }

    @Test
    public void test09SeDesplazaMuchasUnidadesEnDiagonalArribaDerecha(){
        for(int i = 0; i < 100 ; i++){
            posicion.desplazarDerecha();
        }
        for(int i = 0; i < 100; i++){
            posicion.desplazarArriba();
        }

        List<Integer> coordenadas = new ArrayList<>(Arrays.asList(100,100));

        assertEquals(coordenadas,posicion.obtenerCoordenadas());
    }
}
