package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.ObservableSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonClear;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonEjecutar;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class SectorDibujo extends Pane implements ObservableSectorAlgoritmo {
    private final Personaje personaje;
    private VistaLinea vistaLinea;
    private final Dibujo dibujo;
    private final ArrayList<ObservadorSectorAlgoritmo> observador;
    BotonEjecutar boton;
    BotonClear botonClear;
    SliderVelocidad slider;

    public SectorDibujo(Personaje personaje, Dibujo dibujo) {
        this.personaje = personaje;
        this.dibujo = dibujo;
        slider = new SliderVelocidad();
        boton = new BotonEjecutar(personaje, this, dibujo,slider);
        botonClear = new BotonClear(boton);



        this.setPrefSize(486,700);
        this.setMaxHeight(500);
        this.setMinHeight(515);
        clean();

        observador = new ArrayList<>();
        this.agregarObservador( boton);
        this.getChildren().add( boton );
        this.agregarObservador( botonClear);
        this.getChildren().add( botonClear );
        this.getChildren().add( slider );
    }

    public void clean(){
        ImageView imagenPersonaje = new ImageView("file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeRight.png");
        VistaPersonaje vistaPersonaje = new VistaPersonaje(imagenPersonaje, this, personaje);
        vistaLinea = new VistaLinea(dibujo, this);
        BackgroundImage fondoImagen = new BackgroundImage(new Image("file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/fondoSectorDibujo.png"),
                BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        this.setBackground(fondo);
    }

    public void reset(){
        this.dibujo.reset();
        this.personaje.reset();
        this.vistaLinea.reset();

    }

    @Override
    public void agregarObservador(ObservadorSectorAlgoritmo observador) {
        this.observador.add(observador);
    }

    @Override
    public void notificarObservador(VBox nuevoContenedor) {
        this.observador.forEach( obs -> obs.cambios(nuevoContenedor) );
    }

    public void ejecutarBloques() {
        for( Node i : this.getChildren()){
            if(i instanceof BotonEjecutar){
                ((BotonEjecutar) i).fire();
            }
        }


    }

    public void clearBloques() {
        for( Node i : this.getChildren()){
            if(i instanceof BotonClear){
                ((BotonClear) i).fire();
            }
        }
    }
}