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
        String sql = "SELECT id,nombre,desarrolladora.nombre,precio,clasificacion,existencias FROM Videojuegos JOIN desarrolladora ON desarrolladora.id=videojuegos.id_desarrolladora";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getString("nombre");
                Double precio=resultSet.getDouble("precio");
                String clasificacion=resultSet.getString("clasificacion");
                int existencias=resultSet.getInt("existencias");

                Videojuegos videojuegos=new Videojuegos(id,nombre,precio,clasificacion,existencias);
                videojuego.add(videojuegos);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los empleado"+e.getMessage(),e);
        }
        return videojuego;
    }
    public void agregarVideojuego(String nombre,String precio)throws SQLException{
        String sql="INSERT INTO Videojuegos(nombre,id_desarrolladora,precio) VALUES(?,?,?)";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.setString(2,precio);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error al obtener los empleados"+e.getMessage(),e);
        }
    }
}
