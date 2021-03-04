package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaPersonaje {

    private static final int POS_INICIAL_CENTER = 180;
    private ImageView imagenPersonaje;
    private Personaje personaje;
    public enum Direccion{ NORTE, SUR, ESTE, OESTE}
    private Direccion direccionActual;
    private Posicion posicionAnterior = new Posicion(0,0);

    private static final String PERSONAJE_DERECHA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeRight.png";
    private static final String PERSONAJE_IZQUIERDA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeLeft.png";
    private static final String PERSONAJE_ARRIBA = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeUp.png";
    private static final String PERSONAJE_ABAJO = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeDown.png";

    public VistaPersonaje(ImageView imagenPersonaje, SectorDibujo sectorDibujo, Personaje personaje){
        this.personaje = personaje;
        this.imagenPersonaje = imagenPersonaje;
        this.setDireccionActual(VistaPersonaje.Direccion.ESTE);
        imagenPersonaje.setX(180);
        imagenPersonaje.setY(180);
        imagenPersonaje.setFitHeight(35);
        imagenPersonaje.setFitWidth(30);
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
    //Se resta a la coordenada Y, pq en este SC esta invertido,
    public void updateVistaPersonaje( ) {
        this.girarPersonaje();
        imagenPersonaje.setY(POS_INICIAL_CENTER - (personaje.obtenerPosicion().get(1) * 20));
        imagenPersonaje.setX(POS_INICIAL_CENTER + (personaje.obtenerPosicion().get(0) * 20));
    }


    public void setDireccionActual(VistaPersonaje.Direccion dir){
        direccionActual = dir;
    }
    //chekear porque no se me ocurre otra forma para guardar direccion
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


}
