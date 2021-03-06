package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.controladores.HabilidadAceptarDragHandler;
import edu.fiuba.algo3.interfaz.controladores.HabilidadDropHandler;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonInversion;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonRepeticion;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ContenedorInversion implements ObservadorContenedor {

    VBox contenedorAEjecutar = new VBox();
    ContenedorBloque item = new ContenedorBloque();

    double TAMANIO_X = 115;
    double TAMANIO_Y = 70;
    double sizeX = TAMANIO_X;
    double sizeY = TAMANIO_Y;
    int cantidadHijos = 0;

    public ContenedorInversion(BotonInversion botonRepeticion, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles, SectorAlgoritmo sector) {

        contenedorAEjecutar.setPrefSize( TAMANIO_X, TAMANIO_Y );
        contenedorAEjecutar.setAlignment( Pos.TOP_CENTER );

        contenedorAEjecutar.setBorder(new Border(new BorderStroke(Color.ROYALBLUE,
                BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        contenedorAEjecutar.setBackground(new Background(new BackgroundFill(Color.HOTPINK, CornerRadii.EMPTY, Insets.EMPTY)));

        contenedorAEjecutar.setOnDragOver( new HabilidadAceptarDragHandler(TransferMode.ANY) );
        contenedorAEjecutar.setOnDragDropped( new HabilidadDropHandler(sector, contenedorAEjecutar, sectorBloquesDisponibles, botonRepeticion) );

        item.getChildren().addAll(botonRepeticion,contenedorAEjecutar);

        //BotonABRepeticion boton = new BotonABRepeticion();
        // boton.setOnDragDetected( null );

        //  item.getChildren().addAll(boton, contenedorAEjecutar);

        //boton.setOnMouseClicked( new MenuContextoEnContenedorHandler(contenedor, sector, item, sectorBloquesDisponibles, botonABRepeticion) );
        //item.setOnMouseClicked( new MenuContextoEnContenedorHandler(contenedor, sector, item, sectorBloquesDisponibles, botonRepeticion) );
        item.setAlignment(Pos.CENTER);
        contenedor.getChildren().add(item);
    }

    @Override
    public void cambios(double x, double y, int hijos) {
        if( cantidadHijos >= 2 )
            return;

        cantidadHijos += hijos;
        sizeX += x;
        sizeY += y;
        this.contenedorAEjecutar.setPrefSize(sizeX, sizeY);
    }

    public ObservableList<Node> obtenerHijos() {
        System.out.println("HIJOS= " + contenedorAEjecutar.getChildren().size());
        return contenedorAEjecutar.getChildren();
    }
}