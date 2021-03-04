package edu.fiuba.algo3.interfaz;
/*
import edu.fiuba.algo3.interfaz.controladores.HabilidadAceptarDragHandler;
import edu.fiuba.algo3.interfaz.controladores.HabilidadDropHandler;
import edu.fiuba.algo3.interfaz.controladores.MenuContextoEnContenedorHandler;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Contenedor implements ObservadorContenedor {

    VBox contenedorAEjecutar = new VBox();
    HBox item = new HBox();

    double TAMANIO_X = 115;
    double TAMANIO_Y = 70;
    double sizeX = TAMANIO_X;
    double sizeY = TAMANIO_Y;
    int cantidadHijos = 0;

    public Contenedor(CreadorDeTipoDeBloque creadorDeTipoDeBloque, String nombre, VBox contenedor, SectorBloquesDisponibles sectorBloquesDisponibles, SectorAlgoritmo sector, String icono)
    {
        item.setId(nombre);
        contenedorAEjecutar.setPrefSize( TAMANIO_X, TAMANIO_Y );
        contenedorAEjecutar.setAlignment( Pos.TOP_CENTER );

        contenedorAEjecutar.setBorder(new Border(new BorderStroke(Color.ROYALBLUE,
                BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        contenedorAEjecutar.setBackground(new Background(new BackgroundFill(Color.HOTPINK, CornerRadii.EMPTY, Insets.EMPTY)));

        contenedorAEjecutar.setOnDragOver( new HabilidadAceptarDragHandler(TransferMode.ANY) );
        contenedorAEjecutar.setOnDragDropped( new HabilidadDropHandler(sector, contenedorAEjecutar, sectorBloquesDisponibles, creadorDeTipoDeBloque) );

        if( nombre.contains("Repetir") ) {
            ComboBox<Integer> comboBox = new ComboBox<>();
            comboBox.getItems().add(2);
            comboBox.getItems().add(3);
            comboBox.getSelectionModel().selectFirst();
            comboBox.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
            comboBox.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            contenedorAEjecutar.getChildren().add(comboBox);
        }

        //BotonAB boton = new BotonAB( nombre, icono );
        //boton.setOnDragDetected( null );

        //item.getChildren().addAll(boton, contenedorAEjecutar);

        //boton.setOnMouseClicked( new MenuContextoEnContenedorHandler(contenedor, sector, item, sectorBloquesDisponibles, creadorDeTipoDeBloque) );
        item.setOnMouseClicked( new MenuContextoEnContenedorHandler(contenedor, sector, item, sectorBloquesDisponibles, creadorDeTipoDeBloque) );
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
}
*/
