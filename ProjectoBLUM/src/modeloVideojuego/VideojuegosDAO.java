package modeloVideojuego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideojuegosDAO {
    private Connection conexion;
    public VideojuegosDAO(Connection conexion){
        this.conexion=conexion;
    }
    public List<Videojuegos> obtenerVideojuego() {
        List<Videojuegos> videojuego = new ArrayList<>();
        String sql = "SELECT videojuego.id,videojuego.nombre,precio,existencias,desarrolladora.nombre FROM videojuego JOIN desarrolladora on desarrolladora.id=videojuego.id_desarrolladora ORDER BY videojuego.id asc";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("videojuego.id");
                String nombre=resultSet.getString("videojuego.nombre");
                Double precio=resultSet.getDouble("precio");
                int existencias=resultSet.getInt("existencias");
                String nombreDesarrolladora=resultSet.getString("desarrolladora.nombre");

                Videojuegos videojuegos=new Videojuegos(id,nombre,precio,existencias,nombreDesarrolladora);
                videojuego.add(videojuegos);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los videojuegos"+e.getMessage(),e);
        }
        return videojuego;
    }
    public void agregarVideojuego(String nombre, Double precio, int  existencias,int id_dessarroladora)throws SQLException{
        String sql="INSERT INTO Videojuego(nombre,precio,existencias,videojuego.id_desarrolladora) VALUES(?,?,?,?)";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.setDouble(2,precio);
            stmt.setInt(3,existencias);
            stmt.setInt(4,id_dessarroladora);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error al agregar los videojuegos"+e.getMessage(),e);
        }
    }
    public void eliminarVideojuego(int id)throws SQLException{
        String sql="DELETE FROM videojuego WHERE id=?";
        try (PreparedStatement stmt= conexion.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error al eliminar el videojuego: "+e.getMessage());
        }
    }
    public void editarVideojuegos(String nuevoNombre,Double nuevoPrecio,int nuevoExistencia,int nuevoid_dessarroladora,int id)throws SQLException{
        String sql="UPDATE videojuego SET nombre=?,precio=?,existencias=?,id_desarrolladora=? WHERE id=?";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nuevoNombre);
            stmt.setDouble(2,nuevoPrecio);
            stmt.setInt(3,nuevoExistencia);
            stmt.setInt(4,nuevoid_dessarroladora);
            stmt.setInt(5,id);
            stmt.executeUpdate();
        }catch (SQLException e){
           throw new RuntimeException("Error al actualizar datos: "+e.getMessage());
        }
    }
}
