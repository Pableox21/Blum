package controlador;

import modeloVideojuego.DesarrolladoraDAO;
import modeloVideojuego.Desarrolladora;
import vista.DesarrollaVista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DesarrolladoraControlador {
    private DesarrolladoraDAO desarrolladoraDAO;
    private DesarrollaVista desarrollaVista;

    public DesarrolladoraControlador(DesarrolladoraDAO desarrolladoraDAO, DesarrollaVista desarrollaVista) {
        this.desarrolladoraDAO = desarrolladoraDAO;
        this.desarrollaVista = desarrollaVista;
    }
    public void listaDesarrolladora(){
        List<Desarrolladora> desarrolladoras =desarrolladoraDAO.obtenerDesarrolladora();
        desarrollaVista.mostrarDesarrolladora(desarrolladoras);
    }
    public void agregarDesarrolladora()throws SQLException {
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el nombre : ");
        String nombre= xy.nextLine();

        desarrolladoraDAO.agregarDesarrolladora(nombre);
        System.out.println("Desarrolladora agregada con exito.");
    }
    public void eliminarDesarroladora()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID del desarrolladora a Eliminar: ");
        int id= xy.nextInt();
        desarrolladoraDAO.eliminarDesarrolladora(id);
        System.out.println("Desarrolladora eliminado correctamente.");
    }
    public void editarDesarrolladora()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID de la desarrolladora a Editar: ");
        int id= xy.nextInt();
        xy.nextLine();
        System.out.print("Ingrese el nombre : ");
        String nuevoNombre= xy.nextLine();

        desarrolladoraDAO.editarDesarrolladora(nuevoNombre,id);
        System.out.println("Desarrolladora editada correctamente.");
    }
}
