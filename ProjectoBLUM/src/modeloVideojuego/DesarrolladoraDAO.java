package modeloVideojuego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesarrolladoraDAO {
    private Connection conexion;
    public DesarrolladoraDAO(Connection conexion) {
        this.conexion = conexion;
    }
    public List<Desarrollladora> obtenerDesarrolladora() {
        List<Desarrollladora> desarrollladoras = new ArrayList<>();
        String sql = "SELECT id,nombre FROM desarrolladora";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getString("nombre");

                Desarrollladora desarrollladora=new Desarrollladora(id,nombre);
                desarrollladoras.add(desarrollladora);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los empleado"+e.getMessage(),e);
        }
        return desarrollladoras;
    }
    public void agragarDesarrolladora(String nombre)throws SQLException {
        String sql="INSERT INTO Desarrolladora(nombre) VALUES(?)";
        try (PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener la desarrolladora"+e.getMessage(),e);
        }
    }
}
