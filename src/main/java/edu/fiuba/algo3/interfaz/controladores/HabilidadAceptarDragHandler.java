package edu.fiuba.algo3.interfaz.controladores;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class HabilidadAceptarDragHandler implements EventHandler<DragEvent> {

    TransferMode[] transferencia;

    public HabilidadAceptarDragHandler(TransferMode[] copyOrMove) {
        this.transferencia = copyOrMove;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        if (db.hasString()) {
            dragEvent.acceptTransferModes(transferencia);
        }
        dragEvent.consume();
    }
}
