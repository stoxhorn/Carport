package dat.carport.model.persistence;

import dat.carport.model.entities.DBEntities.DBMaterialsList;
import dat.carport.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialListMapper {

    ConnectionPool connectionPool;

    public MaterialListMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<DBMaterialsList> getMaterialList() throws DatabaseException {
        List<DBMaterialsList> materialsListList = new ArrayList<>();

        String sql = "SELECT * FROM carport.materials_list";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int customerRequestId = rs.getInt("customer_request_id");
                    DBMaterialsList materialsList = new DBMaterialsList(id, customerRequestId);
                    materialsListList.add(materialsList);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to get material list");
        }
        return materialsListList;
    }

    public DBMaterialsList readMaterialList(int id) throws DatabaseException {
        DBMaterialsList material = null;
        String sql = "SELECT customer_request_id FROM carport.materials_list " +
                "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int customerRequestId = rs.getInt("customer_request_id");
                    material = new DBMaterialsList(id, customerRequestId);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to read material list with id:" + id);
        }
        return material;
    }

    public void createMaterial(DBMaterialsList materialsList) throws DatabaseException {
        String sql = "INSERT INTO materials_list (id, customer_request_id)" +
                "VALUES (?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialsList.getId());
                ps.setInt(2, materialsList.getCustomerRequestId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to create material list: " + materialsList);
        }
    }

    public void deleteMaterial(DBMaterialsList materialsList) throws DatabaseException {
        String sql = "DELETE FROM materials_list" +
                "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialsList.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to delete material list: " + materialsList);
        }
    }

    public void updateMaterials(DBMaterialsList materialsList) throws DatabaseException {
        String sql = "UPDATE carport.materials_list " +
                "SET customer_request_id = ? " +
                "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialsList.getCustomerRequestId());
                ps.setInt(2, materialsList.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to update material list: " + materialsList);
        }
    }
}
