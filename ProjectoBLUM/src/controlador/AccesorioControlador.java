package controlador;

import modeloConsola.Accesorio;
import modeloConsola.AccesorioDAO;
import modeloConsola.Consola;
import vista.AccesorioVista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AccesorioControlador {
    private AccesorioDAO accesorioDAO;
    private AccesorioVista accesorioVista;

    public AccesorioControlador(AccesorioDAO accesorioDAO, AccesorioVista accesorioVista) {
        this.accesorioDAO = accesorioDAO;
        this.accesorioVista = accesorioVista;
    }
    public void listaAccesorio(){
        List<Accesorio> accesorios=accesorioDAO.obtenerAccesorio();
        accesorioVista.mostrarAccesorio(accesorios);
    }
    public void agregarAccesorio()throws SQLException {
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

        accesorioDAO.agregarAccesorio(nombre,precio,existencias,id_deserrolladora);
    }
    public void eliminarAccesorio()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID del accesorio a Eliminar: ");
        int id= xy.nextInt();
        accesorioDAO.eliminarAccesorio(id);
        System.out.println("Accesorio eliminado correctamente.");
    }
}
