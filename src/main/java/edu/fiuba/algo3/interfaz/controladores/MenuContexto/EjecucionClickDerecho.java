package edu.fiuba.algo3.interfaz.controladores.MenuContexto;

import edu.fiuba.algo3.interfaz.vista.contenedores.ContenedorBloque;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class EjecucionClickDerecho {

    // click derecho en sector algoritmo.
    public void resolucionClickDerecho(ContenedorBloque contenedorBloque, SectorAlgoritmo sector, MouseEvent mouseEvent, BotonAB boton, SectorBloquesDisponibles sectorBloquesDisponibles, VBox contenedorSectorAlgoritmo)
    {
        crearMenu(sector, mouseEvent, actionEvent -> {
            contenedorSectorAlgoritmo.getChildren().remove(contenedorBloque);// borramos el bloque del contenedor sector algoritmo

            contenedorBloque.getChildren().clear();

            // hay cambios, hay que decirle al sector bloques disponibles
            sectorBloquesDisponibles.notificarObservador(contenedorSectorAlgoritmo);

            this.reproducirSonido();
        });
    }

    // resolución click derecho en un contenedor de un botón comun!
    public void resolucionClickDerecho(BotonAB boton, SectorAlgoritmo sector, ContenedorBloque contenedorBloque, VBox contenedorMadre, SectorBloquesDisponibles sectorBloquesDisponibles, MouseEvent mouseEvent) {
        crearMenu(sector, mouseEvent, actionEvent -> {
            contenedorBloque.getChildren().clear();

            double tamanio_x = contenedorMadre.getPrefWidth();
            double tamanio_y = contenedorMadre.getPrefHeight();

            contenedorMadre.setMinSize( tamanio_x , tamanio_y - 60 );
            contenedorMadre.setPrefSize( tamanio_x , tamanio_y - 60 );

            contenedorMadre.getChildren().remove(contenedorBloque);

            this.reproducirSonido();
        });
    }

    // resolución click derecho para contenedores!
    public void resolucionClickDerecho(VBox contenedorMadre, SectorAlgoritmo sectorAlgoritmo, MouseEvent mouseEvent, SectorBloquesDisponibles sectorBloquesDisponibles, ContenedorBloque contenedorBloqueRepeticion )
    {
        crearMenu(sectorAlgoritmo, mouseEvent, actionEvent -> {
            contenedorBloqueRepeticion.getChildren().clear();

            if( contenedorMadre.getChildren().size() >= 2 )
            {
                double tamanio_x = contenedorMadre.getPrefWidth();
                double tamanio_y = contenedorMadre.getPrefHeight();

                contenedorMadre.setMinSize( tamanio_x - 50, tamanio_y - 45 );
                contenedorMadre.setPrefSize( tamanio_x - 50, tamanio_y - 45 );
            }

            contenedorMadre.getChildren().remove(contenedorBloqueRepeticion);
            sectorBloquesDisponibles.notificarObservador(contenedorMadre);

            this.reproducirSonido();
        });
    }

    private void reproducirSonido() {
        String musicFile = "src/main/java/edu/fiuba/algo3/interfaz/musica/borrar_bloque.mp3";
        Media musica = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();
    }

    private void crearMenu(SectorAlgoritmo sector, MouseEvent mouseEvent, EventHandler<ActionEvent> handler) {
        ContextMenu menu = new ContextMenu();
        MenuItem borrar = new MenuItem("BORRAR");
        MenuItem cancelar = new MenuItem("CANCELAR");

        menu.getItems().addAll(borrar, cancelar);
        menu.show(sector, mouseEvent.getScreenX(), mouseEvent.getScreenY());
        cancelar.setOnAction(evento -> menu.hide());
        borrar.setOnAction( handler );
    }
}
