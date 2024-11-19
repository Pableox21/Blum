package vista;
import modeloVideojuego.Videojuegos;

import java.util.List;

public class VideojuegoVista {
    public void mostrarVideojuegos(List<Videojuegos> videojuego){
        System.out.println("\n***Lista de Videojuegos***");
        if(videojuego.isEmpty()){
            System.out.println("No hay videojuegos registrados.");
        }else{
            System.out.printf("%5s %15s %25s %25s %25s %25S\n","ID","NOMBRE","PRECIO","CLASIFICACION","EXISTENCIAS","DESARROLLADORA");
            for(Videojuegos videojuegos:videojuego){
                System.out.printf("%5s %15s %25s %25s  %25s %25s\n",videojuegos.getId(),videojuegos.getNombre(),videojuegos.getPrecio(),videojuegos.getClasificacion(),videojuegos.getExistencias(),videojuegos.getNombreDesarrolladora());
            }
        }
    }
}
