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
    public List<Desarrolladora> obtenerDesarrolladora() {
        List<Desarrolladora> desarrolladoras = new ArrayList<>();
        String sql = "SELECT id,nombre FROM desarrolladora";
        String nombre;
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                nombre = resultSet.getString("nombre");
                Desarrolladora desarrolladora = new Desarrolladora(id, nombre);
                desarrolladoras.add(desarrolladora);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener los empleado" + e.getMessage(), e);
        }
        return desarrolladoras;
    }
        public void agregarDesarrolladora(String nombre)throws SQLException {
            String sql = "INSERT INTO Desarrolladora(nombre) VALUES(?)";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, nombre);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener la desarrolladora" + e.getMessage(), e);
            }
        }
        public void eliminarDesarrolladora (int id)throws SQLException {
            String sql = "DELETE FROM desarrolladora WHERE id=?";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Error al eliminar la Desarrolladora: " + e.getMessage());
            }
        }
    }
