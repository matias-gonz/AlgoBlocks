package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyShortcutHandler implements EventHandler<KeyEvent> {
    Tablero tablero;

    public KeyShortcutHandler(Tablero tablero) {
        this.tablero = tablero;
    }


    @Override
    public void handle(KeyEvent keyEvent) {
        switch(keyEvent.getCode()){
            case M:
                tablero.toggleMusic();
                break;
            case E:
                tablero.ejecutarBloques();
                break;
            case D:
                tablero.clearBloques();
                break;
            case I:
                tablero.mostrarInstrucciones();
        }
    }
}
