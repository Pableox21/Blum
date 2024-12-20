package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioDAOCliente {
    Scanner xy=new Scanner(System.in);
    private Connection conexion;
    public UsuarioDAOCliente(Connection conexion){
        this.conexion=conexion;
    }
    public List<UsuarioCliente> obtenerUsuariosCliente() {
        List<UsuarioCliente> usuariosCliente = new ArrayList<>();
        String sql = "SELECT id,nombre,email FROM usuariosCliente";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getString("nombre");
                String email=resultSet.getString("email");
                UsuarioCliente usuarioCliente=new UsuarioCliente(id,nombre,email);
                usuariosCliente.add(usuarioCliente);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los clientes"+e.getMessage(),e);
        }
        return usuariosCliente;
    }
    public void agregarUsuarioCliente(String nombre,String email)throws SQLException{
        String sql="INSERT INTO usuariosCliente(nombre,email) VALUES(?,?)";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.setString(2,email);
            stmt.executeUpdate();
        }catch(SQLException e){
        throw new RuntimeException("Error al obtener los clientes"+e.getMessage(),e);
        }
    }
    public void eliminarUsuarioCliente(int id)throws SQLException{
        String sql="DELETE FROM usuariosCliente WHERE id=?";
        try (PreparedStatement stmt= conexion.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
            }catch (SQLException e){
            throw new RuntimeException("Error al eliminar el cliente: "+e.getMessage());
        }
    }
    public void editarCliente(String nuevoNombre,String nuevoEmail,int id)throws SQLException{
        String sql="UPDATE usuariosCliente SET nombre=?,email=? WHERE id=?";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nuevoNombre);
            stmt.setString(2,nuevoEmail);
            stmt.setInt(3,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error al actualizar datos: "+e.getMessage());
        }
    }
}
