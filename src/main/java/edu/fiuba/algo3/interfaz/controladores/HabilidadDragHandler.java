package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.botoneras.BotonBloque;
import javafx.event.EventHandler;
import javafx.scene.input.*;

public class HabilidadDragHandler implements EventHandler<MouseEvent> {

    BotonBloque boton;
    TransferMode[] transferencia;

    public HabilidadDragHandler(BotonBloque referencia, TransferMode[] copyOrMove) {
        this.boton = referencia;
        this.transferencia = copyOrMove;
    }

    @Override
    public void handle(MouseEvent event) {
        Dragboard db = this.boton.startDragAndDrop(this.transferencia);
        db.setDragView(this.boton.snapshot(null, null), event.getX(), event.getY());
        ClipboardContent contenido = new ClipboardContent();
        contenido.putString("transfer");
        db.setContent(contenido);
        event.consume();
    }
}
