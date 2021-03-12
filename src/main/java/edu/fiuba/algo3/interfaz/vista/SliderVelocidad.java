package edu.fiuba.algo3.interfaz.vista;

import javafx.scene.control.Slider;

public class SliderVelocidad extends Slider {

    public SliderVelocidad() {
        this.setLayoutX(30);
        this.setLayoutY(570);
        this.setPrefWidth(212);

        this.setMin(0);
        this.setMax(1.99);
        this.setValue(1.5);
        this.setStyle("-fx-background-color: #ff9900;" +
                "-fx-padding: 0.3em;");
    }

    public Double obtenerVelocidad() {
        return (2- this.getValue());
    }
}
