package modeloConsola;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccesorioDAO {
    private Connection conexion;
    public AccesorioDAO(Connection conexion){
        this.conexion=conexion;
    }
    public List<Accesorio> obtenerAccesorio() {
        List<Accesorio> accesorios = new ArrayList<>();
        String sql = "SELECT id,nombre,precio,existencias,desarrolladora.id_desarrolladora,desarrolladora.nombre FROM accesorio JOIN desarrolladora ON desarrolladora.id=consola.id_desarrolladora";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getString("nombre");
                Double precio=resultSet.getDouble("precio");
                int existencias=resultSet.getInt("existencias");
                int id_desarroladora=resultSet.getInt("id Desarroladora");
                String nombreDesarrrolladora=resultSet.getString("Desarrolladora");

                Accesorio accesorio=new Accesorio(id,nombre,precio,existencias,id_desarroladora,nombreDesarrrolladora);
                accesorios.add(accesorio);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los accesorios"+e.getMessage(),e);
        }
        return accesorios;
    }
    public void agregarAccesorio(String nombre,Double precio,int existencias,int id_dessarroladora)throws SQLException{
        String sql="INSERT INTO accesorio(nombre,precio,existencias,id_desarrolladora) VALUES(?,?,?,?)";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.setDouble(2,precio);
            stmt.setInt(4,existencias);
            stmt.setInt(5,id_dessarroladora);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error al obtener los accesorios"+e.getMessage(),e);
        }
    }
    public void eliminarAccesorio(int id)throws SQLException{
        String sql="DELETE FROM accesorio WHERE id=?";
        try (PreparedStatement stmt= conexion.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error al eliminar el accesorio: "+e.getMessage());
        }
    }
}
