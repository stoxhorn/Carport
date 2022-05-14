package dat.carport.model.persistence;

import dat.carport.model.entities.DBEntities.DBCustomerRequest;
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

        String sql = "SELECT * FROM customer_request";

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
                    DBCustomerRequest customerRequest = new DBCustomerRequest(id, customerUserEmail, carportWidth, carportLength, roofType, roofMaterial, roofSlope, shedWidth, shedLength);
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
                "WHERE id = ?";
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
                    customerRequest = new DBCustomerRequest(id, customerUserEmail, carportWidth, carportLength, roofType, roofMaterial, roofSlope, shedWidth, shedLength);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to read employee with id:" + id);
        }
        return customerRequest;
    }

    public void createCustomerRequest(DBCustomerRequest customerRequest) throws DatabaseException {
        String sql = "INSERT INTO customer_request (customer_user_email, carport_width, carport_length, roof_type, roof_material, roof_slope, shed_width, shed_length)" +
                "VALUES (?,?,?,?,?,?,?,?)";
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
        String sql = "DELETE FROM customer_request " +
                "WHERE id = ?";
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
                "SET customer_user_email = ?, carport_width = ?, carport_length = ?, roof_type = ?, roof_material = ?, roof_slope = ?, shed_width = ?, shed_length = ? " +
                "WHERE customer_user_email = ?";
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
