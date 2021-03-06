package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.ObservableSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonClear;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonEjecutar;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class SectorDibujo extends Pane implements ObservableSectorAlgoritmo {
    private Personaje personaje;
    private ImageView imagenPersonaje;
    private VistaPersonaje vistaPersonaje;
    private Dibujo dibujo;
    private ArrayList<ObservadorSectorAlgoritmo> observador;
    BotonEjecutar boton;
    BotonClear botonClear;

    public SectorDibujo(Personaje personaje, Dibujo dibujo) {
        this.personaje = personaje;
        this.dibujo = dibujo;
        boton = new BotonEjecutar(personaje, this, dibujo);
        botonClear = new BotonClear();
        this.setPrefSize(500,700);
        this.setMaxHeight(500);
        this.setMinHeight(500);
        clean();

        observador = new ArrayList<>();
        this.agregarObservador( boton);
        this.getChildren().add( boton );
        this.agregarObservador( botonClear);
        this.getChildren().add( botonClear );
    }

    public void clean(){
        imagenPersonaje = new ImageView( "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeRight.png");
        vistaPersonaje = new VistaPersonaje(imagenPersonaje, this, personaje, dibujo);
        BackgroundImage fondoImagen = new BackgroundImage(new Image("file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/fondoSectorDibujo.png"),
                BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        this.setBackground(fondo);
    }

    public void reset(){
        this.dibujo.reset();
        this.personaje.reset();
    }

    @Override
    public void agregarObservador(ObservadorSectorAlgoritmo observador) {
        this.observador.add(observador);
    }

    @Override
    public void notificarObservador(VBox nuevoContenedor) {
        this.observador.forEach( obs -> obs.cambios(nuevoContenedor) );
    }
}