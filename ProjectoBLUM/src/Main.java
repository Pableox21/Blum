import controlador.UsuarioControladorCliente;
import controlador.UsuarioControladorEmpleado;
import controlador.VideojuegoControlador;
import database.ConexionDB;
import modelo.UsuarioDAOCliente;
import vista.UsuarioVistaCliente;
import modelo.UsuarioDAOEmpleado;
import vista.UsuarioVistaEmpleado;
import modeloVideojuego.Videojuegos;
import modeloVideojuego.VideojuegosDAO;
import vista.VideojuegoVista;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
            try{
                Connection conexion= ConexionDB.getConnection();
                UsuarioDAOCliente usuarioDAOCliente=new UsuarioDAOCliente(conexion);
                UsuarioVistaCliente usuarioVistaCliente=new UsuarioVistaCliente();
                UsuarioControladorCliente usuarioControladorCliente=new UsuarioControladorCliente(usuarioDAOCliente,usuarioVistaCliente);
                UsuarioDAOEmpleado usuarioDAOEmpleado=new UsuarioDAOEmpleado(conexion);
                UsuarioVistaEmpleado usuarioVistaEmpleado=new UsuarioVistaEmpleado();
                UsuarioControladorEmpleado usuarioControladorEmpleado=new UsuarioControladorEmpleado(usuarioDAOEmpleado,usuarioVistaEmpleado);
                VideojuegosDAO videojuegosDAO=new VideojuegosDAO(conexion);
                VideojuegoVista videojuegoVista=new VideojuegoVista();
                VideojuegoControlador videojuegoControlador=new VideojuegoControlador(videojuegosDAO,videojuegoVista);

                Scanner scanner=new Scanner(System.in);
                int opcion;
                int opcion1;
                int opcion2;
                int opcion3;
                do{
                    System.out.println("\n===Menú de Inicio===");
                    System.out.println("1.Gestión de Clientes");
                    System.out.println("2.Gestión de empleados");
                    System.out.println("3.Gestión de videojuegos");
                    System.out.println("0.Salir");
                    System.out.print("Selecciona una opción: ");
                    opcion=scanner.nextInt();
                    switch(opcion) {
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
                            } while (opcion1 !=0);
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
                                        System.out.println("Saliendo de gestión de Clientes...");
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
                                System.out.println("3.Mostrar Desarrolladoras");
                                System.out.println("3.Agregar Desarrolladora");
                                System.out.println("4.Eliminar Desarrolladora");
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
                                    case 0:
                                        System.out.println("Saliendo de gestión de Videojuegos...");
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Intente de nuevo.");
                                        break;
                                }
                            } while (opcion3 != 0);
                            break;
                        case 0:
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                } while (opcion !=0);
                ConexionDB.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}