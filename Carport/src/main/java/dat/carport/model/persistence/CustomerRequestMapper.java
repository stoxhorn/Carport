package dat.carport.model.persistence;

import dat.carport.model.entities.DBEntities.DBCustomerRequest;
import dat.carport.model.entities.Enums.Status;
import dat.carport.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRequestMapper {

    ConnectionPool connectionPool;

    public CustomerRequestMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<DBCustomerRequest> getCustomerRequest() throws DatabaseException {
        List<DBCustomerRequest> customerRequestList = new ArrayList<>();

        String sql = "SELECT * FROM customer_request WHERE deleted_at IS NULL";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String customerUserEmail = rs.getString("customer_user_email");
                    String carportWidth = rs.getString("carport_width");
                    String carportLength = rs.getString("carport_length");
                    String roofType = rs.getString("roof_type");
                    String roofMaterial = rs.getString("roof_material");
                    String roofSlope = rs.getString("roof_slope");
                    String shedWidth = rs.getString("shed_width");
                    String shedLength= rs.getString("shed_length");
                    Status status = Status.valueOf(rs.getString("status"));
                    DBCustomerRequest customerRequest = new DBCustomerRequest(id, customerUserEmail, carportWidth, carportLength, roofType, roofMaterial, roofSlope, shedWidth, shedLength, status);

                    customerRequestList.add(customerRequest);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to get customer requests");
        }
        return customerRequestList;
    }

    public DBCustomerRequest readCustomerRequest(int id) throws DatabaseException {
        DBCustomerRequest customerRequest = null;
        String sql = "SELECT customer_user_email, carport_width, carport_length, roof_type, roof_material, roof_slope, shed_width, shed_length FROM customer_request " +
                "WHERE id = ? AND deleted_at = NULL";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String customerUserEmail = rs.getString("customer_user_email");
                    String carportWidth = rs.getString("carport_width");
                    String carportLength = rs.getString("carport_length");
                    String roofType = rs.getString("roof_type");
                    String roofMaterial = rs.getString("roof_material");
                    String roofSlope = rs.getString("roof_slope");
                    String shedWidth = rs.getString("shed_width");
                    String shedLength = rs.getString("shed_length");
                    Status status = Status.valueOf(rs.getString("status"));
                    customerRequest = new DBCustomerRequest(id, customerUserEmail, carportWidth, carportLength, roofType, roofMaterial, roofSlope, shedWidth, shedLength, status);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to read customer with id:" + id);
        }
        return customerRequest;
    }

    public void createCustomerRequest(DBCustomerRequest customerRequest) throws DatabaseException {
        String sql = "INSERT INTO customer_request (customer_user_email, status, carport_width, carport_length, roof_type, roof_material, roof_slope, shed_width, shed_length, created_at, updated_at)" +
                "VALUES (?,?,?,?,?,?,?,?,?, NOW(), NOW())";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, customerRequest.getCustomerUserEmail());
                ps.setString(2, String.valueOf(Status.pending));
                ps.setString(3, customerRequest.getCarportWidth());
                ps.setString(4, customerRequest.getCarportLength());
                ps.setString(5, customerRequest.getRoofType());
                ps.setString(6, customerRequest.getRoofMaterial());
                ps.setString(7, customerRequest.getRoofSlope());
                ps.setString(8, customerRequest.getShedWidth());
                ps.setString(9, customerRequest.getShedLength());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected != 1)
                {
                    throw new DatabaseException("The CustomerRequest with email = " + customerRequest.getCustomerUserEmail() + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to create customer request: " + customerRequest);
        }
    }

    public void deleteCustomerRequest(DBCustomerRequest customerRequest) throws DatabaseException {
        String sql = "INSERT INTO customer_request (deleted_at) " +
                "VALUES (NOW()) WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, customerRequest.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to delete customer request: " + customerRequest);
        }
    }

    public void updateCustomerRequest(DBCustomerRequest customerRequest) throws DatabaseException {
        String sql = "UPDATE customer_request " +
                "SET customer_user_email = ?, carport_width = ?, carport_length = ?, roof_type = ?, roof_material = ?, roof_slope = ?, shed_width = ?, shed_length = ?, updated_at = NOW()" +
                " customer_user_email = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, customerRequest.getCustomerUserEmail());
                ps.setString(2, customerRequest.getCarportWidth());
                ps.setString(3, customerRequest.getCarportLength());
                ps.setString(4, customerRequest.getRoofType());
                ps.setString(5, customerRequest.getRoofMaterial());
                ps.setString(6, customerRequest.getRoofSlope());
                ps.setString(7, customerRequest.getShedWidth());
                ps.setString(8, customerRequest.getShedLength());
                ps.setInt(9, customerRequest.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to update customer request: " + customerRequest);
        }
    }
}
