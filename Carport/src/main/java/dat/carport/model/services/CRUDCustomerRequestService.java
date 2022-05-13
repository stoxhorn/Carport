package dat.carport.model.services;

import dat.carport.model.entities.DBEntities.DBCustomerRequest;
import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
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

        return null;
    }

    public static void createCustomerRequest(String customerEmail, ConnectionPool connectionPool) throws DatabaseException {




    }

    private static void updateCustomerRequest(String customerEmail){

    }

    private static void deleteCustomerRequest(String customerEmail){

    }
}
