package edu.fiuba.algo3.interfaz.vista;

import javafx.scene.control.Slider;

public class SliderVelocidad extends Slider {

    public SliderVelocidad() {
        this.setLayoutX(30);
        this.setLayoutY(570);
        this.setPrefWidth(212);

        this.setMin(0);
        this.setMax(5);
    }

    public Double obtenerVelocidad() {
        System.out.println(this.getValue());
        return this.getValue();
    }
}
