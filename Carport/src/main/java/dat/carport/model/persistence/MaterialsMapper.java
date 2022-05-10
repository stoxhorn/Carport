package dat.carport.model.persistence;

import dat.carport.model.entities.DBEntities.DBMaterials;
import dat.carport.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialsMapper {

    ConnectionPool connectionPool;

    public MaterialsMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<DBMaterials> getMaterials() throws DatabaseException {
        List<DBMaterials> materialsList = new ArrayList<>();

        String sql = "SELECT * FROM materials";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String description = rs.getString("description");
                    DBMaterials material = new DBMaterials(id, description);
                    materialsList.add(material);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to get materials");
        }
        return materialsList;
    }

    public DBMaterials readMaterial(int id) throws DatabaseException {
        DBMaterials material = null;
        String sql = "SELECT description FROM materials " +
                "WHERE productId = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    String description = rs.getString("description");
                    material = new DBMaterials(id, description);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to read material with id:" + id);
        }
        return material;
    }

    public void createMaterial(DBMaterials material) throws DatabaseException {
        String sql = "INSERT INTO materials (id, description)" +
                "VALUES (?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, material.getId());
                ps.setString(2, material.getDescription());
                ps.executeUpdate();
            }
        }
        catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to create material: " + material);
        }
    }

    public void deleteMaterial(DBMaterials material) throws DatabaseException {
        String sql = "DELETE FROM materials" +
                "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, material.getId());
                ps.executeUpdate();
            }
        }
        catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to delete material: " + material);
        }
    }

    public void updateMaterials(DBMaterials material) throws DatabaseException {
        String sql = "UPDATE carport.materials " +
                        "SET description = ? " +
                        "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, material.getDescription());
                ps.setInt(2, material.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to update material: " + material);
        }
    }
}
