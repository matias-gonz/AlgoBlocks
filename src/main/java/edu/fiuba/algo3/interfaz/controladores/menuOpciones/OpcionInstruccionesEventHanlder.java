package edu.fiuba.algo3.interfaz.controladores.menuOpciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OpcionInstruccionesEventHanlder implements EventHandler<ActionEvent> {
    private ImageView imagen;

    @Override
    public void handle(ActionEvent actionEvent) {

        String rutaIcono = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personaje.png";

        imagen = new ImageView( rutaIcono);

        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle( "Instrucciones" );
        stage.getIcons().add(new Image(rutaIcono));

        VBox menu = new VBox();
        menu.setAlignment(Pos.BASELINE_CENTER);
        Label mensajeInicial = new Label("Este es un nuevo tipo de desafío llamado Artista.");
        Label mensajeInicialDos = new Label("Jugá con los bloques y dibujá algo divertido!");
        menu.getChildren().addAll(mensajeInicial,mensajeInicialDos);
        menu.getChildren().addAll(new Label(" "), new Separator(),imagen,new Separator());

        Label instruccionBloques = new Label("Cada bloque en el sector de Bloques Disponibles tiene una función.");
        Label instruccionesExperimenta = new Label("Experimentá con cada uno y diseñá tus propios algoritmos!");
        Label instruccionArrastrar = new Label("Podés arrastrar cada bloque al sector Algoritmo.");
        Label instruccionEjecutar = new Label("Luego podés ejecutar tu algoritmo presionando el botón 'Ejecutar'.");
        menu.getChildren().addAll(instruccionBloques,instruccionesExperimenta,instruccionArrastrar,instruccionEjecutar);
        menu.getChildren().addAll(new Label(" "), new Separator());

        Label shortcuts = new Label("Shortcuts:");
        Label shortcutMusica = new Label("M: Activar/Desactivar Musica\n");
        Label shortcutEjecutar = new Label("E: Ejecutar Algoritmo\n");
        Label shortcutLimpiar = new Label("D: Limpiar Algoritmo\n");
        Label shortcutGuardar = new Label("G: Guardar Algoritmo\n");
        Label shortcutInstrucciones = new Label("I: Mostrar Instrucciones\n");

        menu.getChildren().addAll(shortcuts,shortcutMusica,shortcutEjecutar,shortcutLimpiar,shortcutGuardar,shortcutInstrucciones);

        Scene escena = new Scene(menu, 390, 380);
        stage.setScene(escena);
        stage.show();

    }
}