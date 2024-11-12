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
        String sql = "SELECT id,nombre,precio,clasificacion,existencias,desarrolladora.id_desarrolladora,desarrolladora.nombre FROM Videojuegos JOIN desarrolladora ON desarrolladora.id=videojuegos.id_desarrolladora";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getString("nombre");
                Double precio=resultSet.getDouble("precio");
                String clasificacion=resultSet.getString("clasificacion");
                int existencias=resultSet.getInt("existencias");
                int id_desarroladora=resultSet.getInt("id Desarroladora");
                String nombreDesarrrolladora=resultSet.getString("Desarrolladora");

                Videojuegos videojuegos=new Videojuegos(id,nombre,precio,clasificacion,existencias,id_desarroladora,nombreDesarrrolladora);
                videojuego.add(videojuegos);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los empleado"+e.getMessage(),e);
        }
        return videojuego;
    }
    public void agragarDesarrolladora(String nombre)throws SQLException{
        String sql="INSERT INTO Desarrolladora(nombre) VALUES(?)";
        try (PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener la desarrolladora"+e.getMessage(),e);
        }
    }
    public void agregarVideojuego(String nombre,Double precio,String clasificacion,int existencias,int id_dessarroladora)throws SQLException{
        String sql="INSERT INTO Videojuegos(nombre,precio,clasificacion,existencias,id_desarrolladora) VALUES(?,?,?,?,?)";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.setDouble(2,precio);
            stmt.setString(3,clasificacion);
            stmt.setInt(4,existencias);
            stmt.setInt(5,id_dessarroladora);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error al obtener los empleados"+e.getMessage(),e);
        }
    }
}
