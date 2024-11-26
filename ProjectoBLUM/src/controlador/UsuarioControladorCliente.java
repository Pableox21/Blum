package controlador;
import modelo.UsuarioCliente;
import modelo.UsuarioDAOCliente;
import vista.UsuarioVistaCliente;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UsuarioControladorCliente {
    private UsuarioDAOCliente usuarioDAOCliente;
    private UsuarioVistaCliente usuarioVistaCliente;
    public UsuarioControladorCliente(UsuarioDAOCliente usuarioDAOCliente,UsuarioVistaCliente usuarioVistaCliente){
        this.usuarioDAOCliente=usuarioDAOCliente;
        this.usuarioVistaCliente=usuarioVistaCliente;
    }
    public void listaUsuariosClientes(){
        List<UsuarioCliente>usuariosCliente=usuarioDAOCliente.obtenerUsuariosCliente();
        usuarioVistaCliente.mostrarUsuariosCliente(usuariosCliente);
    }
    public void agregarUsuarioCliente()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el nombre : ");
        String nombre= xy.nextLine();
        System.out.print("Ingrese el correo : ");
        String email= xy.nextLine();

        usuarioDAOCliente.agregarUsuarioCliente(nombre,email);
        System.out.println("Cliente agregado con exito.");
    }
    public void eliminarUsuarioCliente()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID del Cliente a Eliminar: ");
        int id= xy.nextInt();
        usuarioDAOCliente.eliminarUsuarioCliente(id);
            System.out.println("Cliente eliminado correctamente.");
    }
    public void editarCliente()throws SQLException{
        Scanner xy=new Scanner(System.in);
        System.out.print("Ingrese el ID del Cliente a Editar: ");
        int id= xy.nextInt();
        xy.nextLine();
        System.out.print("Ingrese el nombre : ");
        String nuevoNombre= xy.nextLine();
        System.out.print("Ingrese el email : ");
        String nuevoEmail= xy.nextLine();

        usuarioDAOCliente.editarCliente(nuevoNombre,nuevoEmail,id);
        System.out.println("Cliente editado correctamente.");
    }
}
