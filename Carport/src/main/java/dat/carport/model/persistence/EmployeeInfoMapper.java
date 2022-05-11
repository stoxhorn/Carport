package dat.carport.model.persistence;

import dat.carport.model.entities.DBEntities.DBEmployee;
import dat.carport.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInfoMapper {

    ConnectionPool connectionPool;

    public EmployeeInfoMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<DBEmployee> getEmployee() throws DatabaseException {
        List<DBEmployee> employeeList = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String email = rs.getString("user_email");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    DBEmployee employee = new DBEmployee(email, firstName, lastName);
                    employeeList.add(employee);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to get employees");
        }
        return employeeList;
    }

    public DBEmployee readEmployee(String email) throws DatabaseException {
        DBEmployee employee = null;
        String sql = "SELECT first_name, last_name FROM employee " +
                "WHERE user_email = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    employee = new DBEmployee(email, firstName, lastName);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to read employee with email:" + email);
        }
        return employee;
    }

    public void createEmployee(DBEmployee employee) throws DatabaseException {
        String sql = "INSERT INTO employee (user_email, first_name, last_name)" +
                "VALUES (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, employee.getUserEmail());
                ps.setString(2, employee.getFirstName());
                ps.setString(3, employee.getLastName());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to create employee: " + employee);
        }
    }

    public void deleteEmpoyee(DBEmployee employee) throws DatabaseException {
        String sql = "DELETE FROM employee " +
                "WHERE user_email = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, employee.getUserEmail());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to delete employee: " + employee);
        }
    }

    public void updateEmployee(DBEmployee employee) throws DatabaseException {
        String sql = "UPDATE employee " +
                "SET first_name = ?, last_name = ? " +
                "WHERE user_email = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, employee.getFirstName());
                ps.setString(2, employee.getLastName());
                ps.setString(3, employee.getUserEmail());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occurred while trying to update employee: " + employee);
        }
    }
}
