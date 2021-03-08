package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class VistaLinea implements Observador {
    private static final int ESCALAR = 30;
    Rango rango;
    Dibujo dibujo;
    int tamAnterior = 0;
    int siguienteLinea;
    Line line;
    SectorDibujo sectorDibujo;
    List<Line> lineasTrazadas = new ArrayList<>();


    public VistaLinea(Dibujo dibujo, SectorDibujo sectorDibujo) {
        this.dibujo = dibujo;
        this.rango = new Rango();
        this.dibujo.agregarObservador(this);
        this.sectorDibujo = sectorDibujo;
    }

    public void update() {

        if (dibujo.obtenerSectorDibujado().size() != 0 && dibujo.obtenerSectorDibujado().size() > tamAnterior) {

            siguienteLinea = dibujo.obtenerSectorDibujado().size() - 1;
            List<Integer> PosInicial = dibujo.obtenerSectorDibujado().get(siguienteLinea).obtenerCoordenadasPosicionInicial();
            List<Integer> PosFinal = dibujo.obtenerSectorDibujado().get(siguienteLinea).obtenerCoordenadasPosicionFinal();

            line = new Line(230 + PosInicial.get(0) * ESCALAR, 242 - PosInicial.get(1) * ESCALAR,
                    230 + PosFinal.get(0) * ESCALAR, 242 - PosFinal.get(1) * ESCALAR);

            line.setStrokeWidth(5);
            this.verificarRango(line);

            sectorDibujo.getChildren().add(line);
            tamAnterior = dibujo.obtenerSectorDibujado().size();
            sectorDibujo.getChildren().get(sectorDibujo.getChildren().size()-1).toBack();
            siguienteLinea++;
            lineasTrazadas.add(line);
        }
    }

    public void reset(){
        this.line = new Line();
        tamAnterior = 0;
        siguienteLinea = 0;

        lineasTrazadas.forEach(lineas -> lineas.setStroke(Color.TRANSPARENT));
    }

    public void verificarRango(Line line){ if(excedeRango(line)) line.setStroke(Color.TRANSPARENT); }

    public boolean excedeRango(Line line){
        rango.setAltura(sectorDibujo.getHeight());
        rango.setAncho(sectorDibujo.getWidth());
        return (rango.esExcedido( line.getEndX(), line.getEndY()));
    }
}





