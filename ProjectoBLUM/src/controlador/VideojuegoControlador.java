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
        System.out.print("Ingrese el correo : ");
        String email= xy.nextLine();

        videojuegosDAO.agregarVideojuego(nombre,email);
        System.out.println("Usuario agregado con exito.");
    }
}

