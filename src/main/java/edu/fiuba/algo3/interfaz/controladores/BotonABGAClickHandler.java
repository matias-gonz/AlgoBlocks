package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.SectorBloquesDisponibles;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonGAPersonalizado;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonABGAClickHandler extends Stage implements EventHandler<MouseEvent> {

    VBox contenendorAlgoritmo;
    SectorBloquesDisponibles botoneraSectorBloquesDisponibles;

    public BotonABGAClickHandler(VBox contenendorAlgoritmo, SectorBloquesDisponibles botoneraSectorBloquesDisponibles) {
        this.contenendorAlgoritmo = contenendorAlgoritmo;
        this.botoneraSectorBloquesDisponibles = botoneraSectorBloquesDisponibles;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Label informacion = new Label("Ingrese un nombre al algoritmo a guardar");
        TextField texto = new TextField();
        Button aceptar = new Button("Aceptar");
        Button cancelar = new Button( "Cancelar" );

        VBox menu = new VBox(informacion, texto);
        menu.setAlignment(Pos.BASELINE_CENTER);

        HBox opciones = new HBox(aceptar, cancelar);
        opciones.setAlignment( Pos.BASELINE_CENTER );

        menu.getChildren().addAll(opciones);

        Scene escena = new Scene(menu, 390, 80);

        this.resizableProperty().set(false);

        cancelar.setOnAction( e-> {
            this.hide();
            this.requestFocus();
        });

        aceptar.setOnAction( e-> {

            if( texto.getText().trim().equals("") )
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("[ALGOBLOCKS] Alerta!");
                alert.setHeaderText("ERROR");
                alert.setContentText("NOMBRE ERRONEO!");
                alert.showAndWait();
                return;
            }

            // este boton debería tener la info de los hijos de this.contenedorAlgoritmo (es pasada por parámetro).
            // y bueno, el nombre escrito en el texto.
            BotonGAPersonalizado botonPersonalizado = new BotonGAPersonalizado( texto, this.contenendorAlgoritmo, botoneraSectorBloquesDisponibles);
            this.botoneraSectorBloquesDisponibles.getChildren().add(botonPersonalizado);
            this.botoneraSectorBloquesDisponibles.notificarObservador(this.contenendorAlgoritmo);

            // this.contenendorAlgoritmo.getChildren() tiene los Bloques que hay que ejecutarse!

            this.hide();
        });

        this.setTitle("Guardar algoritmo");

        escena.setOnKeyPressed( e ->
        {
            switch( e.getCode() )
            {
                case ENTER:
                    aceptar.fire();
                    break;

                case ESCAPE:
                    cancelar.fire();
                    break;

            }
        });

        this.setScene(escena);

        this.show();
    }

}
