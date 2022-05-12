package dat.carport.model.persistence;

import dat.carport.model.entities.DBEntities.DBMaterialsListLines;
import dat.carport.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialListLinesMapper {

    ConnectionPool connectionPool;

    public MaterialListLinesMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<DBMaterialsListLines> getMaterialListLines() throws DatabaseException {
        List<DBMaterialsListLines> materialsListLines = new ArrayList<>();

        String sql = "SELECT * FROM materials_list_lines";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int materialsListId = rs.getInt("materials_list_id");
                    int materialsId = rs.getInt("materials_id");
                    String description = rs.getString("description");
                    int quantity = rs.getInt("quantity");
                    DBMaterialsListLines materialsListLine = new DBMaterialsListLines(id, materialsListId, materialsId, description, quantity);
                    materialsListLines.add(materialsListLine);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to get material list lines");
        }
        return materialsListLines;
    }

    public DBMaterialsListLines readMaterialListLines(int id) throws DatabaseException {
        DBMaterialsListLines materialsListLines = null;
        String sql = "SELECT materials_list_id, materials_id, description, qantity FROM materials_list_lines " +
                "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    int materialsListId = rs.getInt("materials_list_id");
                    int materialsId = rs.getInt("materials_id");
                    String description = rs.getString("description");
                    int quantity = rs.getInt("quantity");
                    materialsListLines = new DBMaterialsListLines(id, materialsListId, materialsId, description, quantity);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to read material list line with id:" + id);
        }
        return materialsListLines;
    }

    public void createMaterialListLines(DBMaterialsListLines materialsListLines) throws DatabaseException {
        String sql = "INSERT INTO materials_list_lines (id, description)" +
                "VALUES (?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialsListLines.getId());
                ps.setInt(2, materialsListLines.getMaterialsListId());
                ps.setInt(3, materialsListLines.getMaterialsId());
                ps.setString(4, materialsListLines.getDescription());
                ps.setInt(5, materialsListLines.getQuantity());
                ps.executeUpdate();
            }
        }
        catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to create material list line: " + materialsListLines);
        }
    }

    public void deleteMaterialListLines(DBMaterialsListLines materialsListLines) throws DatabaseException {
        String sql = "DELETE FROM materials_list_lines " +
                "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialsListLines.getId());
                ps.executeUpdate();
            }
        }
        catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to delete material list line: " + materialsListLines);
        }
    }

    public void updateMaterialListLines(DBMaterialsListLines materialsListLines) throws DatabaseException {
        String sql = "UPDATE materials_list_lines " +
                "SET materials_list_id = ?, materials_id = ?, description = ?, qantity = ? " +
                "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialsListLines.getMaterialsListId());
                ps.setInt(2, materialsListLines.getMaterialsId());
                ps.setString(3, materialsListLines.getDescription());
                ps.setInt(4, materialsListLines.getQuantity());
                ps.setInt(5, materialsListLines.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to update material list line: " + materialsListLines);
        }
    }
}
