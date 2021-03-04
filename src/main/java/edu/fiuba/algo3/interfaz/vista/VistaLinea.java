package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class VistaLinea {
    private static final int POS_INICIAL_CENTER = 200;
    Dibujo dibujo;
    int siguienteLinea = 0;
    int tamAnterior = 0;
    Line line;
    List<Line> lineas = new ArrayList<>();


    public VistaLinea(Dibujo dibujo) {
        this.dibujo = dibujo;
    }

    public void updateVistaLinea(SectorDibujo sectorDibujo) {

        if (dibujo.obtenerSectorDibujado().size() != 0 && dibujo.obtenerSectorDibujado().size() >= tamAnterior) {
            siguienteLinea = dibujo.obtenerSectorDibujado().size() - 1;
            List<Integer> PosInicial = dibujo.obtenerSectorDibujado().get(siguienteLinea).obtenerCoordenadasPosicionInicial();
            List<Integer> PosFinal = dibujo.obtenerSectorDibujado().get(siguienteLinea).obtenerCoordenadasPosicionFinal();
            line = new Line(215 + PosInicial.get(0) * 10, 235 - PosInicial.get(1) * 20, 250 + PosFinal.get(0) * 10, 235 - PosFinal.get(1) * 20);
            line.setStrokeWidth(5);
            sectorDibujo.getChildren().add(line);
            tamAnterior = dibujo.obtenerSectorDibujado().size();

            lineas.add(line);
        }
    }

    public void reset(){
        this.line = new Line();
        siguienteLinea = 0;
        tamAnterior = 0;
        lineas.forEach( lineas -> lineas.setStroke(Color.TRANSPARENT));
    }
}


