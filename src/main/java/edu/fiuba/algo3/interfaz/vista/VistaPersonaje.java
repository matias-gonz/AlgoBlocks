package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaPersonaje implements Observador {

    private static final int POS_INICIAL_CENTER_X = 228;
    private static final int POS_INICIAL_CENTER_Y = 215;
    private static final int ESCALAR = 30;
    private final ImageView imagenPersonaje;
    private final Personaje personaje;
    public enum Direccion{ NORTE, SUR, ESTE, OESTE}
    private Direccion direccionActual;
    private Posicion posicionAnterior = new Posicion(0,0);
    private final SectorDibujo sectorDibujo;
    private final Rango rango;

    private static final String PERSONAJE_DERECHA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeRight.png";
    private static final String PERSONAJE_IZQUIERDA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeLeft.png";
    private static final String PERSONAJE_ARRIBA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeUp.png";
    private static final String PERSONAJE_ABAJO = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeDown.png";

    public VistaPersonaje(ImageView imagenPersonaje, SectorDibujo sectorDibujo, Personaje personaje){
        this.personaje = personaje;
        this.imagenPersonaje = imagenPersonaje;
        this.sectorDibujo = sectorDibujo;
        this.rango = new Rango();
        this.setDireccionActual(VistaPersonaje.Direccion.ESTE);
        imagenPersonaje.setX(POS_INICIAL_CENTER_X);
        imagenPersonaje.setY(POS_INICIAL_CENTER_Y);
        imagenPersonaje.setFitHeight(35);
        imagenPersonaje.setFitWidth(30);
        this.personaje.agregarObservador(this);
        sectorDibujo.getChildren().add(imagenPersonaje);
    }

    public void girarPersonaje() {
        actualizarDireccion();
        switch (direccionActual){
            case NORTE:
                imagenPersonaje.setImage(new Image(PERSONAJE_ARRIBA));
                break;
            case SUR:
                imagenPersonaje.setImage(new Image(PERSONAJE_ABAJO));
                break;
            case ESTE:
                imagenPersonaje.setImage(new Image(PERSONAJE_DERECHA));
                break;
            case OESTE:
                imagenPersonaje.setImage(new Image(PERSONAJE_IZQUIERDA));
        }

    }

    public void update(){
        this.girarPersonaje();

        imagenPersonaje.setY(POS_INICIAL_CENTER_Y - (personaje.obtenerPosicion().get(1) * ESCALAR));
        imagenPersonaje.setX(POS_INICIAL_CENTER_X + (personaje.obtenerPosicion().get(0) * ESCALAR));

        verificarFueraDeRango();
    }

    public void setDireccionActual(VistaPersonaje.Direccion dir){
        direccionActual = dir;
    }

    public void actualizarDireccion(){
        int anteriorX = posicionAnterior.obtenerCoordenadas().get(0);
        int anteriorY = posicionAnterior.obtenerCoordenadas().get(1);
        int actualX = personaje.obtenerPosicion().get(0);
        int actualY = personaje.obtenerPosicion().get(1);

        if(anteriorY < actualY){
            this.setDireccionActual(VistaPersonaje.Direccion.NORTE);
        }else if (anteriorY > actualY){
            this.setDireccionActual(VistaPersonaje.Direccion.SUR);
        }else if ( anteriorX < actualX){
            this.setDireccionActual(VistaPersonaje.Direccion.ESTE);
        }else if( anteriorX > actualX){
            this.setDireccionActual(VistaPersonaje.Direccion.OESTE);
        }

        posicionAnterior = new Posicion(personaje.obtenerPosicion());
    }


    public void verificarFueraDeRango(){
        if(excedeRango()) imagenPersonaje.setImage(null);
    }

    public boolean excedeRango(){
        rango.setAltura(sectorDibujo.getHeight()-16);
        rango.setAncho(sectorDibujo.getWidth()-20);

        return (rango.esExcedido( imagenPersonaje.getX(), imagenPersonaje.getY()));
    }

}
