package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class HabilidadDragHandler implements EventHandler<MouseEvent> {

    String nombre_boton;
    BotonAB boton;
    TransferMode[] transferencia;
    String icono;

    public HabilidadDragHandler(BotonAB referencia, String nombre_boton, TransferMode[] copyOrMove, String icono) {
        this.boton = referencia;
        this.nombre_boton = nombre_boton;
        this.transferencia = copyOrMove;
        this.icono = icono;
    }

    @Override
    public void handle(MouseEvent event) {
        Dragboard db = this.boton.startDragAndDrop(this.transferencia);
        db.setDragView(this.boton.snapshot(null, null), event.getX(), event.getY());
        ClipboardContent contenido = new ClipboardContent();
        JSONArray test = new JSONArray();
        test.put(this.nombre_boton);
        test.put(this.icono);
        contenido.putString(test.toString());
        db.setContent(contenido);
        event.consume();
    }
}
