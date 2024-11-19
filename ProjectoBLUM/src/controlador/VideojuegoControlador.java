package controlador;

import modeloVideojuego.Videojuegos;
import modeloVideojuego.VideojuegosDAO;
import vista.VideojuegoVista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class VideojuegoControlador {
    private VideojuegosDAO videojuegosDAO;
    private VideojuegoVista videojuegoVista;
    public VideojuegoControlador(VideojuegosDAO videojuegosDAO,VideojuegoVista videojuegoVista){
        this.videojuegosDAO=videojuegosDAO;
        this.videojuegoVista=videojuegoVista;
    }
    public void listaVideojuegos(){
        List<Videojuegos> videojuegos=videojuegosDAO.obtenerVideojuego();
        videojuegoVista.mostrarVideojuegos(videojuegos);
    }
    public void agregarVideojuegos()throws SQLException {
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el nombre : ");
        String nombre= xy.nextLine();
        System.out.print("Ingrese el precio : ");
        Double precio= xy.nextDouble();
        System.out.println("Ingrese la clasificacion: ");
        String clasificacion= xy.nextLine();
        System.out.println("Ingrese las existencias: ");
        int existencias= xy.nextInt();
        System.out.println("Ingrese la desarrolladora: ");
        System.out.println("1. PlayStation");
        System.out.println("2. Xbox");
        System.out.println("3. Nintendo");
        int id_deserrolladora=xy.nextInt();

        videojuegosDAO.agregarVideojuego(nombre,precio,clasificacion,existencias,id_deserrolladora);
    }
    public void eliminarVideojuego()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID del videojuego a Eliminar: ");
        int id= xy.nextInt();
        videojuegosDAO.eliminarVideojuego(id);
        System.out.println("Videojuego eliminado correctamente.");
    }

}

