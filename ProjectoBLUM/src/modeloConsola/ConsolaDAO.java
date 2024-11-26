package modeloConsola;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsolaDAO {
    private Connection conexion;
    public ConsolaDAO(Connection conexion){
        this.conexion=conexion;
    }
    public List<Consola> obtenerConsola() {
        List<Consola> consolas = new ArrayList<>();
        String sql = "SELECT Consola.id,Consola.nombre,precio,existencias,desarrolladora.nombre FROM Consola JOIN desarrolladora ON desarrolladora.id=consola.id_desarrolladora  ORDER BY consola.id asc";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getString("nombre");
                Double precio=resultSet.getDouble("precio");
                int existencias=resultSet.getInt("existencias");
                String nombreDesarrrolladora=resultSet.getString("Desarrolladora.nombre");

                Consola consola=new Consola(id,nombre,precio,existencias,nombreDesarrrolladora);
                consolas.add(consola);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener las consolas"+e.getMessage(),e);
        }
        return consolas;
    }
    public void agregarConsola(String nombre,Double precio,int existencias,int id_dessarrolladora)throws SQLException{
        String sql="INSERT INTO consola(nombre,precio,existencias,id_desarrolladora) VALUES(?,?,?,?)";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.setDouble(2,precio);
            stmt.setInt(3,existencias);
            stmt.setInt(4,id_dessarrolladora);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error al obtener las consolas"+e.getMessage(),e);
        }
    }
    public void eliminarConsola(int id)throws SQLException{
        String sql="DELETE FROM consola WHERE id=?";
        try (PreparedStatement stmt= conexion.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error al eliminar la consola: "+e.getMessage());
        }
    }
    public void editarConsola(String nuevoNombre,Double nuevoPrecio,int nuevoExistencia,int nuevoid_dessarroladora,int id)throws SQLException{
        String sql="UPDATE consola SET nombre=?,precio=?,existencias=?,id_desarrolladora=? WHERE id=?";
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
