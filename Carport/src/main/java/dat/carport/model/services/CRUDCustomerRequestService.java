package dat.carport.model.services;

import dat.carport.model.entities.DBEntities.DBCustomer;
import dat.carport.model.entities.DBEntities.DBCustomerRequest;
import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.entities.ServiceEntities.CustomerRequestData;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.CustomerInfoMapper;
import dat.carport.model.persistence.CustomerRequestMapper;

import java.util.ArrayList;

public class CRUDCustomerRequestService {


    public static CustomerRequest readCustomerRequest(String customerEmail, ConnectionPool connectionPool) throws DatabaseException {
        CustomerRequestMapper crMapper = new CustomerRequestMapper(connectionPool);
        ArrayList<DBCustomerRequest> customerList = new ArrayList<>(crMapper.getCustomerRequest());

        for(DBCustomerRequest dbCR : customerList){
            // check if the customer request, turn into service entity and return
            if(dbCR.getCustomerUserEmail().equals(customerEmail)){
                CustomerRequest cr = new CustomerRequest(dbCR);
                cr.fetchMaterialList(connectionPool);
                return cr;
            }
        }
        throw new DatabaseException("there is no CustomerRequest connected to this email");
    }

    public static void createCustomerRequest(String customerEmail, CustomerRequestData crData, ConnectionPool connectionPool) throws DatabaseException {
        CustomerRequestMapper crMapper = new CustomerRequestMapper(connectionPool);

        // in order to add a new Customer Request, i need to figure out the next ID.
        // this is done by finding the highest ID, and incrementing by 1
        int i = -1;
        for(DBCustomerRequest dbCr : crMapper.getCustomerRequest()){
            if(dbCr.getId() > i){
                i = dbCr.getId() +1;
            }
            if(dbCr.getCustomerUserEmail().equals(customerEmail)){
                throw new DatabaseException("there already exists a request with this email");
            }
        }
        // the next Id has been found, and i can now create a DBCustomerRequest Object:
        crMapper.createCustomerRequest(
                new DBCustomerRequest(i, customerEmail, crData));
    }

    public static void updateCustomerRequest(String customerEmail, CustomerRequestData crData, ConnectionPool cp) throws DatabaseException {
        CustomerRequestMapper crMapper = new CustomerRequestMapper(cp);

        // in order to update a customer request, i need to find the ID corresponding to the customer Email
        // there is a 1:1 relation
        // this is done by finding the highest ID, and incrementing by 1
        int id = -1;
        for(DBCustomerRequest dbCr : crMapper.getCustomerRequest()){
            if(dbCr.getCustomerUserEmail().equals(customerEmail)){
                id = dbCr.getId();
                break;
            }
        }

        if(id < 0){
            throw new DatabaseException("there is no customer request with this ID");
        }
        // the next Id has been found, and i can now create a DBCustomerRequest Object:
        crMapper.updateCustomerRequest(
                new DBCustomerRequest(id, customerEmail, crData));
    }

    public static void deleteCustomerRequest(String customerEmail, ConnectionPool cp) throws DatabaseException {
        CustomerRequestMapper crMapper = new CustomerRequestMapper(cp);

        for(DBCustomerRequest dbCr : crMapper.getCustomerRequest()){
            if(dbCr.getCustomerUserEmail().equals(customerEmail)){
                crMapper.deleteCustomerRequest(dbCr);
                break;
            }
        }
    }
}
