package dat.carport.model.persistence;

import dat.carport.model.entities.DBEntities.DBCustomer;
import dat.carport.model.entities.ServiceEntities.Customer;
import dat.carport.model.entities.ServiceEntities.Materials;
import dat.carport.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerInfoMapper {

    ConnectionPool connectionPool;

    public CustomerInfoMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<DBCustomer> getCustomerInfo() throws DatabaseException {
        List<DBCustomer> customerInfoList = new ArrayList<>();

        String sql = "SELECT * FROM customer";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String userEmail = rs.getString("user_email");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String address = rs.getString("address");
                    String zipcode = rs.getString("zip_code");
                    String city = rs.getString("city");
                    String phone = rs.getString("phone");
                    DBCustomer customer = new DBCustomer(userEmail, firstName, lastName, address, zipcode, city, phone);
                    customerInfoList.add(customer);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to get customers");
        }
        return customerInfoList;
    }

    public DBCustomer readCustomer(String email) throws DatabaseException {
        DBCustomer customer = null;
        String sql = "SELECT first_name, last_name, address, zip_code, city, phone FROM customer " +
                "WHERE user_email = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String address = rs.getString("address");
                    String zipCode = rs.getString("zip_code");
                    String city = rs.getString("city");
                    String phone = rs.getString("phone");
                    customer = new DBCustomer(email, firstName, lastName, address, zipCode, city, phone);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to read customer with email:" + email);
        }
        return customer;
    }

    public void createCustomer(DBCustomer customer) throws DatabaseException {
        String sql = "INSERT INTO customer (user_email, first_name, last_name, address, zip_code, city, phone)" +
                "VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, customer.getUserEmail());
                ps.setString(2, customer.getFirstName());
                ps.setString(3, customer.getLastName());
                ps.setString(4, customer.getAddress());
                ps.setString(5, customer.getZipcode());
                ps.setString(6, customer.getCity());
                ps.setString(7, customer.getPhone());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to create customer: " + customer);
        }
    }

    public void deleteCustomer(DBCustomer customer) throws DatabaseException {
        String sql = "DELETE FROM customer " +
                "WHERE user_email = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, customer.getUserEmail());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to delete customer: " + customer);
        }
    }

    public void updateCustomer(DBCustomer customer) throws DatabaseException {
        String sql = "UPDATE customer " +
                "SET first_name = ?, last_name = ?, address = ?, zip_code = ?, city = ?, phone = ?  " +
                "WHERE user_email = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                ps.setString(3, customer.getAddress());
                ps.setString(4, customer.getZipcode());
                ps.setString(5, customer.getCity());
                ps.setString(6, customer.getPhone());
                ps.setString(7, customer.getUserEmail());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to update customer: " + customer);
        }
    }
}
