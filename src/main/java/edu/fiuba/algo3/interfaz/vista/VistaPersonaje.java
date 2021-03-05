package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.ObservadorPersonaje;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaPersonaje implements ObservadorPersonaje {

    private static final int POS_INICIAL_CENTER = 180;
    private static final int ESCALAR = 40;
    private static final int ESCALAR_Y = 16;
    private static final int ESCALAR_X= 20;
    private final ImageView imagenPersonaje;
    private final Personaje personaje;
    public enum Direccion{ NORTE, SUR, ESTE, OESTE}
    private Direccion direccionActual;
    private Posicion posicionAnterior = new Posicion(0,0);
    private Posicion imagenPosicionAnterior;
    private VistaLinea vistaLinea;
    private Posicion imagenPosicionActual;
    private SectorDibujo sectorDibujo;
    private Rango rango;

    private static final String PERSONAJE_DERECHA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeRight.png";
    private static final String PERSONAJE_IZQUIERDA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeLeft.png";
    private static final String PERSONAJE_ARRIBA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeUp.png";
    private static final String PERSONAJE_ABAJO = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeDown.png";

    public VistaPersonaje(ImageView imagenPersonaje, SectorDibujo sectorDibujo, Personaje personaje, Dibujo dibujo){
        this.personaje = personaje;
        this.imagenPersonaje = imagenPersonaje;
        this.sectorDibujo = sectorDibujo;
        this.rango = new Rango();
        vistaLinea = new VistaLinea(dibujo, this, sectorDibujo);
        this.setDireccionActual(VistaPersonaje.Direccion.ESTE);
        imagenPersonaje.setX(POS_INICIAL_CENTER);
        imagenPersonaje.setY(POS_INICIAL_CENTER);
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
        imagenPosicionAnterior = new Posicion((int)imagenPersonaje.getX(),(int) imagenPersonaje.getY());

        imagenPersonaje.setY(POS_INICIAL_CENTER - (personaje.obtenerPosicion().get(1) * ESCALAR));
        imagenPersonaje.setX(POS_INICIAL_CENTER + (personaje.obtenerPosicion().get(0) * ESCALAR));

        imagenPosicionActual = new Posicion((int)imagenPersonaje.getX(), (int)imagenPersonaje.getY());

        verificarFueraDeRango();
        vistaLinea.dibujar();
    }

    public void setDireccionActual(VistaPersonaje.Direccion dir){
        direccionActual = dir;
    }

    public void actualizarDireccion(){
        if(posicionAnterior.obtenerCoordenadas().get(1) < personaje.obtenerPosicion().get(1)){
            this.setDireccionActual(VistaPersonaje.Direccion.NORTE);
        }else if (posicionAnterior.obtenerCoordenadas().get(1) > personaje.obtenerPosicion().get(1)){
            this.setDireccionActual(VistaPersonaje.Direccion.SUR);
        }else if ( posicionAnterior.obtenerCoordenadas().get(0) < personaje.obtenerPosicion().get(0)){
            this.setDireccionActual(VistaPersonaje.Direccion.ESTE);
        }else if( posicionAnterior.obtenerCoordenadas().get(0) > personaje.obtenerPosicion().get(0)){
            this.setDireccionActual(VistaPersonaje.Direccion.OESTE);
        }

        posicionAnterior = new Posicion(personaje.obtenerPosicion());
    }

    public Posicion getPosActual(){ return imagenPosicionActual; }

    public Posicion getPosAnterior(){ return imagenPosicionAnterior; }

    public void verificarFueraDeRango(){
        if(excedeRango()) imagenPersonaje.setImage(null);
    }

    public boolean excedeRango(){
        rango.setAltura(sectorDibujo.getHeight());
        rango.setAncho(sectorDibujo.getWidth());
        return (rango.esExcedido( imagenPersonaje.getX() + ESCALAR_X, imagenPersonaje.getY()+ ESCALAR_Y));
    }

}
