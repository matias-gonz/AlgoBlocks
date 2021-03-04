package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;


public class Tablero extends BorderPane {
    private BarraDeMenu barraDeMenu;
    private SectorDibujo sectorDibujo;
    private SectorBloquesDisponibles sectorBloques;
    private SectorAlgoritmo sectorAlgoritmo;

    public Tablero(MediaPlayer mediaPlayer) {
        inicializar(mediaPlayer);
        posicionarSectores();
        BorderPane.setMargin(sectorDibujo, new Insets(0,5,300,10));
        BorderPane.setMargin(sectorBloques, new Insets(0,5,20,10));
        BorderPane.setMargin(sectorAlgoritmo, new Insets(0,5,20,10));
    }

    private void posicionarSectores() {
        this.setTop(barraDeMenu);
        this.setCenter(sectorBloques);
        this.setRight(sectorAlgoritmo);
        this.setLeft(sectorDibujo);
    }

    private void inicializar(MediaPlayer mediaPlayer){

        barraDeMenu = new BarraDeMenu(mediaPlayer);
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje();

        sectorDibujo = new SectorDibujo(personaje, dibujo);
        sectorBloques = new SectorBloquesDisponibles(sectorDibujo, personaje);

        // la conexión completa. sectorAlgoritmo tiene acceso a sector bloques y sector bloques tiene acceso a sector dibujo.
        sectorAlgoritmo = new SectorAlgoritmo( sectorBloques );
    }




}

