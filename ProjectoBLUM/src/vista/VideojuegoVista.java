package vista;
import modeloVideojuego.Videojuegos;
import modeloVideojuego.Desarrollladora;

import java.util.List;

public class VideojuegoVista {
    public void mostrarVideojuegos(List<Videojuegos> videojuego){
        System.out.println("\n***Lista de Videojuegos***");
        if(videojuego.isEmpty()){
            System.out.println("No hay usuarios registrados.");
        }else{
            System.out.printf("%5s %15s %25S\n","ID","DESARROLLADORA","NOMBRE","PRECIO","CLASIFICACION","EXISTENCIAS");
            for(Videojuegos videojuegos:videojuego){
                Desarrollladora desarrolladora = null;
                System.out.printf("%5s %15s %25s %25s %25s\n",videojuegos.getId(),desarrolladora.getNombre(),videojuegos.getNombre(),videojuegos.getPrecio(),videojuegos.getClasificacion(),videojuegos.getExistencias());
            }
        }
    }
}
