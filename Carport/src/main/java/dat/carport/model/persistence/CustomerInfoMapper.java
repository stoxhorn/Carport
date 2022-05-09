package dat.carport.model.persistence;

import dat.carport.model.entities.ServiceEntities.Customer;
import dat.carport.model.exceptions.DatabaseException;

import java.util.List;

public class CustomerInfoMapper {

    ConnectionPool connectionPool;

    public CustomerInfoMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<Customer> getCustomers() throws DatabaseException {

    }
}
