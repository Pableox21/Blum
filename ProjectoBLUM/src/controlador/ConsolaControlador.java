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
        System.out.print("Ingrese las existencias: ");
        int existencias= xy.nextInt();
        System.out.println("Ingrese la desarrolladora: ");
        System.out.println("1. PlayStation");
        System.out.println("2. Xbox");
        System.out.println("3. Nintendo");
        int id_deserrolladora=xy.nextInt();

        consolaDAO.agregarConsola(nombre,precio,existencias,id_deserrolladora);
        System.out.println("Consola agregada correctamente.");
    }
    public void eliminarConsola()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID de la consola a Eliminar: ");
        int id= xy.nextInt();
       consolaDAO.eliminarConsola(id);
        System.out.println("Consola eliminada correctamente.");
    }
    public void editarConsola()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID de la consola a Editar: ");
        int id= xy.nextInt();
        xy.nextLine();
        System.out.print("Ingrese el nombre : ");
        String nuevoNombre= xy.nextLine();
        System.out.print("Ingrese el precio : ");
        Double nuevoPrecio= xy.nextDouble();
        System.out.print("Ingrese las existencias : ");
        int nuevoExistencia= xy.nextInt();
        System.out.println("Ingrese la desarrolladora : ");
        System.out.println("1. PlayStation");
        System.out.println("2. Xbox");
        System.out.println("3. Nintendo");
        int nuevoid_dessarroladora= xy.nextInt();

        consolaDAO.editarConsola(nuevoNombre,nuevoPrecio,nuevoExistencia,nuevoid_dessarroladora,id);
        System.out.println("Consola editada correctamente.");
    }
}
