package edu.fiuba.algo3.interfaz.vista.contenedores;

import edu.fiuba.algo3.interfaz.controladores.MenuContexto.MenuContextoParaContenedores;
import edu.fiuba.algo3.interfaz.controladores.HabilidadAceptarDragHandler;
import edu.fiuba.algo3.interfaz.controladores.HabilidadDropHandler;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonRepeticion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ContenedorRepeticion  {

    VBox contenedorAEjecutar = new VBox();
    ContenedorBloque item = new ContenedorBloque();

    double TAMANIO_X = 115;
    double TAMANIO_Y = 70;

    public ContenedorRepeticion(BotonRepeticion botonRepeticion, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles, SectorAlgoritmo sector) {

        contenedorAEjecutar.setPrefSize( TAMANIO_X, TAMANIO_Y );
        contenedorAEjecutar.setAlignment( Pos.TOP_CENTER );

        contenedorAEjecutar.setBorder(new Border(new BorderStroke(Color.ROYALBLUE,
                    BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        contenedorAEjecutar.setBackground(new Background(new BackgroundFill(Color.HOTPINK, CornerRadii.EMPTY, Insets.EMPTY)));

        contenedorAEjecutar.setOnDragOver( new HabilidadAceptarDragHandler(TransferMode.ANY) );
        contenedorAEjecutar.setOnDragDropped( new HabilidadDropHandler(sector, contenedorAEjecutar, sectorBloquesDisponibles, botonRepeticion) );

        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.getItems().add(2);
        comboBox.getItems().add(3);
        comboBox.getSelectionModel().selectFirst();
        comboBox.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
        comboBox.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        contenedorAEjecutar.getChildren().add(comboBox);

        item.getChildren().addAll(botonRepeticion,contenedorAEjecutar);

        item.setAlignment(Pos.CENTER);
        contenedor.getChildren().add(item);

        botonRepeticion.setOnMouseClicked( new MenuContextoParaContenedores(sector, contenedor, sectorBloquesDisponibles, item) );
    }
}
