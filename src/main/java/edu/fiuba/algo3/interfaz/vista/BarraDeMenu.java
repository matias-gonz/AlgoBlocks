package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.controladores.OpcionDesactivarMusicaHandler;
import edu.fiuba.algo3.interfaz.controladores.OpcionAcercaDeEventHandler;
import edu.fiuba.algo3.interfaz.controladores.OpcionInstruccionesEventHanlder;
import edu.fiuba.algo3.interfaz.controladores.OpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;

public class BarraDeMenu extends MenuBar {

    public BarraDeMenu(MediaPlayer mediaPlayer) {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuSonido = new Menu("Sonidos");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionInstrucciones = new MenuItem("Instrucciones");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");
        MenuItem opcionToggleMusic = new MenuItem("Desactivar Musica");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        OpcionInstruccionesEventHanlder opcionInstruccionestHanlder = new OpcionInstruccionesEventHanlder();
        opcionInstrucciones.setOnAction(opcionInstruccionestHanlder);

        OpcionDesactivarMusicaHandler opcionDesactivarMusicaHandler = new OpcionDesactivarMusicaHandler(mediaPlayer, opcionToggleMusic);
        opcionToggleMusic.setOnAction(opcionDesactivarMusicaHandler);

        menuArchivo.getItems().add(opcionSalir);
        menuVer.getItems().addAll(opcionInstrucciones, opcionAcercaDe);
        menuSonido.getItems().addAll(opcionToggleMusic);

        this.getMenus().addAll(menuArchivo, menuVer, menuSonido);
    }

}
