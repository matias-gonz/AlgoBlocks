package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonBloque;
import edu.fiuba.algo3.modelo.bloques.Bloque;
import javafx.scene.layout.HBox;

public class ContenedorBloque extends HBox {
    public ContenedorBloque() {

    }

    public Bloque obtenerBloque(){
        BotonBloque boton = (BotonBloque) this.getChildren().get(0);
        return boton.obtenerBloque(this.getChildren());
    }

}
