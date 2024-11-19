import controlador.*;
import database.ConexionDB;
import modelo.UsuarioDAOCliente;
import modeloConsola.AccesorioDAO;
import modeloConsola.ConsolaDAO;
import vista.*;
import modelo.UsuarioDAOEmpleado;
import modeloVideojuego.Videojuegos;
import modeloVideojuego.VideojuegosDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Connection conexion = ConexionDB.getConnection();
            UsuarioDAOCliente usuarioDAOCliente = new UsuarioDAOCliente(conexion);
            UsuarioVistaCliente usuarioVistaCliente = new UsuarioVistaCliente();
            UsuarioControladorCliente usuarioControladorCliente = new UsuarioControladorCliente(usuarioDAOCliente, usuarioVistaCliente);
            UsuarioDAOEmpleado usuarioDAOEmpleado = new UsuarioDAOEmpleado(conexion);
            UsuarioVistaEmpleado usuarioVistaEmpleado = new UsuarioVistaEmpleado();
            UsuarioControladorEmpleado usuarioControladorEmpleado = new UsuarioControladorEmpleado(usuarioDAOEmpleado, usuarioVistaEmpleado);
            VideojuegosDAO videojuegosDAO = new VideojuegosDAO(conexion);
            VideojuegoVista videojuegoVista = new VideojuegoVista();
            VideojuegoControlador videojuegoControlador = new VideojuegoControlador(videojuegosDAO, videojuegoVista);
            ConsolaDAO consolaDAO=new ConsolaDAO(conexion);
            ConsolaVista consolaVista=new ConsolaVista();
            ConsolaControlador consolaControlador=new ConsolaControlador(consolaDAO,consolaVista);
            AccesorioDAO accesorioDAO=new AccesorioDAO(conexion);
            AccesorioVista accesorioVista=new AccesorioVista();
            AccesorioControlador accesorioControlador=new AccesorioControlador(accesorioDAO,accesorioVista);

            Scanner scanner = new Scanner(System.in);
            int opcion;
            int opcion1;
            int opcion2;
            int opcion3;
            int opcion4;
            int opcion5;
            int opcion6;
            do {
                System.out.println("\n===Menú de Inicio===");
                System.out.println("1.Gestión de Clientes");
                System.out.println("2.Gestión de empleados");
                System.out.println("3.Gestión de videojuegos");
                System.out.println("4.Gestión de consolas");
                System.out.println("5.Gestión de accesorios");
                System.out.println("6.Gestión de desarrolladoras");
                System.out.println("0.Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        do {
                            System.out.println("\n===Menú de Gestión de Clientes===");
                            System.out.println("1.Mostrar Clientes");
                            System.out.println("2.Agregar Cliente");
                            System.out.println("3.Eliminar Cliente");
                            System.out.println("0.Atras");
                            System.out.print("Selecciona una opción: ");
                            opcion1 = scanner.nextInt();
                            switch (opcion1) {
                                case 1:
                                    usuarioControladorCliente.listaUsuariosClientes();
                                    break;
                                case 2:
                                    usuarioControladorCliente.agregarUsuarioCliente();
                                    break;
                                case 3:
                                    usuarioControladorCliente.eliminarUsuarioCliente();
                                    break;
                                case 0:
                                    System.out.println("Saliendo de gestión de Clientes...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        } while (opcion1 != 0);
                        break;
                    case 2:
                        do {
                            System.out.println("\n===Menú de Gestión de Empleados===");
                            System.out.println("1.Mostrar Empleados");
                            System.out.println("2.Agregar Empleado");
                            System.out.println("3.Eliminar Empleado");
                            System.out.println("0.Atras");
                            System.out.print("Selecciona una opción: ");
                            opcion2 = scanner.nextInt();
                            switch (opcion2) {
                                case 1:
                                    usuarioControladorEmpleado.listaUsuariosEmpleado();
                                    break;
                                case 2:
                                    usuarioControladorEmpleado.agregarUsuarioEmpleado();
                                    break;
                                case 3:
                                    usuarioControladorEmpleado.eliminarUsuarioEmpleado();
                                    break;
                                case 0:
                                    System.out.println("Saliendo de gestión de Empleados...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        } while (opcion2 != 0);
                        break;
                    case 3:
                        do {
                            System.out.println("\n===Gestion de videojuegos===");
                            System.out.println("1.Mostrar Inventario");
                            System.out.println("2.Agregar Videojuegos");
                            System.out.println("3.Eliminar Videojuegos");
                            System.out.println("0.Atras");
                            System.out.print("Selecciona una opción: ");
                            opcion3 = scanner.nextInt();
                            switch (opcion3) {
                                case 1:
                                    videojuegoControlador.listaVideojuegos();
                                    break;
                                case 2:
                                    videojuegoControlador.agregarVideojuegos();
                                    break;
                                case 3:
                                    videojuegoControlador.eliminarVideojuego();
                                    break;
                                case 0:
                                    System.out.println("Saliendo de gestión de Videojuegos...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        } while (opcion3 != 0);
                        break;
                    case 4:
                        do {
                            System.out.println("\n===Gestion de consolas===");
                            System.out.println("1.Mostrar Inventario");
                            System.out.println("2.Agregar Consolas");
                            System.out.println("3.Eliminar Cosolas");
                            System.out.println("0.Atras");
                            System.out.print("Selecciona una opción: ");
                            opcion4 = scanner.nextInt();
                            switch (opcion4) {
                                case 1:
                                    consolaControlador.listaConsola();
                                    break;
                                case 2:
                                    consolaControlador.agregarConsola();
                                    break;
                                case 3:
                                    consolaControlador.eliminarConsola();
                                    break;
                                case 0:
                                    System.out.println("Saliendo de gestión de Consolas...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        } while (opcion4 != 0);
                        break;
                    case 5:
                        do {
                            System.out.println("\n===Gestion de Accesorios===");
                            System.out.println("1.Mostrar Inventario");
                            System.out.println("2.Agregar Accesorios");
                            System.out.println("3.Eliminar Accesorios");
                            System.out.println("0.Atras");
                            System.out.print("Selecciona una opción: ");
                            opcion5 = scanner.nextInt();
                            switch (opcion5) {
                                case 1:
                                    accesorioControlador.listaAccesorio();
                                    break;
                                case 2:
                                    accesorioControlador.agregarAccesorio();
                                    break;
                                case 3:
                                    accesorioControlador.eliminarAccesorio();
                                    break;
                                case 0:
                                    System.out.println("Saliendo de gestión de Accesorios...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        } while (opcion5 != 0);
                        break;
                    case 6:
                        do {
                            System.out.println("\n===Gestion de DEsarrolladoras===");
                            System.out.println("1.Mostrar Desarrolladoras");
                            System.out.println("2.Agregar Desarrolladoras");
                            System.out.println("3.Eliminar Desarrolladoras");
                            System.out.println("0.Atras");
                            System.out.print("Selecciona una opción: ");
                            opcion6 = scanner.nextInt();
                            switch (opcion6) {
                                case 1:
                                    accesorioControlador.listaAccesorio();
                                    break;
                                case 2:
                                    accesorioControlador.agregarAccesorio();
                                    break;
                                case 3:
                                    accesorioControlador.eliminarAccesorio();
                                    break;
                                case 0:
                                    System.out.println("Saliendo de gestión de Desarrolladoras...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        } while (opcion6 != 0);
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } while (opcion != 0);
            ConexionDB.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}