package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class VistaLinea {
    private static final int ESCALAR = 30;
    Rango rango;
    Dibujo dibujo;
    int tamAnterior = 0;
    Line line;
    VistaPersonaje vistaPersonaje;
    SectorDibujo sectorDibujo;
    List<Line> lineas = new ArrayList<>();


    public VistaLinea(Dibujo dibujo, VistaPersonaje vistaPersonaje, SectorDibujo sectorDibujo) {
        this.dibujo = dibujo;
        this.rango = new Rango();
        this.vistaPersonaje = vistaPersonaje;
        this.sectorDibujo = sectorDibujo;
    }

    public void dibujar() {

        if (dibujo.obtenerSectorDibujado().size() != 0 && dibujo.obtenerSectorDibujado().size() > tamAnterior) {

            Posicion posInicial = vistaPersonaje.getPosAnterior();
            Posicion posFinal = vistaPersonaje.getPosActual();

            line = new Line(ESCALAR + posInicial.obtenerCoordenadas().get(0), ESCALAR + posInicial.obtenerCoordenadas().get(1),
                    ESCALAR + posFinal.obtenerCoordenadas().get(0), ESCALAR + posFinal.obtenerCoordenadas().get(1));

            line.setStrokeWidth(5);
            this.verificarRango(line);
            sectorDibujo.getChildren().add(line);
            tamAnterior = dibujo.obtenerSectorDibujado().size();

            lineas.add(line);
        }else if (dibujo.obtenerSectorDibujado().size() == 0){
            reset();
        }
    }

    public void reset(){
        this.line = new Line();
        tamAnterior = 0;
        dibujo.reset();
        lineas.forEach( lineas -> lineas.setStroke(Color.TRANSPARENT));
    }

    public void verificarRango(Line line){ if(excedeRango(line)) line.setStroke(Color.TRANSPARENT); }

    public boolean excedeRango(Line line){
        rango.setAltura(sectorDibujo.getHeight());
        rango.setAncho(sectorDibujo.getWidth());
        return (rango.esExcedido( line.getEndX(), line.getEndY()));
    }
}





