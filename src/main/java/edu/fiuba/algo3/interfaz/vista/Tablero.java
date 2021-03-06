package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;


public class Tablero extends BorderPane {
    private BarraDeMenu barraDeMenu;
    private SectorDibujo sectorDibujo;
    private SectorBloquesDisponibles sectorBloques;
    private SectorAlgoritmo sectorAlgoritmo;
    ScrollPane scrollBloques;


    public Tablero(MediaPlayer mediaPlayer) {
        inicializar(mediaPlayer);
        posicionarSectores();
        BorderPane.setMargin(sectorDibujo, new Insets(5,5,0,10));
        BorderPane.setMargin(scrollBloques, new Insets(5,5,20,10));
        BorderPane.setMargin(sectorAlgoritmo, new Insets(5,5,20,10));
        BackgroundFill fill = new BackgroundFill(Color.web("#97959E"), null, null);
        this.setBackground(new Background(fill));
    }

    private void posicionarSectores() {
        this.setTop(barraDeMenu);
        this.setCenter(scrollBloques);
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

        scrollBloques = new ScrollPane(sectorBloques);
        scrollBloques.setFitToWidth(true);
        scrollBloques.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollBloques.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

}

