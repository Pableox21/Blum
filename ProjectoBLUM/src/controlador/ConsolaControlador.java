package controlador;

import modeloConsola.Consola;
import modeloConsola.ConsolaDAO;
import vista.ConsolaVista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ConsolaControlador {
    private ConsolaDAO consolaDAO;
    private ConsolaVista consolaVista;

    public ConsolaControlador(ConsolaDAO consolaDAO, ConsolaVista consolaVista) {
        this.consolaDAO = consolaDAO;
        this.consolaVista = consolaVista;
    }

    public void listaConsola(){
        List<Consola> consolas=consolaDAO.obtenerConsola();
        consolaVista.mostrarConsola(consolas);
    }
    public void agregarConsola()throws SQLException {
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el nombre : ");
        String nombre= xy.nextLine();
        System.out.print("Ingrese el precio : ");
        Double precio= xy.nextDouble();
        System.out.println("Ingrese las existencias: ");
        int existencias= xy.nextInt();
        System.out.println("Ingrese la desarrolladora: ");
        System.out.println("1. PlayStation");
        System.out.println("2. Xbox");
        System.out.println("3. Nintendo");
        int id_deserrolladora=xy.nextInt();

        consolaDAO.agregarConsola(nombre,precio,existencias,id_deserrolladora);
    }
    public void eliminarConsola()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID del videojuego a Eliminar: ");
        int id= xy.nextInt();
       consolaDAO.eliminarConsola(id);
        System.out.println("Videojuego eliminado correctamente.");
    }
}
