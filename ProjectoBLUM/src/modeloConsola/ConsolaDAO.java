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
        String sql = "SELECT id,nombre,precio,existencias,desarrolladora.id_desarrolladora,desarrolladora.nombre FROM Consola JOIN desarrolladora ON desarrolladora.id=consola.id_desarrolladora";
        try (PreparedStatement statement= conexion.prepareStatement(sql);
             ResultSet resultSet=statement.executeQuery()){
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getString("nombre");
                Double precio=resultSet.getDouble("precio");
                int existencias=resultSet.getInt("existencias");
                int id_desarroladora=resultSet.getInt("id Desarroladora");
                String nombreDesarrrolladora=resultSet.getString("Desarrolladora");

                Consola consola=new Consola(id,nombre,precio,existencias,id_desarroladora,nombreDesarrrolladora);
                consolas.add(consola);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener las consolas"+e.getMessage(),e);
        }
        return consolas;
    }
    public void agregarConsola(String nombre,Double precio,int existencias,int id_dessarroladora)throws SQLException{
        String sql="INSERT INTO consola(nombre,precio,existencias,id_desarrolladora) VALUES(?,?,?,?)";
        try(PreparedStatement stmt=conexion.prepareStatement(sql)){
            stmt.setString(1,nombre);
            stmt.setDouble(2,precio);
            stmt.setInt(4,existencias);
            stmt.setInt(5,id_dessarroladora);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Error al obtener las consolas"+e.getMessage(),e);
        }
    }
}
