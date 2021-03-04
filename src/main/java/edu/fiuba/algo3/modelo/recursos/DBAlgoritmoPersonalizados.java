package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.bloques.Bloque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DBAlgoritmoPersonalizados {
    private HashMap<String, List<Bloque>> bloques_de_ejecutacion;

    public DBAlgoritmoPersonalizados() {
        bloques_de_ejecutacion = new HashMap<>();
    }

    public void guardar_algoritmo( List<Bloque> bloques , String nombre_algoritmo )
    {
        bloques_de_ejecutacion.put(nombre_algoritmo, bloques);
    }

    public List<Bloque> cargar_algoritmo( String nombre_algoritmo )
    {
        Boolean existe_algoritmo = bloques_de_ejecutacion.containsKey(nombre_algoritmo);

        if( !existe_algoritmo )
        {
            return null; // se puede manejar alternativas
        }

        return bloques_de_ejecutacion.get(nombre_algoritmo);
    }

    public List<List<?>> cargar_todos_algoritmos()
    {
        List<List<?>> arreglo_temporal = new ArrayList<>();

        if( bloques_de_ejecutacion.size() <= 0 )
            return arreglo_temporal;

        for( String nombre_algoritmo : bloques_de_ejecutacion.keySet() )
        {
            arreglo_temporal.add( Arrays.asList(nombre_algoritmo, bloques_de_ejecutacion.get(nombre_algoritmo)) );
        }

        return arreglo_temporal;
    }
}