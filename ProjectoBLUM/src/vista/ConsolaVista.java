package vista;

import modeloConsola.Consola;
import modeloVideojuego.Desarrolladora;

import java.util.List;

public class ConsolaVista {
    public void mostrarConsola(List<Consola> consolas){
        System.out.println("\n***Lista de Consolas***");
        if(consolas.isEmpty()){
            System.out.println("No hay consolas registrados.");
        }else{
            System.out.printf("%5s %15s %30s  %25s %25S\n","ID","DESARROLLADORA","NOMBRE","PRECIO","EXISTENCIAS");
            for(Consola consola:consolas){
                System.out.printf("%5s %15s %30s %25s %25s\n",consola.getId(),consola.getNombreDesarrolladora(),consola.getNombre(),consola.getPrecio(),consola.getExistencias());
            }
        }
    }
}
