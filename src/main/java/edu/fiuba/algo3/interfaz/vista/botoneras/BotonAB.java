package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.vista.contenedores.ContenedorBloque;
import edu.fiuba.algo3.interfaz.controladores.HabilidadDragHandler;
import edu.fiuba.algo3.interfaz.controladores.MenuContexto.MenuContextoEnContenedorHandler;
import edu.fiuba.algo3.interfaz.controladores.MenuContexto.MenuContextoHandler;
import edu.fiuba.algo3.interfaz.controladores.botones.ControladorBoton;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.modelo.bloques.Bloque;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BotonAB extends BotonBloque {
    String RUTA_ICONOS = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/";
    String nombre;
    String icono;
    ControladorBoton controladorBoton;

    public BotonAB(String nombre_boton, String icono, ControladorBoton controlador) {
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

        this.setOnDragDetected(new HabilidadDragHandler(this, TransferMode.ANY));
    }

    @Override
    public void crearBloqueEnSectorAlgoritmo(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles){
        BotonAB boton = new BotonAB(this.nombre,this.icono,this.controladorBoton);
        boton.setOnDragDetected(null); // no se mueve
        ContenedorBloque contenedorBloque = new ContenedorBloque();
        boton.setOnMouseClicked( new MenuContextoHandler(sector, contenedorBloque, sectorBloquesDisponibles, contenedor) );

        contenedorBloque.getChildren().add(boton);
        contenedorBloque.setAlignment(Pos.CENTER);
        contenedor.getChildren().add(contenedorBloque);

        sectorBloquesDisponibles.notificarObservador(contenedor);
    }

    public void crearBloqueAdentroDeUnContenedor(SectorAlgoritmo sector, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles, BotonBloque creador){
        BotonAB boton = new BotonAB(this.nombre,this.icono,this.controladorBoton);
        boton.setOnDragDetected(null); // no se mueve
        ContenedorBloque contenedorBloque = new ContenedorBloque();

        boton.setOnMouseClicked( new MenuContextoEnContenedorHandler(sector, contenedorBloque, contenedor) );

        contenedorBloque.getChildren().add(boton);
        contenedorBloque.setAlignment(Pos.CENTER);
        contenedor.getChildren().add(contenedorBloque);

        double tamanio_x = contenedor.getPrefWidth();
        double tamanio_y = contenedor.getPrefHeight();

        contenedor.setMaxSize( tamanio_x , tamanio_y + 60 );
        contenedor.setMinSize( tamanio_x , tamanio_y + 60 );
        contenedor.setPrefSize(tamanio_x , tamanio_y + 60 );
    }

    public Bloque obtenerBloque(ObservableList<Node> hijos){
        return controladorBoton.obtenerAccion(hijos);
    }
}
