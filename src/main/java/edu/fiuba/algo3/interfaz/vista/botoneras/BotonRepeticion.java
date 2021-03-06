package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.ContenedorRepeticion;
import edu.fiuba.algo3.interfaz.ContenedorBloque;
import edu.fiuba.algo3.interfaz.controladores.HabilidadDragHandler;
import edu.fiuba.algo3.interfaz.controladores.MenuContextoEnContenedorHandler;
import edu.fiuba.algo3.interfaz.controladores.MenuContextoHandler;
import edu.fiuba.algo3.interfaz.controladores.botones.ControladorBoton;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.modelo.bloques.Bloque;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BotonRepeticion extends BotonBloque {
    String RUTA_ICONOS = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/";
    String nombre;
    String icono;
    ControladorBoton controladorBoton;

    public BotonRepeticion(String nombre_boton, String icono, ControladorBoton controlador) {
//        super(nombre_boton);
        this.controladorBoton = controlador;
        this.nombre = nombre_boton;
        this.icono = icono;

        ImageView icon = new ImageView(RUTA_ICONOS + icono);
        this.setMaxSize(100, 100);
        this.setMinSize(55, 55);
        this.setTooltip(new Tooltip(nombre_boton));
        this.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setGraphic(icon);

        this.setOnDragDetected(new HabilidadDragHandler(this, nombre_boton, TransferMode.ANY, icono));
    }

    @Override
    public void crearBloqueEnSectorAlgoritmo(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles) {
        BotonRepeticion boton = new BotonRepeticion(this.nombre, this.icono, this.controladorBoton);
        boton.setOnDragDetected(null); // no se mueve
        boton.setOnMouseClicked(new MenuContextoHandler(boton, sector, contenedor, sectorBloquesDisponibles));
        ContenedorRepeticion contenedorRepeticion = new ContenedorRepeticion(boton, contenedor, sectorBloquesDisponibles, sector);
        sectorBloquesDisponibles.notificarObservador(contenedor);
    }

    public void crearBloqueAdentroDeUnContenedor(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles, BotonBloque creador) {
        BotonRepeticion boton = new BotonRepeticion(this.nombre, this.icono, this.controladorBoton);
        boton.setOnDragDetected(null); // no se mueve
        boton.setOnMouseClicked(new MenuContextoEnContenedorHandler(boton, sector, contenedor, sectorBloquesDisponibles, creador));

        ContenedorRepeticion contenedorRepeticion = new ContenedorRepeticion(boton, contenedor, sectorBloquesDisponibles, sector);
        creador.notificarObservador(0, 45, 0);
    }

    public Bloque obtenerBloque(ObservableList<Node> hijos) {
        return controladorBoton.obtenerAccion(hijos);
    }

    public void agregarObservador(ContenedorRepeticion obs) {

    }

    public void notificarObservador(double x, double y, int hijos) {

    }
}