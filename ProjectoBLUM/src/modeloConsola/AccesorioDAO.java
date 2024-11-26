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
        String sql = "SELECT accesorio.id,accesorio.nombre,precio,existencias,desarrolladora.nombre FROM accesorio JOIN desarrolladora ON desarrolladora.id=consola.id_desarrolladora  ORDER BY accesorio.id asc";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("accesorio.id");
                String nombre=resultSet.getString("accesorio.nombre");
                Double precio=resultSet.getDouble("precio");
                int existencias=resultSet.getInt("existencias");
                String nombreDesarrrolladora=resultSet.getString("Desarrolladora.nombre");

                Accesorio accesorio=new Accesorio(id,nombre,precio,existencias,nombreDesarrrolladora);
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
            throw new RuntimeException("Error al agregar los accesorios"+e.getMessage(),e);
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
    public void editarAccesorio(String nuevoNombre,Double nuevoPrecio,int nuevoExistencia,int nuevoid_dessarroladora,int id)throws SQLException{
        String sql="UPDATE accesorio SET nombre=?,precio=?,existencias=?,id_desarrolladora=? WHERE id=?";
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
