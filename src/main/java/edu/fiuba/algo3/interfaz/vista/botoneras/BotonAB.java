package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.ContenedorRepeticion;
import edu.fiuba.algo3.interfaz.controladores.HabilidadDragHandler;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.modelo.bloques.Bloque;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class BotonAB extends Button {

    String RUTA_ICONOS = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/";

    public BotonAB(String nombre_boton, String icono) {
        super(nombre_boton);

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

    public abstract void crearBloqueEnSectorAlgoritmo(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles);

    public abstract void crearBloqueAdentroDeUnContenedor(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles, BotonAB creador);

    public abstract Bloque obtenerBloque();

    public abstract void agregarObservador(ContenedorRepeticion obs);

    public abstract void notificarObservador(double x, double y, int hijos);
}
