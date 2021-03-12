package edu.fiuba.algo3.interfaz.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Titulo extends Label{

    public Titulo(String titulo) {
        this.setText(titulo);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setAlignment(Pos.CENTER);
        this.setTextFill(Color.WHITE);
        this.setStyle("-fx-background-color: rgb(85,40,129);");
        this.setFont(Font.font("Times",20));
    }
}
