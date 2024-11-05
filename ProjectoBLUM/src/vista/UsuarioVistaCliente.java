package vista;

import modelo.UsuarioCliente;

import java.util.List;

public class UsuarioVistaCliente {
    public void mostrarUsuariosCliente(List<UsuarioCliente> usuariosCliente){
        System.out.println("\n***Lista de Usuarios***");
        if(usuariosCliente.isEmpty()){
            System.out.println("No hay usuarios registrados.");
        }else{
            System.out.printf("%5s %15s %25S\n","ID","NOMBRE","EMAIL");
            for(UsuarioCliente usuarioCliente:usuariosCliente){
                System.out.printf("%5s %15s %25s\n",usuarioCliente.getId(),usuarioCliente.getNombre(),usuarioCliente.getEmail());
            }
        }
    }
}
