package controlador;

import modelo.UsuarioEmpleado;
import modelo.UsuarioDAOEmpleado;
import vista.UsuarioVistaEmpleado;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UsuarioControladorEmpleado {
    private UsuarioDAOEmpleado usuarioDAOEmpleado;
    private UsuarioVistaEmpleado usuarioVistaEmpleado;
    public UsuarioControladorEmpleado(UsuarioDAOEmpleado usuarioDAOEmpleado,UsuarioVistaEmpleado usuarioVistaEmpleado){
        this.usuarioDAOEmpleado=usuarioDAOEmpleado;
        this.usuarioVistaEmpleado=usuarioVistaEmpleado;
    }
    public void listaUsuariosEmpleado(){
        List<UsuarioEmpleado> usuariosEmpleado=usuarioDAOEmpleado.obtenerUsuariosEmpleado();
        usuarioVistaEmpleado.mostrarUsuariosEmpleado(usuariosEmpleado);
    }
    public void agregarUsuarioEmpleado()throws SQLException {
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el nombre : ");
        String nombre= xy.nextLine();
        System.out.print("Ingrese el correo : ");
        String email= xy.nextLine();

        usuarioDAOEmpleado.agregarUsuarioEmpleado(nombre,email);
        System.out.println("Usuario agregado con exito.");
    }
    public void eliminarUsuarioEmpleado()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID del Empleado a Eliminar: ");
        int id= xy.nextInt();
        usuarioDAOEmpleado.eliminarUsuarioEmpleado(id);
        System.out.println("Empleado eliminado correctamente.");
    }
}
