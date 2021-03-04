package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.SectorDibujo;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.bloques.BloqueMovimiento;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MovimientoEventHandler implements EventHandler<ActionEvent> {

    private BloqueMovimiento bloqueMovimiento;
    private SectorDibujo sectorDibujo;
    private Personaje personaje;

    public MovimientoEventHandler(BloqueMovimiento bloqueMovimiento, SectorDibujo sectorDibujo, Personaje personaje) {
        this.personaje = personaje;
        this.bloqueMovimiento = bloqueMovimiento;
        this.sectorDibujo = sectorDibujo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        bloqueMovimiento.ejecutar(personaje, new Dibujo());
        sectorDibujo.update();
    }

}
