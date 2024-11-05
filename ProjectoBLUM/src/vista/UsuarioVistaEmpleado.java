package vista;

import modelo.UsuarioEmpleado;

import java.util.List;

public class UsuarioVistaEmpleado {
    public void mostrarUsuariosEmpleado(List<UsuarioEmpleado> usuariosEmpleado){
        System.out.println("\n***Lista de Usuarios***");
        if(usuariosEmpleado.isEmpty()){
            System.out.println("No hay usuarios registrados.");
        }else{
            System.out.printf("%5s %15s %25S\n","ID","NOMBRE","EMAIL");
            for(UsuarioEmpleado usuarioEmpleado:usuariosEmpleado){
                System.out.printf("%5s %15s %25s\n",usuarioEmpleado.getId(),usuarioEmpleado.getNombre(),usuarioEmpleado.getEmail());
            }
        }
    }
}
