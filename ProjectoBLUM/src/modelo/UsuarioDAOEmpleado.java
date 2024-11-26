package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOEmpleado {
    private Connection conexion;
    public UsuarioDAOEmpleado(Connection conexion){
        this.conexion=conexion;
    }
    public List<UsuarioEmpleado> obtenerUsuariosEmpleado() {
        List<UsuarioEmpleado> usuariosEmpleado = new ArrayList<>();
        String sql = "SELECT id,nombre,email FROM usuariosEmpleado";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getString("nombre");
                String email=resultSet.getString("email");
                UsuarioEmpleado usuarioEmpleado=new UsuarioEmpleado(id,nombre,email);
                usuariosEmpleado.add(usuarioEmpleado);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los empleado"+e.getMessage(),e);
        }
        return usuariosEmpleado;
    }
    public void agregarUsuarioEmpleado(String nombre,String email)throws SQLException{
        String sql="INSERT INTO usuariosEmpleado(nombre,email) VALUES(?,?)";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.setString(2,email);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error al obtener los empleados"+e.getMessage(),e);
        }
    }
    public void eliminarUsuarioEmpleado(int id)throws SQLException{
        String sql="DELETE FROM usuariosEmpleado WHERE id=?";
        try (PreparedStatement stmt= conexion.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error al eliminar el empleado: "+e.getMessage());
        }
    }
    public void editarEmpleado(String nuevoNombre,String nuevoEmail,int id)throws SQLException{
        String sql="UPDATE usuariosEmpleado SET nombre=?,email=? WHERE id=?";
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
