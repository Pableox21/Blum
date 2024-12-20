package vista;
import modeloConsola.Accesorio;
import modeloVideojuego.Desarrolladora;


import java.util.List;

public class AccesorioVista {
    public void mostrarAccesorio(List<Accesorio> accesorios){
        System.out.println("\n***Lista de Accesorios***");
        if(accesorios.isEmpty()){
            System.out.println("No hay accesorios registrados.");
        }else{
            System.out.printf("%5s %15s %30s  %25s %25S\n","ID","DESARROLLADORA","NOMBRE","PRECIO","EXISTENCIAS");
            for(Accesorio accesorio:accesorios){
                System.out.printf("%5s %15s %30s %25s %25s\n",accesorio.getId(),accesorio.getNombreDesarrolladora(),accesorio.getNombre(),accesorio.getPrecio(),accesorio.getExistencias());
            }
        }
    }
}
