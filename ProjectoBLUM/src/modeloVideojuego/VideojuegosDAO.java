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
        String sql = "SELECT videojuego.id,videojuego.nombre,videojuego.precio,videojuego.clasificacion,videojuego.existencias,desarrolladora.nombre FROM videojuego JOIN desarrolladora";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getString("nombre");
                Double precio=resultSet.getDouble("precio");
                String clasificacion=resultSet.getString("clasificacion");
                int existencias=resultSet.getInt("existencias");
                String nombreDesarrolladora=resultSet.getString("nombreDesarrolladora");

                Videojuegos videojuegos=new Videojuegos(id,nombre,precio,clasificacion,existencias,nombreDesarrolladora);
                videojuego.add(videojuegos);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los videojuegos"+e.getMessage(),e);
        }
        return videojuego;
    }
    public void agregarVideojuego(String nombre,Double precio,String clasificacion,int existencias,int id_dessarrolladora)throws SQLException{
        String sql="INSERT INTO videojuego(videojuego.nombre,videojuego.precio,videojuego.clasificacion,videojuego.existencias,videojuego.id_desarrolladora) VALUES(?,?,?,?,?)";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.setDouble(2,precio);
            stmt.setString(3,clasificacion);
            stmt.setInt(4,existencias);
            stmt.setInt(5,id_dessarrolladora);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error al obtener los videojuegos"+e.getMessage(),e);
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
}
