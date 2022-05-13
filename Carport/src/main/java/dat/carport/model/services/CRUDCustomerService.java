package dat.carport.model.services;

import dat.carport.model.entities.DBEntities.DBCustomer;
import dat.carport.model.entities.ServiceEntities.Customer;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.CustomerInfoMapper;

public class CRUDCustomerService {

    public static Customer readCustomer(String customerEmail, ConnectionPool cp) throws DatabaseException {
        CustomerInfoMapper ciMapper = new CustomerInfoMapper(cp);
        for(DBCustomer dbc : ciMapper.getCustomerInfo()){
            if(dbc.getUserEmail().equals(customerEmail)){
                return new Customer(dbc);
            }
        }
        return null;
    }
}
