package vista;
import modeloVideojuego.Videojuegos;

import java.util.List;

public class VideojuegoVista {
    public void mostrarVideojuegos(List<Videojuegos> videojuego){
        System.out.println("\n***Lista de Videojuegos***");
        if(videojuego.isEmpty()){
            System.out.println("No hay Videojuegos registrados.");
        }else{
            System.out.printf("%5s %25s %30S %25s %25s\n","ID","DESARROLLADORA","NOMBRE","PRECIO","EXISTENCIAS");
            for(Videojuegos videojuegos:videojuego){
                System.out.printf("%5s %25s %30s %25s %25s\n",videojuegos.getId(),videojuegos.getNombreDesarrolladora(),videojuegos.getNombre(),videojuegos.getPrecio(),videojuegos.getExistencias());
            }
        }
    }
}
