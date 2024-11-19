package vista;

import modeloVideojuego.Desarrolladora;

import java.util.List;

public class DesarrollaVista {
    public void mostrarDesarrolladora(List<Desarrolladora> desarrolladoras){
        System.out.println("\n***Lista de Desarrolladoras***");
        if(desarrolladoras.isEmpty()){
            System.out.println("No hay desarrolladoras registrados.");
        }else{
            System.out.printf("%5s %25s\n","ID","DESARROLLADORA");
            for(Desarrolladora desarrolladora : desarrolladoras){
                System.out.printf("%5s %25s\n", desarrolladora.getId(), desarrolladora.getNombre());
            }
        }
    }
}
